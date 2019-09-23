/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.SucursalDireccion;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que contiene las funcionalidades del objeto Sucursal Direccion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
*/
public interface SucursalDireccionDAO {
    public SucursalDireccion agregarSucursalDireccion(SucursalDireccion mySucursalDireccion);
    public List<SucursalDireccion> traerDireccionPorSucursal(BigInteger myIdSucursal);
}