/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Contacto;

/**
 * Interfaz que define los servicios del objeto Contacto
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/009/2019
*/
public interface ContactoService {
    public Contacto agregarContacto(Contacto myContacto);
    public Contacto traerContacto(Contacto myContacto);
    public Contacto actualizarContacto(Contacto myContacto);
}