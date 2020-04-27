/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.primo.ws;

import co.com.primo.model.SucursalServicio;
import co.com.primo.service.SucursalServicioService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
