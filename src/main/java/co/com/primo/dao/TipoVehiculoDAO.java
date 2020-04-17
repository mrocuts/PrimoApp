/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.TipoVehiculo;
import java.util.List;

/**
 * Interfaz que contiene las funcionalidades del objeto Tipo de Vehiculo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 01/04/2020
*/
public interface TipoVehiculoDAO {
    public TipoVehiculo agregarTipoVehiculo(TipoVehiculo myTipoVehiculo);
    public List<TipoVehiculo> traerTiposVehiculo();
    public TipoVehiculo actualizarTipoVehiculo(TipoVehiculo myTipoVehiculo);
}