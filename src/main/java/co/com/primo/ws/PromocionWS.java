/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Promocion;
import co.com.primo.service.PromocionService;
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
 * Clase que implementa el Promocion Web del objeto Promocion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PromocionWS {

    /** Atributos de Metodo **/
    @Autowired
    private PromocionService myPromocionService;

    /**
     * Función que inserta la información del Promocion en la Base de Datos
     * @param myPromocion
     * @return @ResponseBody
     */
    @RequestMapping(value="/promocion",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PrimoMsg agregarPromocion(@RequestBody Promocion myPromocion){
        
        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Insertar la información del Promocion
        if(myPromocionService.agregarPromocion(myPromocion) == null){
            //Configurar el mensaje de Exito
            msg.setResponse("Promocion creada");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al insertar la información de la Promocion");
        msg.setSucces(false);
        return msg;
    }

    /**
     * Función que trae la información de la Promocion
     * @param myIdPromocion
     * @return  ResponseEntity<Promocion>
     */
    @RequestMapping(value="/promocion/{myIdPromocion}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<Promocion> traerPromocion(@PathVariable("myIdPromocion") BigInteger myIdPromocion){
        
        //Atributo de Método
        Promocion myPromocion = new Promocion();
        myPromocion.setIdPromocion(myIdPromocion);
        
        //Consultar la información de la Promocion
        myPromocion = myPromocionService.traerPromocion(myPromocion);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myPromocion,HttpStatus.OK);
    }

    /**
     * Función que actualiza la información del Promocion
     * @param myPromocion
     * @return @ResponseBody
     */
    @RequestMapping(value="/actualizarPromocion",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody PrimoMsg actualizarPromocion(@RequestBody Promocion myPromocion){

        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Actualizar la información del Promocion
        if(myPromocionService.actualizarPromocion(myPromocion) == null){

            //Configurar el mensaje de Exito
            msg.setResponse("Promocion actualizada");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al actualizar la información de la Promocion");
        msg.setSucces(false);
        return msg;
    }
}