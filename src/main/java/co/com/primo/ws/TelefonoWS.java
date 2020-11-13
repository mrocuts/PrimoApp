/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Telefono;
import co.com.primo.service.TelefonoService;
import java.math.BigInteger;
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
 * Clase que implementa el Servicio Web del objeto Telefono
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class TelefonoWS {

    /** Atributos de Metodo **/
    @Autowired
    private TelefonoService myTelefonoService;

    /**
     * Función que inserta la información del Telefono en la Base de Datos
     * @param myTelefono
     * @return @ResponseBody
     */
    @RequestMapping(value="/telefono",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PrimoMsg agregarTelefono(@RequestBody Telefono myTelefono){
        
        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Insertar la información del Telefono
        if(myTelefonoService.agregarTelefono(myTelefono) == null){
            //Configurar el mensaje de Exito
            msg.setResponse("Telefono creado");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al insertar la información del Telefono");
        msg.setSucces(false);
        return msg;
    }

    /**
     * Función que trae la información de la Telefono
     * @param myIdTelefono
     * @return  ResponseEntity<Telefono>
     */
    @RequestMapping(value="/telefono/{myIdTelefono}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<Telefono> traerTelefono(@PathVariable("myIdTelefono") BigInteger myIdTelefono){
        
        //Atributo de Método
        Telefono myTelefono = new Telefono();
        myTelefono.setIdTelefono(myIdTelefono);
        
        //Consultar la información de la Telefono
        myTelefono = myTelefonoService.traerTelefono(myTelefono);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myTelefono,HttpStatus.OK);
    }

    /**
     * Función que actualiza la información del Telefono
     * @param myTelefono
     * @return @ResponseBody
     */
    @RequestMapping(value="/actualizarTelefono",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody PrimoMsg actualizarTelefono(@RequestBody Telefono myTelefono){

        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Actualizar la información del Telefono
        if(myTelefonoService.actualizarTelefono(myTelefono) == null){

            //Configurar el mensaje de Exito
            msg.setResponse("Telefono actualizado");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al actualizar la información del Telefono");
        msg.setSucces(false);
        return msg;
    }
}