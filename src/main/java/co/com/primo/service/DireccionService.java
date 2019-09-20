/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Direccion;

/**
 * Interfaz que define los servicios del objeto Direccion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
*/
public interface DireccionService {
    public Direccion agregarDireccion(Direccion myDireccion);
    public Direccion traerDireccion(Direccion myDireccion);
    public Direccion actualizarDireccion(Direccion myDireccion);    
}