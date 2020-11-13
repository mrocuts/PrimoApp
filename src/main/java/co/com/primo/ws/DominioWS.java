/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Dominio;
import co.com.primo.service.DominioService;
import com.google.gson.Gson;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que implementa el Servicio Web del objeto Dominio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 24/09/2019
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class DominioWS {

    /** Atributos de Metodo **/
    @Autowired
    private DominioService myDominioService;

    /**
     * Función que trae la información de los dominios por tipo
     * @param myIdTipoDominio
     * @return  ResponseEntity<String>
     */
    @RequestMapping(value="/dominio/{myIdTipoDominio}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<String> traerDominiosPorTipo(@PathVariable("myIdTipoDominio") BigInteger myIdTipoDominio){
        
        //Atributos de Método
        Gson myListGson = new Gson();
        
        //Consultar la lista de Dominios Asociados a un tipo de dominio
        List<Dominio> myListDominio = myDominioService.traerDominioTipo(myIdTipoDominio);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myListGson.toJson(myListDominio),HttpStatus.OK);
    }

    /**
     * Función que trae la información de los dominios por padre
     * @param myIdDominioPadre
     * @return  ResponseEntity<String>
     */
    @RequestMapping(value="/dominio/padre/{myIdDominioPadre}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<String> traerDominiosPorPadre(@PathVariable("myIdDominioPadre") BigInteger myIdDominioPadre){
        
        //Atributos de Método
        Gson myListGson = new Gson();
        
        //Consultar la lista de Dominios Asociados a un tipo de dominio
        List<Dominio> myListDominio = myDominioService.traerDominioPadre(myIdDominioPadre);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myListGson.toJson(myListDominio),HttpStatus.OK);
    }
}
