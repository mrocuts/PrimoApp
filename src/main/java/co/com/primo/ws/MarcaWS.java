/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Marca;
import co.com.primo.service.MarcaService;
import com.google.gson.Gson;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que implementa el Servicio Web del objeto Marca
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 05/04/2020
 */
@RestController
public class MarcaWS {

    /** Atributos de Metodo **/
    @Autowired
    private MarcaService myMarcaService;

    /**
     * Función que trae la información de las Marcas por tipo de vehiculo
     * @param myIdTipoVehiculo
     * @return  ResponseEntity<>
     */
    @RequestMapping(value="/marca/{myIdTipoVehiculo}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<String> traerMarcaPorTipoVehiculo(@PathVariable("myIdTipoVehiculo") BigInteger myIdTipoVehiculo){
        
        //Atributos de Método
        Gson myListGson = new Gson();
        
        //Consultar la lista de las marcas por tipo de vehiculo
        List<Marca> myListMarca = myMarcaService.traerMarcasTipoVehiculo(myIdTipoVehiculo);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myListGson.toJson(myListMarca),HttpStatus.OK);
    }    
}