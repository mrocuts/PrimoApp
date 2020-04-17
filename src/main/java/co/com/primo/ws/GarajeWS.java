/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Garaje;
import co.com.primo.service.GarajeService;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que implementa el Servicio Web del objeto Garaje
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 03/04/2020
 */
@RestController
public class GarajeWS {
    
    /** Atributos de Clase **/
    @Autowired
    private GarajeService myGarajeService;
    
    /**
     * Servicio que consulta la información del Garaje
     * @param myIdUsuario
     * @return ResponseEntity<>
     */
    @RequestMapping(value="/garaje/{myIdUsuario}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<Garaje> traerGarajeUsuario(@PathVariable("myIdUsuario") BigInteger myIdUsuario){
        return new ResponseEntity<>(myGarajeService.traerGarajePorUsuario(myIdUsuario),HttpStatus.OK);
    }
}
