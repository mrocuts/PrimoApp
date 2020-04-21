/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Servicio;
import co.com.primo.service.ServicioService;
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
 * Clase que implementa el Servicio Web del objeto Servicio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
 */
@RestController
public class ServicioWS {

    /** Atributos de Metodo **/
    @Autowired
    private ServicioService myServicioService;

    /**
     * Función que inserta la información del Servicio en la Base de Datos
     * @param myServicio
     * @return @ResponseBody
     */
    @RequestMapping(value="/servicio",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PrimoMsg agregarServicio(@RequestBody Servicio myServicio){
        
        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Insertar la información del Servicio
        if(myServicioService.agregarServicio(myServicio) == null){
            //Configurar el mensaje de Exito
            msg.setResponse("Servicio creado");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al insertar la información del Servicio");
        msg.setSucces(false);
        return msg;
    }

    /**
     * Función que trae la información de la Servicio
     * @param myIdServicio
     * @return  ResponseEntity<Servicio>
     */
    @RequestMapping(value="/servicio/{myIdServicio}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<Servicio> traerServicio(@PathVariable("myIdServicio") BigInteger myIdServicio){
        
        //Atributo de Método
        Servicio myServicio = new Servicio();
        myServicio.setIdservicio(myIdServicio);
        
        //Consultar la información de la Servicio
        myServicio = myServicioService.traerServicio(myServicio);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myServicio,HttpStatus.OK);
    }

    /**
     * Función que actualiza la información del Servicio
     * @param myServicio
     * @return @ResponseBody
     */
    @RequestMapping(value="/actualizarServicio",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody PrimoMsg actualizarServicio(@RequestBody Servicio myServicio){

        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Actualizar la información del Servicio
        if(myServicioService.actualizarServicio(myServicio) == null){

            //Configurar el mensaje de Exito
            msg.setResponse("Servicio actualizado");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al actualizar la información del Servicio");
        msg.setSucces(false);
        return msg;
    }
}