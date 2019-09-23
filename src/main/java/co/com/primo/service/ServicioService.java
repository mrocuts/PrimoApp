/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Servicio;

/**
 * Interfaz que contiene los servicios del objeto Servicio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
*/
public interface ServicioService {
    public Servicio agregarServicio(Servicio myServicio);
    public Servicio traerServicio(Servicio myServicio);
    public Servicio actualizarServicio(Servicio myServicio);
}
