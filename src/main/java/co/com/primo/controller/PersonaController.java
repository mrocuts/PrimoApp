/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.primo.controller;

import co.com.primo.model.Persona;
import co.com.primo.service.PersonaService;
import java.io.IOException;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Usuario
 */
@Controller
public class PersonaController {
    
    /** Atributos de Clase **/
    private static final Logger myLogger = Logger.getLogger(Persona.class);
    
    @Autowired
    private PersonaService myPersonaService;
    
    public PersonaController(){
        System.out.println("PersonaController");
    }
    
    @RequestMapping(value = "/l")
    public ModelAndView listarPersonas(ModelAndView myModel) throws IOException{
        List<Persona> myListPersona = myPersonaService.traerPersonas();
        myModel.addObject("myListPersona",myListPersona);
        myModel.setViewName("home");
        return myModel;
    }
}