/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Direccion;

/**
 * Interfaz que contiene las funcionalidades del objeto Direccion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 18/09/2019
*/
public interface DireccionDAO {
    public Direccion agregarDireccion(Direccion myDireccion);
    public Direccion traerDireccion(Direccion myDireccion);
    public Direccion actualizarDireccion(Direccion myDireccion);
}
