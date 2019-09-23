/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.SucursalTelefono;
import co.com.primo.model.SucursalTelefono;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que contiene las funcionalidades del objeto Sucursal Telefono
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
*/
public interface SucursalTelefonoDAO {
    public SucursalTelefono agregarSucursalTelefono(SucursalTelefono mySucursalTelefono);
    public List<SucursalTelefono> traerTelefonoPorSucursal(BigInteger myIdSucursal);
}
