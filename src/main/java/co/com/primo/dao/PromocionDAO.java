/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Promocion;

/**
 * Interfaz que contiene las funcionalidades del objeto Promocion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
*/
public interface PromocionDAO {
    public Promocion agregarPromocion(Promocion myPromocion);
    public Promocion traerPromocion(Promocion myPromocion);
    public Promocion actualizarPromocion(Promocion myPromocion);
}
