/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.primo.ws;

import co.com.primo.model.Persona;
import co.com.primo.service.PersonaService;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
        
/**
 *
 * @author Usuario
 */
@RestController
public class PersonaWS {
    
    @Autowired
    private PersonaService myPersonaService;

    /**
     * Servicio Web que retorna la lista de las personas
     * @return ResponseEntity<List<Persona>> Lista de las personas
     */
    @RequestMapping(value="/persona",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Persona>> getPersonas(){
        List<Persona> myListPersona = myPersonaService.traerPersonas();
        
        return new ResponseEntity<List<Persona>>(myListPersona,HttpStatus.OK);
    }

    /**
     * Servicio Web que retorna la información de una persona
     * @param myIdPersona Identificador de la persona
     * @return ResponseEntity<Persona> Objeto Persona
     */
    @RequestMapping(value="/persona/{myIdPersona}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> getPersonabyId(@PathVariable BigInteger myIdPersona){
        
        //Atributos de Metodo
        ResponseEntity<Persona> myResponsePersona = null;
        
        //Traer la información de la persona
        Persona myPersona = myPersonaService.traerPersona(myIdPersona);
        
        //Verificar que existe la persona
        if(myPersona != null){
            //Retornar la información de la persona
            myResponsePersona = new ResponseEntity<Persona>(myPersona,HttpStatus.OK);
        }
        else{
            //Retornar el mensaje que no se encuentra información
            myResponsePersona = new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
        }
        
        //Retornar la información
        return myResponsePersona;
    }
}