/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.SucursalDireccion;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que define los servicios del objeto Sucursal Direccion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
*/
public interface SucursalDireccionService {
    public SucursalDireccion agregarSucursalDireccion(SucursalDireccion mySucursalDireccion);
    public List<SucursalDireccion> traerDireccionPorSucursal(BigInteger myIdSucursal);
}