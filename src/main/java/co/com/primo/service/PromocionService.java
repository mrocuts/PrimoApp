/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Promocion;

/**
 * Interfaz que contiene los servicios del objeto Promocion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
*/
public interface PromocionService {
    public Promocion agregarPromocion(Promocion myPromocion);
    public Promocion traerPromocion(Promocion myPromocion);
    public Promocion actualizarPromocion(Promocion myPromocion);
}
