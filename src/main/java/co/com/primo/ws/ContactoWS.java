/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Contacto;
import co.com.primo.service.ContactoService;
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

    /**
     * Función que inserta la información del Contacto en la Base de Datos
     * @param myContacto
     * @return @ResponseBody
     */
    @RequestMapping(value="/contacto",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PrimoMsg agregarContacto(@RequestBody Contacto myContacto){
        
        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Insertar la información del Contacto
        if(myContactoService.agregarContacto(myContacto) != null){
            //Configurar el mensaje de Exito
            msg.setResponse("Contacto creado");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al insertar la información de la empresa");
        msg.setSucces(false);
        return msg;
    }

    /**
     * Función que trae la información de los Contactos asosiados a una empresa
     * @param myIdEmpresa
     * @return  ResponseEntity<List<Contacto>>
     */
    @RequestMapping(value="/contacto/{myIdEmpresa}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Contacto>> traerContactosPorEmpresa(@PathVariable("myIdEmpresa") BigInteger myIdEmpresa){
        
        //Consultar la lista de Contactos asociadas a una Empresa
        List<Contacto> myListContacto = myContactoService.traerContactoPorEmpresa(myIdEmpresa);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myListContacto,HttpStatus.OK);
    }

    /**
     * Función que actualiza la información del Contacto
     * @param myContacto
     * @return @ResponseBody
     */
    @RequestMapping(value="/actualizarContacto",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody PrimoMsg actualizarContacto(@RequestBody Contacto myContacto){

        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Actualizar la información del Contacto
        if(myContactoService.actualizarContacto(myContacto) == null){

            //Configurar el mensaje de Exito
            msg.setResponse("Contacto actualizado");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al actualizar la información del Contacto");
        msg.setSucces(false);
        return msg;
    }
}