/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Modelo;
import co.com.primo.service.ModeloService;
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
 * Clase que implementa el Servicio Web del objeto Modelo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 05/04/2020
 */
@RestController
public class ModeloWS {

    /** Atributos de Metodo **/
    @Autowired
    private ModeloService myModeloService;

    /**
     * Función que trae la información de las Modelo por marca
     * @param myIdMarca
     * @return  ResponseEntity<>
     */
    @RequestMapping(value="/modelo/{myIdMarca}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<String> traerModeloPorMarca(@PathVariable("myIdMarca") BigInteger myIdMarca){
        
        //Atributos de Método
        Gson myListGson = new Gson();
        
        //Consultar la lista de los modelos por marca
        List<Modelo> myListModelo = myModeloService.traerModelosMarca(myIdMarca);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myListGson.toJson(myListModelo),HttpStatus.OK);
    }        
}
