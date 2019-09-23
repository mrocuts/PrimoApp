/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Sucursal;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que contiene las funcionalidades del objeto Sucursal
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 18/09/2019
*/
public interface SucursalDAO {
    public Sucursal agregarSucursal(Sucursal mySucursal);
    public Sucursal traerSucursal(Sucursal mySucursal);
    public List<Sucursal> traerSucursalPorEmpresa(BigInteger myIdEmpresa);
    public Sucursal actualizarSucursal(Sucursal mySucursal);
}