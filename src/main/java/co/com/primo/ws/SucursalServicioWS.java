/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.primo.ws;

import co.com.primo.model.Sucursal;
import co.com.primo.model.SucursalServicio;
import co.com.primo.service.SucursalServicioService;
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
 *
 * @author OvalleGA
 */
@RestController
public class SucursalServicioWS {
    
    @Autowired
    private SucursalServicioService mySucursalServicioService;
    private final Gson myGson=new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    
    /**
     * 
     * @param mySucursalServicio
     * @return 
     */
    @RequestMapping(value="/sucursalServicio",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> agregarSucursalServicio(@RequestBody SucursalServicio mySucursalServicio){
        PrimoMsg msg = new PrimoMsg();
        System.out.println("GUSTAVO: "+mySucursalServicio.getDblValor());
        try{
            if(mySucursalServicioService.agregarSucursalServicio(mySucursalServicio)!=null){
                msg.setResponse("Exito al guarda la sucursal");
                msg.setSucces(true);
            }else{
                msg.setResponse("La sucursal no se guardo, verifique e intente nuevamnte");
                msg.setSucces(false);
            }
        }catch(Exception ex){
            msg.setResponse(ex.getMessage());
            msg.setSucces(false);
        }
        return new ResponseEntity<>(myGson.toJson(msg),(msg.isSucces()?HttpStatus.OK:HttpStatus.BAD_REQUEST));
    }
    
    /**
     * 
     * @param mySucursalServicio
     * @return 
     */
    @RequestMapping(value="/sucursalServicio/actualizar",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarSucursalServicio(@RequestBody SucursalServicio mySucursalServicio){
        PrimoMsg msg = new PrimoMsg();
        System.out.println("GUSTAVO: "+mySucursalServicio.getDblValor());
        try{
            if(mySucursalServicioService.actualizarSucursalServicio(mySucursalServicio)!=null){
                msg.setResponse("Exito al actualizar la sucursal");
                msg.setSucces(true);
            }else{
                msg.setResponse("La sucursal no se guardo, verifique e intente nuevamnte");
                msg.setSucces(false);
            }
        }catch(Exception ex){
            msg.setResponse(ex.getMessage());
            msg.setSucces(false);
        }
        return new ResponseEntity<>(myGson.toJson(msg),(msg.isSucces()?HttpStatus.OK:HttpStatus.BAD_REQUEST));
    }
    
    
    @RequestMapping(value="/sucursalServicio/sucursal/{myIdEmpresa}/{myIdServicio}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> getBranchesByService(@PathVariable("myIdEmpresa") BigInteger myIdEmpresa, @PathVariable("myIdServicio")BigInteger myIdServicio){
        PrimoMsg msg = new PrimoMsg();
        try{
            List<Sucursal> branches=mySucursalServicioService.traerSucursalPorServicio(myIdEmpresa, myIdServicio);
            msg.setResponse("Sucursales encotnradas");
            msg.setSucces(true);
            return new ResponseEntity<>(myGson.toJson(branches),HttpStatus.OK);
        }catch(Exception ex){
            msg.setResponse(ex.getMessage());
            msg.setSucces(false);
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value="/sucursalServicio/servicio/{myIdEmpresa}/{myIdSucursal}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> getServiceByBranch(@PathVariable("myIdEmpresa") BigInteger myIdEmpresa, @PathVariable("myIdSucursal")BigInteger myIdSucursal){
        PrimoMsg msg = new PrimoMsg();
        try{
            List<SucursalServicio> branches=mySucursalServicioService.traerServiciosPorSucursal(myIdEmpresa, myIdSucursal);
            msg.setResponse("Servicios encotnrados");
            msg.setSucces(true);
            return new ResponseEntity<>(myGson.toJson(branches),HttpStatus.OK);
        }catch(Exception ex){
            msg.setResponse(ex.getMessage());
            msg.setSucces(false);
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value="/sucursalServicio/{myIdEmpresa}/{myIdSucursal}/{myIdServicio}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> removeSucursalFromService(@PathVariable("myIdEmpresa") BigInteger myIdEmpresa, 
                                                                          @PathVariable("myIdSucursal")BigInteger myIdSucursal, 
                                                                          @PathVariable("myIdServicio")BigInteger myIdServicio){
        PrimoMsg msg = new PrimoMsg();
        try{
            System.out.println("BORRANDO:::::");
            mySucursalServicioService.borrarSucursalPorServicio(myIdEmpresa, myIdSucursal, myIdServicio);
            msg.setResponse("Sucursales borradas");
            msg.setSucces(true);
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.OK);
        }catch(Exception ex){
            System.err.println(ex.getCause());
            msg.setResponse(ex.getMessage());
            msg.setSucces(false);
            return new ResponseEntity<>(myGson.toJson(msg),HttpStatus.BAD_REQUEST);
        }
    }
}
