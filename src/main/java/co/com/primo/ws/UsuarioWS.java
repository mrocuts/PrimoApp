/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Dominio;
import co.com.primo.model.Garaje;
import co.com.primo.model.Log;
import co.com.primo.model.Usuario;
import co.com.primo.service.GarajeService;
import co.com.primo.service.LogService;
import co.com.primo.service.UsuarioService;
import co.com.primo.util.EmailService;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UsuarioWS {

    @Autowired
    private UsuarioService myUsuarioService;

    @Autowired
    private LogService myLogService;

    @Autowired
    private GarajeService myGarajeService;

    @RequestMapping(value="/usuario",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody PrimoMsg insertarUsuario(@RequestBody Usuario user){
        PrimoMsg msg = new PrimoMsg();
        System.out.println("Servicio invocado... "+user.getStrUsuario());
        if(myUsuarioService.traerUsuario(user.getStrUsuario())== null){
            user.setStrPassword(DigestUtils.md5Hex(user.getStrPassword()));
            Usuario myUsuarioCreado = myUsuarioService.agregarUsuario(user);
            
            //Verificar el Usuario Creado y que sea de tipo Usuario
            if(myUsuarioCreado != null && myUsuarioCreado.getIntTipoUsuario().intValue() == 2){
                //Crear el Objeto Garaje
                myGarajeService.agregarGaraje(new Garaje(new Date().toString(), true, myUsuarioCreado));
                System.out.println("Garaje registrado con exito.");
            }
            
            System.out.println("Usuario registrado con exito.");
            msg.setResponse("Usuario creado");
            msg.setSucces(true);
            return msg;
        }
        msg.setResponse("Usuario ya registrado");
        msg.setSucces(false);
        return msg;
    }

    @RequestMapping(value="/login/{usuario}/{password}/{intTipoUsuario}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public Usuario login(@PathVariable("usuario") String myUser,@PathVariable("password") String myPass,
                                         @PathVariable("intTipoUsuario") String intTipoUsuario){
        //Atributos de Metodo
        Usuario myUsuario = new Usuario();
        Usuario myUsuarioAuth = new Usuario();
        Usuario myUsuarioVerificado = new Usuario();
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        myUsuario.setStrUsuario(myUser);
        myUsuario.setStrPassword(DigestUtils.md5Hex(myPass));
        myUsuario.setIntTipoUsuario(new BigInteger(intTipoUsuario));
        System.out.println("USUARIO: "+myUser+" "+myPass+" "+intTipoUsuario);
        System.out.println("Contraseña cifrada: "+myUsuario.getStrPassword());
        //Traer el Usuario
        myUsuarioAuth = myUsuarioService.login(myUsuario);
        
        //Verificar que sea un usuario válido
        if(myUsuarioAuth != null){
            //Reiniciar el número de intentos
            if(myUsuarioAuth.getIntNumIntentos() != 0){
                myUsuarioAuth.setIntNumIntentos(0);
                
                //Actualizar el usuario
               // myUsuarioService.actualizarUsuario(myUsuarioAuth);                
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
                //myUsuarioService.actualizarUsuario(myUsuarioVerificado);
            }
        }
        
        return myUsuarioAuth;
    }

    @RequestMapping(value="/recuperar/{usuario}/",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<String> recuperarContrasena(@PathVariable("usuario") String myUser){
        //Atributos de Metodo
        Usuario myUsuario = new Usuario();
        String myResultado;
        Usuario myUsuarioVerificado;
        EmailService myEmailService = new EmailService();
        System.out.println(myUser);
        myUsuario.setStrUsuario(myUser);
        
        //Traer el Usuario
        myUsuarioVerificado = myUsuarioService.verificarUsuario(myUsuario);
        
        //Verificar que sea un usuario válido
        if(myUsuarioVerificado != null){
            //Enviar Correo
            myEmailService.enviarCorreo(myUsuarioVerificado.getStrUsuario());
            myResultado = "OK";
        }
        else{
            //Verificar que exista el mail
            myResultado = "El Usuario no existe";            
        }
        
        //Retornar el resultado
        return new ResponseEntity<String>(myResultado,HttpStatus.OK);
    }
    
    @RequestMapping(value="/cambiarContrasena",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<String> cambiarContrasena(@RequestBody Usuario myUser){

        //Atributos de Metodo
        Usuario myUsuario = new Usuario();
        String myResultado;
        Usuario myUsuarioVerificado;
        myUsuario.setStrUsuario(myUser.getStrUsuario());
        
        //Traer el Usuario
        myUsuarioVerificado = myUsuarioService.verificarUsuario(myUsuario);
        
        //Verificar que sea un usuario válido
        if(myUsuarioVerificado != null){
            //Cambiar
            myUsuarioVerificado.setStrPassword(DigestUtils.md5Hex(myUser.getStrPassword()));
            myUsuarioService.actualizarUsuario(myUsuarioVerificado);
            myResultado = "OK";
        }
        else{
            //Verificar que exista el mail
            myResultado = "El Usuario no existe";            
        }
        
        //Retornar el resultado
        return new ResponseEntity<>(myResultado,HttpStatus.OK);
    }
}
