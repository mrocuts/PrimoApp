/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.SucursalServicio;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que define los servicios del objeto Sucursal Servicio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
*/
public interface SucursalServicioService {
    public SucursalServicio agregarSucursalServicio(SucursalServicio mySucursalServicio);
    public List<SucursalServicio> traerServiciosPorSucursal(BigInteger myIdSucursal);
    public List<SucursalServicio> traerSucursalPorServicio(BigInteger myIdEmpresa, BigInteger myIdServicio);
    public SucursalServicio traerServicio(BigInteger mySucursalServicio, BigInteger myIdServicio);
}