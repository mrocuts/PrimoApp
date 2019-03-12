/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.primo.dao;

import co.com.primo.model.Persona;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class PersonaDAOImpl implements PersonaDAO{

    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;
    
    @Override
    public void agregarPersona(Persona myPersona) {
        mySessionFactory.getCurrentSession().save(myPersona);
    }

    @Override
    public List<Persona> traerPersonas() {
        return mySessionFactory.getCurrentSession().createQuery("from Persona").list();
    }

    @Override
    public void eliminarPersona(BigInteger myIdPersona) {
        Persona myPersonaTemp = (Persona) mySessionFactory.getCurrentSession().load(Persona.class, myIdPersona);
        
        if(myPersonaTemp != null){
            mySessionFactory.getCurrentSession().delete(myPersonaTemp);
        }
    }

    @Override
    public Persona actualizarPersona(Persona myPersona) {
        mySessionFactory.getCurrentSession().update(myPersona);
        return myPersona; 
                
    }

    @Override
    public Persona traerPersona(BigInteger myIdPersona) {
        return (Persona) mySessionFactory.getCurrentSession().get(Persona.class, myIdPersona);
    }   
}