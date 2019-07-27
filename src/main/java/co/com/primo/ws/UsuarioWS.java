/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Usuario;
import co.com.primo.service.UsuarioService;
import java.math.BigInteger;
import javax.ws.rs.PathParam;
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

    @RequestMapping(value="/usuario",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody BigInteger insertarUsuario(@RequestBody Usuario myUsuario){
        if(myUsuarioService.traerUsuario(myUsuario.getStrUsuario())== null){
            Usuario myUsuarioNew = myUsuarioService.agregarUsuario(myUsuario);
            System.out.println("Usuario registrado con exito.");
            return myUsuarioNew.getIdUsuario();
        }
        System.out.println("Se ha encontrado un usuario con el mismo correo electronico.");
        return null;
    }

    @RequestMapping(value="/login/{usuario}/{password}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<Usuario> login(@PathVariable("usuario") String myUser,@PathVariable("password") String myPass){
        Usuario myUsuario = new Usuario();
        myUsuario.setStrUsuario(myUser);
        myUsuario.setStrPassword(myPass);
        return new ResponseEntity<Usuario>(myUsuarioService.login(myUsuario),HttpStatus.OK);
    }
}
