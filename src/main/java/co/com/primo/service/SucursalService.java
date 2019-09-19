/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Sucursal;

/**
 * Interfaz que define los servicios del objeto Sucursal
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
*/
public interface SucursalService {
    public Sucursal agregarSucursal(Sucursal mySucursal);
    public Sucursal traerSucursal(Sucursal mySucursal);
    public Sucursal actualizarSucursal(Sucursal mySucursal);
}