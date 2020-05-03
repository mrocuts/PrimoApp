/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Sucursal;
import co.com.primo.model.SucursalServicio;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que contiene las funcionalidades del objeto Sucursal Servicio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
*/
public interface SucursalServicioDAO {
    public SucursalServicio agregarSucursalServicio(SucursalServicio mySucursalServicio);
    public List<SucursalServicio> traerServiciosPorSucursal(BigInteger myIdEmpresa, BigInteger myIdSucursal);
    public List<Sucursal> traerSucursalPorServicio(BigInteger myIdSucursal, BigInteger myIdServicio);
    public void borrarServicioPorSucursal(BigInteger myIdEmpresa, BigInteger myIdSucursal, BigInteger myIdServicio);

    public Object actualizarServicioPorSucursal(SucursalServicio mySucursalServicio);
}