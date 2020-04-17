/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Vehiculo;
import co.com.primo.service.VehiculoService;
import com.google.gson.Gson;
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
 * Clase que implementa el Servicio Web del objeto Vehiculo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 03/04/2020
 */
@RestController
public class VehiculoWS {
    
    /** Atributos de Metodo **/
    @Autowired
    private VehiculoService myVehiculoService;

    /**
     * Función que inserta la información del Vehiculo en la Base de Datos
     * @param myVehiculo
     * @return @ResponseBody
     */
    @RequestMapping(value="/vehiculo",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PrimoMsg agregarVehiculo(@RequestBody Vehiculo myVehiculo){
        
        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Insertar la información del Vehiculo
        if(myVehiculoService.agregarVehiculo(myVehiculo) != null){
            //Configurar el mensaje de Exito
            msg.setResponse("Vehiculo creado");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al insertar la información del Vehiculo");
        msg.setSucces(false);
        return msg;
    }

    /**
     * Función que trae la información de los Vehiculos asosiados a un garaje
     * @param myIdGaraje
     * @return  ResponseEntity<>
     */
    @RequestMapping(value="/vehiculo/{myIdGaraje}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<String> traerVehiculosGaraje(@PathVariable("myIdGaraje") BigInteger myIdGaraje){
        
        //Atributos de Método
        Gson myListGson = new Gson();

        //Consultar la lista de las vehiculos por Garaje
        List<Vehiculo> myListVehiculo = myVehiculoService.traerVehiculosGaraje(myIdGaraje);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myListGson.toJson(myListVehiculo),HttpStatus.OK);
    }

    /**
     * Función que actualiza la información del vehiculo
     * @param myVehiculo
     * @return @ResponseBody
     */
    @RequestMapping(value="/actualizarVehiculo",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody PrimoMsg actualizarVehiculo(@RequestBody Vehiculo myVehiculo){
        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();

        try{            
            myVehiculoService.actualizarVehiculo(myVehiculo);

            //Configurar el mensaje de Exito
            msg.setResponse("Vehiculo actualizado");
            msg.setSucces(true);
            return msg;
        }
        catch(Exception ex){
            msg.setResponse("Error al actualizar la información del Vehiculo" + ex.getMessage());
            msg.setSucces(false);
            return msg;
            
        }
    }

    /**
     * Función que actualiza sube el cliente al vehiculo
     * @param myIdGaraje
     * @param myVehiculo
     * @return @ResponseBody
     */
    @RequestMapping(value="/subirAlVehiculo/{myIdGaraje}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody PrimoMsg subirAlVehiculo(@PathVariable("myIdGaraje") BigInteger myIdGaraje,@RequestBody Vehiculo myVehiculo){
        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();

        try{
            //Bajar del Vehiculo
            myVehiculoService.bajarVehiculos(myIdGaraje);
            
            //Montar al Vehiculo
            myVehiculo.setBitSubido(true);
            myVehiculoService.actualizarVehiculo(myVehiculo);

            //Configurar el mensaje de Exito
            msg.setResponse("Se ha subido al vehiculo");
            msg.setSucces(true);
            return msg;
        }
        catch(Exception ex){
            msg.setResponse("Error al actualizar la información del Vehiculo" + ex.getMessage());
            msg.setSucces(false);
            return msg;
            
        }
    }
}