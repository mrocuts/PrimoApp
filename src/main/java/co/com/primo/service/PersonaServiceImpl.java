/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.primo.service;

import co.com.primo.dao.PersonaDAO;
import co.com.primo.model.Persona;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
@Transactional
public class PersonaServiceImpl implements PersonaService{

    /** Atributos de Mètodo **/
    @Autowired
    private PersonaDAO myPersonaDAO;
    
    @Override
    public void agregarPersona(Persona myPersona) {
        myPersonaDAO.agregarPersona(myPersona);
    }

    @Override
    public List<Persona> traerPersonas() {
        return myPersonaDAO.traerPersonas();
    }

    @Override
    public void eliminarPersona(BigInteger myIdPersona) {
        myPersonaDAO.eliminarPersona(myIdPersona);
    }

    @Override
    public Persona actualizarPersona(Persona myPersona) {
        return myPersonaDAO.actualizarPersona(myPersona);
    }

    @Override
    public Persona traerPersona(BigInteger myIdPersona) {
        return myPersonaDAO.traerPersona(myIdPersona);
    }   
}