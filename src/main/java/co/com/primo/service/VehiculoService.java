/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Vehiculo;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que define los servicios del objeto Vehiculo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 03/04/2019
*/
public interface VehiculoService {
    public Vehiculo agregarVehiculo(Vehiculo myVehiculo);
    public Vehiculo traerVehiculo(Vehiculo myVehiculo);
    public List<Vehiculo> traerVehiculosGaraje(BigInteger myIdGaraje);
    public Vehiculo actualizarVehiculo(Vehiculo myVehiculo); 
    public void bajarVehiculos(BigInteger myIdGaraje);
}
