/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Direccion;
import co.com.primo.service.DireccionService;
import java.math.BigInteger;
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
 * Clase que implementa el Servicio Web del objeto Direccion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
 */
@RestController
public class DireccionWS {

    /** Atributos de Metodo **/
    @Autowired
    private DireccionService myDireccionService;

    /**
     * Función que inserta la información del Direccion en la Base de Datos
     * @param myDireccion
     * @return @ResponseBody
     */
    @RequestMapping(value="/direccion",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PrimoMsg agregarDireccion(@RequestBody Direccion myDireccion){
        
        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Insertar la información del Direccion
        if(myDireccionService.agregarDireccion(myDireccion) == null){
            //Configurar el mensaje de Exito
            msg.setResponse("Direccion creada");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al insertar la información de la Direccion");
        msg.setSucces(false);
        return msg;
    }

    /**
     * Función que trae la información de la Direccion
     * @param myIdDireccion
     * @return  ResponseEntity<Direccion>
     */
    @RequestMapping(value="/direccion/{myIdDireccion}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<Direccion> traerDireccion(@PathVariable("myIdDireccion") BigInteger myIdDireccion){
        
        //Atributo de Método
        Direccion myDireccion = new Direccion();
        myDireccion.setIdDireccion(myIdDireccion);
        
        //Consultar la información de la Direccion
        myDireccion = myDireccionService.traerDireccion(myDireccion);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myDireccion,HttpStatus.OK);
    }

    /**
     * Función que actualiza la información del Direccion
     * @param myDireccion
     * @return @ResponseBody
     */
    @RequestMapping(value="/actualizarDireccion",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody PrimoMsg actualizarDireccion(@RequestBody Direccion myDireccion){

        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Actualizar la información del Direccion
        if(myDireccionService.actualizarDireccion(myDireccion) == null){

            //Configurar el mensaje de Exito
            msg.setResponse("Direccion actualizada");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al actualizar la información de la Direccion");
        msg.setSucces(false);
        return msg;
    }
}