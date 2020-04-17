/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Vehiculo;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que contiene las funcionalidades del objeto Vehiculo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 31/03/2020
*/
public interface VehiculoDAO {
    public Vehiculo agregarVehiculo(Vehiculo myVehiculo);
    public Vehiculo traerVehiculo(Vehiculo myVehiculo);
    public List<Vehiculo> traerVehiculosGaraje(BigInteger myIdGaraje);
    public Vehiculo actualizarVehiculo(Vehiculo myVehiculo);
    public void bajarVehiculos(BigInteger myIdGaraje);
}