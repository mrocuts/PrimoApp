/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Empresa;
import co.com.primo.service.EmpresaService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.math.BigInteger;
import java.util.List;
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
 * Clase que implementa el Servicio Web del objeto Empresa
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class EmpresaWS {

    /** Atributos de Metodo **/
    @Autowired
    private EmpresaService myEmpresaService;
    private final Gson myGson=new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    
    /**
     * Función que inserta la información de la Empresa en la Base de Datos
     * @param myEmpresa
     * @return @ResponseBody
     */
    @RequestMapping(value="/empresa",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> agregarEmpresa(@RequestBody Empresa myEmpresa){
        PrimoMsg msg = new PrimoMsg();
        System.out.println("Creando empresa...");
        try{
            if(myEmpresaService.traerEmpresa(myEmpresa.getStrIdentificacion())== null){
                System.out.println("Empresa NO EXISTE...");
                myEmpresaService.agregarEmpresa(myEmpresa);
                msg.setResponse("Empresa creada");
                msg.setSucces(true);
            }
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.OK);
        }catch(Exception ex){
            System.out.println("HOLA HUBO UN ERROR: "+ex.getMessage());
            System.err.append(ex.getLocalizedMessage());
            msg.setResponse(ex.getMessage());
            msg.setSucces(false);
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.BAD_REQUEST);
        }
    }
    
    /**
     * Función que trae la información de la Empresas asosiadas a un usuario
     * @param myIdUsuario
     * @return ResponseEntity<String>
     */
    @RequestMapping(value="/empresa/{myIdUsuario}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public Empresa traerEmpresasPorUsuario(@PathVariable("myIdUsuario") BigInteger myIdUsuario){
        List<Empresa> myListEmpresa = myEmpresaService.traerEmpresaPorUsuario(myIdUsuario);
        if(!myListEmpresa.isEmpty()){
            return myListEmpresa.get(0);
        }
        return null;
    }

    /**
     * Función que actualiza la información de la Empresa
     * @param myEmpresa
     * @return @ResponseBody
     */
    @RequestMapping(value="/actualizarEmpresa",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody ResponseEntity<String> actualizarEmpresa(@RequestBody Empresa myEmpresa){
        PrimoMsg msg = new PrimoMsg();
        try{
            if(myEmpresaService.actualizarEmpresa(myEmpresa) == null){
                msg.setResponse("Empresa actualizada");
                msg.setSucces(true);
            }else{
                msg.setResponse("Error al actualizar la informacion de la Empresa");
                msg.setSucces(false);
            }
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.OK);
        }catch(Exception ex){
            msg.setResponse(ex.getMessage());
            msg.setSucces(false);
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.BAD_REQUEST);
        }
    }
}