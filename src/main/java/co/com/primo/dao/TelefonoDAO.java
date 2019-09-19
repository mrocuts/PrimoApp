/*
 * PACKAGE
 */

package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Telefono;

/**
 * Interfaz que contiene las funcionalidades del objeto Telefono
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 18/09/2019
*/
public interface TelefonoDAO {
    public Telefono agregarTelefono(Telefono myTelefono);
    public Telefono traerTelefono(Telefono myTelefono);
    public Telefono actualizarTelefono(Telefono myTelefono);
}
