/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.primo.service;

import co.com.primo.model.Persona;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface PersonaService {
    public void agregarPersona(Persona myPersona);
    public List<Persona> traerPersonas();
    public void eliminarPersona(BigInteger myIdPersona);
    public Persona actualizarPersona(Persona myPersona);
    public Persona traerPersona(BigInteger myIdPersona);
}