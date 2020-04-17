/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.TipoVehiculo;
import co.com.primo.service.TipoVehiculoService;
import com.google.gson.Gson;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que implementa el Servicio Web del objeto Tipo de Vehiculo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 05/04/2020
 */
@RestController
public class TipoVehiculoWS {
    
    /** Atributos de Metodo **/
    @Autowired
    private TipoVehiculoService myTipoVehiculoService;

    /**
     * Función que trae la información de los tipos de Vehiculo
     * @return  ResponseEntity<>
     */
    @RequestMapping(value="/tipoVehiculo",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<String> traerDominiosPorTipo(){
        
        //Atributos de Método
        Gson myListGson = new Gson();
        
        //Consultar la lista de Dominios Asociados a un tipo de dominio
        List<TipoVehiculo> myListTipoVehiculo = myTipoVehiculoService.traerTiposVehiculo();
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myListGson.toJson(myListTipoVehiculo),HttpStatus.OK);
    }
}