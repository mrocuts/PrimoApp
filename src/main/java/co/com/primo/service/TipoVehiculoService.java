/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.TipoVehiculo;
import java.util.List;

/**
 * Interfaz que define los servicios del objeto Tipo de Vehiculo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 03/04/2019
*/
public interface TipoVehiculoService {
    public TipoVehiculo agregarTipoVehiculo(TipoVehiculo myTipoVehiculo);
    public List<TipoVehiculo> traerTiposVehiculo();
    public TipoVehiculo actualizarTipoVehiculo(TipoVehiculo myTipoVehiculo);
}