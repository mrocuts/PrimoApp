/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Empresa;
import co.com.primo.service.EmpresaService;
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
 * Clase que implementa el Servicio Web del objeto Empresa
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
 */
@RestController
public class EmpresaWS {

    /** Atributos de Metodo **/
    @Autowired
    private EmpresaService myEmpresaService;
    
    /**
     * Función que inserta la información de la Empresa en la Base de Datos
     * @param myEmpresa
     * @return @ResponseBody
     */
    @RequestMapping(value="/empresa",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PrimoMsg agregarEmpresa(@RequestBody Empresa myEmpresa){
        
        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Validar que la empresa no exista en la Base de Datos
        if(myEmpresaService.traerEmpresa(myEmpresa.getStrIdentificacion())== null){
            // Si la empresa no existe se agrega en la base de datos
            myEmpresaService.agregarEmpresa(myEmpresa);

            //Configurar el mensaje de Exito
            msg.setResponse("Empresa creada");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("La empresa ya se encuentra registrada");
        msg.setSucces(false);
        return msg;
    }
    
    /**
     * Función que trae la información de la Empresas asosiadas a un usuario
     * @param myIdUsuario
     * @return ResponseEntity<List<Empresa>>
     */
    @RequestMapping(value="/empresa/{myIdUsuario}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Empresa>> traerEmpresasPorUsuario(@PathVariable("myIdUsuario") BigInteger myIdUsuario){
        
        //Consultar la lista de Empresas asociadas a un Usuario
        List<Empresa> myListEmpresa = myEmpresaService.traerEmpresaPorUsuario(myIdUsuario);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myListEmpresa,HttpStatus.OK);
    }

    /**
     * Función que actualiza la información de la Empresa
     * @param myEmpresa
     * @return @ResponseBody
     */
    @RequestMapping(value="/actualizarEmpresa",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody PrimoMsg actualizarEmpresa(@RequestBody Empresa myEmpresa){

        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Actualizar la información de la Empresa
        if(myEmpresaService.actualizarEmpresa(myEmpresa) == null){

            //Configurar el mensaje de Exito
            msg.setResponse("Empresa actualizada");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al actualizar la información de la Empresa");
        msg.setSucces(false);
        return msg;
    }
}