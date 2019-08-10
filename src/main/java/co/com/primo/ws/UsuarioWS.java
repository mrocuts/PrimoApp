/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Dominio;
import co.com.primo.model.Log;
import co.com.primo.model.Usuario;
import co.com.primo.service.LogService;
import co.com.primo.service.UsuarioService;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Servicio Web del objeto Usuario
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 21/07/2019
 */
@RestController
public class UsuarioWS {

    @Autowired
    private UsuarioService myUsuarioService;

    @Autowired
    private LogService myLogService;

    @RequestMapping(value="/usuario",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody BigInteger insertarUsuario(@RequestBody Usuario myUsuario){
        Usuario myUsuarioNew = myUsuarioService.agregarUsuario(myUsuario);
        return myUsuarioNew.getIdUsuario();
    }

    @RequestMapping(value="/login/{usuario}/{password}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<Usuario> login(@PathVariable("usuario") String myUser,@PathVariable("password") String myPass){
        //Atributos de Metodo
        Usuario myUsuario = new Usuario();
        Usuario myUsuarioAuth = new Usuario();
        Usuario myUsuarioVerificado = new Usuario();
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        myUsuario.setStrUsuario(myUser);
        myUsuario.setStrPassword(DigestUtils.md5Hex(myPass));
        
        //Traer el Usuario
        myUsuarioAuth = myUsuarioService.login(myUsuario);
        
        //Verificar que sea un usuario válido
        if(myUsuarioAuth != null){
            //Reiniciar el número de intentos
            if(myUsuarioAuth.getIntNumIntentos() != 0){
                myUsuarioAuth.setIntNumIntentos(0);
                
                //Actualizar el usuario
                myUsuarioService.actualizarUsuario(myUsuarioAuth);                
            }
            
            //Crear el objeto Log
            Log myLog = new Log();
            myLog.setMyUsuario(myUsuarioAuth);
            myLog.setMyDominio(new Dominio(BigInteger.ONE));
            myLog.setDtmFecha(myFormat.format(new Date()));
            myLog.setStrAccion("AUTENTICACION EN EL SISTEMA");

            //Guardar el registro del Log
            myLogService.agregarLog(myLog);
        }
        else{
            //Verificar que exista el mail
            myUsuarioVerificado = myUsuarioService.verificarUsuario(myUsuario);
            
            //Verificar que existe el Usuario
            if(myUsuarioVerificado != null){
                //Verificar el numero de intentos
                if(myUsuarioVerificado.getIntNumIntentos() == 3){
                    myUsuarioVerificado.setBitActivo(false);
                }
                else{
                    myUsuarioVerificado.setIntNumIntentos(myUsuarioVerificado.getIntNumIntentos() + 1);
                }
                
                //Actualizar el usuario
                myUsuarioService.actualizarUsuario(myUsuarioVerificado);
            }
        }
        
        return new ResponseEntity<Usuario>(myUsuarioAuth,HttpStatus.OK);
    }
}
