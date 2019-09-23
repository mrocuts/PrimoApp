/*
 * PACKAGE
 */
package co.com.primo.ws;

/*
 * IMPORTS
 */
import co.com.primo.model.Direccion;
import co.com.primo.model.Servicio;
import co.com.primo.model.Sucursal;
import co.com.primo.model.SucursalDireccion;
import co.com.primo.model.SucursalServicio;
import co.com.primo.model.SucursalTelefono;
import co.com.primo.model.Telefono;
import co.com.primo.service.SucursalDireccionService;
import co.com.primo.service.SucursalService;
import co.com.primo.service.SucursalServicioService;
import co.com.primo.service.SucursalTelefonoService;
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
 * Clase que implementa el Servicio Web del objeto Sucursal
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
 */
@RestController
public class SucursalWS {

    /** Atributos de Metodo **/
    @Autowired
    private SucursalService mySucursalService;

    @Autowired
    private SucursalDireccionService mySucursalDireccionService;

    @Autowired
    private SucursalTelefonoService mySucursalTelefonoService;

    @Autowired
    private SucursalServicioService mySucursalServicioService;

    /**
     * Función que inserta la información del Sucursal en la Base de Datos
     * @param mySucursal
     * @return @ResponseBody
     */
    @RequestMapping(value="/sucursal",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PrimoMsg agregarSucursal(@RequestBody Sucursal mySucursal){
        
        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Insertar la información del Sucursal
        if(mySucursalService.agregarSucursal(mySucursal) == null){
            //Configurar el mensaje de Exito
            msg.setResponse("Sucursal creada");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al insertar la información de la sucursal");
        msg.setSucces(false);
        return msg;
    }

    /**
     * Función que trae la información de los Sucursales asosiadas a una empresa
     * @param myIdEmpresa
     * @return  ResponseEntity<List<Sucursal>>
     */
    @RequestMapping(value="/sucursal/{myIdEmpresa}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Sucursal>> traerSucursalesPorEmpresa(@PathVariable("myIdEmpresa") BigInteger myIdEmpresa){
        
        //Consultar la lista de Sucursals asociadas a una Empresa
        List<Sucursal> myListSucursal = mySucursalService.traerSucursalPorEmpresa(myIdEmpresa);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myListSucursal,HttpStatus.OK);
    }

    /**
     * Función que actualiza la información del Sucursal
     * @param mySucursal
     * @return @ResponseBody
     */
    @RequestMapping(value="/actualizarSucursal",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody PrimoMsg actualizarSucursal(@RequestBody Sucursal mySucursal){

        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        
        //Actualizar la información del Sucursal
        if(mySucursalService.actualizarSucursal(mySucursal) == null){

            //Configurar el mensaje de Exito
            msg.setResponse("Sucursal actualizada");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al actualizar la información de la Sucursal");
        msg.setSucces(false);
        return msg;
    }

    /**
     * Función que asocia del información de la Sucursal y la Dirección
     * @param myIdSucursal
     * @param myIdDireccion
     * @return @ResponseBody
     */
    @RequestMapping(value="/sucursalDireccion/{myIdSucursal}/{myIdDireccion}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PrimoMsg agregarSucursalDireccion(@PathVariable("myIdSucursal") BigInteger myIdSucursal, 
                                                           @PathVariable("myIdDireccion") BigInteger myIdDireccion){
        
        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        SucursalDireccion mySucursalDireccion = new SucursalDireccion(new Sucursal(myIdSucursal), new Direccion(myIdDireccion));
        
        //Insertar la información del Sucursal
        if(mySucursalDireccionService.agregarSucursalDireccion(mySucursalDireccion) == null){
            //Configurar el mensaje de Exito
            msg.setResponse("La dirección de sucursal creada");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al insertar la información de la dirección de la sucursal");
        msg.setSucces(false);
        return msg;
    }
    
    /**
     * Función que trae la información de las direcciones por Sucursal
     * @param myIdSucursal
     * @return  ResponseEntity<List<SucursalDireccion>>
     */
    @RequestMapping(value="/sucursalDireccion/{myIdSucursal}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<SucursalDireccion>> traerDireccionesPorSucursal(@PathVariable("myIdSucursal") BigInteger myIdSucursal){
        
        //Consultar la lista de Sucursals asociadas a una Empresa
        List<SucursalDireccion> myListSucursalDireccion = mySucursalDireccionService.traerDireccionPorSucursal(myIdSucursal);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myListSucursalDireccion,HttpStatus.OK);
    }

    /**
     * Función que asocia del información de la Sucursal y el Telefono
     * @param myIdSucursal
     * @param myIdTelefono
     * @return @ResponseBody
     */
    @RequestMapping(value="/sucursalTelefono/{myIdSucursal}/{myIdTelefono}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PrimoMsg agregarSucursalTelefono(@PathVariable("myIdSucursal") BigInteger myIdSucursal, 
                                                          @PathVariable("myIdTelefono") BigInteger myIdTelefono){
        
        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        SucursalTelefono mySucursalTelefono = new SucursalTelefono(new Sucursal(myIdSucursal), new Telefono(myIdTelefono));
        
        //Insertar la información del Sucursal
        if(mySucursalTelefonoService.agregarSucursalTelefono(mySucursalTelefono) == null){
            //Configurar el mensaje de Exito
            msg.setResponse("El telefono de sucursal creado");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al insertar la información del telefono de la sucursal");
        msg.setSucces(false);
        return msg;
    }
    
    /**
     * Función que trae la información de los telefonos por Sucursal
     * @param myIdSucursal
     * @return  ResponseEntity<List<SucursalTelefono>>
     */
    @RequestMapping(value="/sucursalTelefono/{myIdSucursal}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<SucursalTelefono>> traerTelefonosPorSucursal(@PathVariable("myIdSucursal") BigInteger myIdSucursal){
        
        //Consultar la lista de Sucursals asociadas a una Empresa
        List<SucursalTelefono> myListSucursalTelefono = mySucursalTelefonoService.traerTelefonoPorSucursal(myIdSucursal);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myListSucursalTelefono,HttpStatus.OK);
    }

    /**
     * Función que asocia del información de la Sucursal y el Servicio
     * @param myIdSucursal
     * @param myIdServicio
     * @return @ResponseBody
     */
    @RequestMapping(value="/sucursalServicio/{myIdSucursal}/{myIdServicio}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PrimoMsg agregarSucursalServicio(@PathVariable("myIdSucursal") BigInteger myIdSucursal, 
                                                          @PathVariable("myIdServicio") BigInteger myIdServicio){
        
        //Atributos de Metodo
        PrimoMsg msg = new PrimoMsg();
        SucursalServicio mySucursalServicio = new SucursalServicio(new Sucursal(myIdSucursal), new Servicio(myIdServicio));
        
        //Insertar la información del Sucursal
        if(mySucursalServicioService.agregarSucursalServicio(mySucursalServicio) == null){
            //Configurar el mensaje de Exito
            msg.setResponse("El servicio de sucursal creado");
            msg.setSucces(true);
            return msg;
        }
        
        msg.setResponse("Error al insertar la información del servicio de la sucursal");
        msg.setSucces(false);
        return msg;
    }
    
    /**
     * Función que trae la información de los servicios por Sucursal
     * @param myIdSucursal
     * @return  ResponseEntity<List<SucursalServicio>>
     */
    @RequestMapping(value="/sucursalServicio/{myIdSucursal}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<SucursalServicio>> traerServiciosPorSucursal(@PathVariable("myIdSucursal") BigInteger myIdSucursal){
        
        //Consultar la lista de Sucursals asociadas a una Empresa
        List<SucursalServicio> myListSucursalServicio = mySucursalServicioService.traerServicioPorSucursal(myIdSucursal);
        
        //Retornar el resultado de la consulta
        return new ResponseEntity<>(myListSucursalServicio,HttpStatus.OK);
    }
}