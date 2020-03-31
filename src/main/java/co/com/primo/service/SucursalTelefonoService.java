/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.SucursalTelefono;
import co.com.primo.model.SucursalTelefono;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que define los servicios del objeto Sucursal Telefono
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
*/
public interface SucursalTelefonoService {
    public SucursalTelefono agregarSucursalTelefono(SucursalTelefono mySucursalTelefono);
    public List<SucursalTelefono> traerTelefonoPorSucursal(BigInteger myIdSucursal);
}
