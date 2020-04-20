/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Contacto;
import co.com.primo.service.ContactoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.math.BigInteger;
import java.util.List;
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
 * Clase que implementa el Servicio Web del objeto Contacto
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
 */
@RestController
public class ContactoWS {

    /** Atributos de Metodo **/
    @Autowired
    private ContactoService myContactoService;
    private final Gson myGson=new GsonBuilder().setDateFormat("dd-MM-yyyy").create();

    /**
     * Función que inserta la información del Contacto en la Base de Datos
     * @param myContacto
     * @return @ResponseBody
     */
    @RequestMapping(value="/contacto",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> agregarContacto(@RequestBody Contacto myContacto){
        PrimoMsg msg = new PrimoMsg();
        try{
            if(myContactoService.agregarContacto(myContacto) != null){
                msg.setResponse("Contacto creado");
                msg.setSucces(true);
            }else{
                msg.setResponse("Error al insertar la información de la empresa");
                msg.setSucces(false);
            }
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.OK);
        }catch(Exception ex){
            msg.setResponse(ex.getMessage());
            msg.setSucces(false);
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Función que trae la información de los Contactos asosiados a una empresa
     * @param myIdEmpresa
     * @return  ResponseEntity<List<Contacto>>
     */
    @RequestMapping(value="/contacto/{myIdEmpresa}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<String> traerContactosPorEmpresa(@PathVariable("myIdEmpresa") BigInteger myIdEmpresa){
        List<Contacto> contactos = myContactoService.traerContactoPorEmpresa(myIdEmpresa);
        return new ResponseEntity<>(myGson.toJson(contactos),HttpStatus.OK);
    }

    /**
     * Función que actualiza la información del Contacto
     * @param myContacto
     * @return @ResponseBody
     */
    @RequestMapping(value="/actualizarContacto",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody ResponseEntity<String> actualizarContacto(@RequestBody Contacto myContacto){
        PrimoMsg msg = new PrimoMsg();
        try{
            if(myContactoService.actualizarContacto(myContacto) == null){
                msg.setResponse("Contacto actualizado");
                msg.setSucces(true);
            }else{
                msg.setResponse("Error al actualizar la información del Contacto");
                msg.setSucces(false);
            }
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.OK);
        }catch(Exception ex){
            msg.setResponse(ex.getMessage());
            msg.setSucces(false);
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.BAD_REQUEST);
        }
    }
}