/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Telefono;

/**
 * Interfaz que define los servicios del objeto Telefono
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
*/
public interface TelefonoService {
    public Telefono agregarTelefono(Telefono myTelefono);
    public Telefono traerTelefono(Telefono myTelefono);
    public Telefono actualizarTelefono(Telefono myTelefono);       
}