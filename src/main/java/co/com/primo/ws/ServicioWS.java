/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Servicio;
import co.com.primo.model.Sucursal;
import co.com.primo.service.ServicioService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
    private final Gson myGson=new GsonBuilder().setDateFormat("dd-MM-yyyy").create();

    /**
     * Función que inserta la información del Servicio en la Base de Datos
     * @param myServicio
     * @return @ResponseBody
     */
    @RequestMapping(value="/servicio",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> agregarServicio(@RequestBody Servicio myServicio){
        PrimoMsg msg = new PrimoMsg();
        try{
            myServicioService.agregarServicio(myServicio);
            msg.setResponse("Servicio creado");
            msg.setSucces(true);
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.OK);
        }catch(Exception ex){
            msg.setResponse(ex.getMessage());
            msg.setSucces(false);
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.BAD_REQUEST);
        }
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
    @RequestMapping(value="/actualizarServicio",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody ResponseEntity<String> actualizarServicio(@RequestBody Servicio myServicio){
        PrimoMsg msg = new PrimoMsg();
        try{
            myServicioService.actualizarServicio(myServicio);
            msg.setResponse("Servicio actualizado");
            msg.setSucces(true);
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.OK);
        }catch(Exception ex){
            msg.setResponse(ex.getMessage());
            msg.setSucces(false);
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.BAD_REQUEST);
        }
    }
    
    /**
     * Función que trae la información de los Sucursales asosiadas a una empresa
     * @param myIdEmpresa
     * @return  ResponseEntity<List<Sucursal>>
     */
    @RequestMapping(value="/servicio/empresa/{myIdEmpresa}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<String> traerSucursalesPorEmpresa(@PathVariable("myIdEmpresa") BigInteger myIdEmpresa){
        try{
            List<Servicio> myListEmpresa = myServicioService.traerServiciosPorEmpresa(myIdEmpresa);
            return new ResponseEntity<>(myGson.toJson(myListEmpresa),HttpStatus.OK);
        }catch(Exception ex){
            System.err.println(""+ex.getLocalizedMessage());
            return new ResponseEntity<>(myGson.toJson(ex),HttpStatus.BAD_REQUEST);
        }
    }
}