/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.VehiculoDAO;
import co.com.primo.model.Vehiculo;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Tipo de Vehiculo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 03/04/2019
 */
@Service
@Transactional
public class VehiculoServiceImpl implements VehiculoService{

    /** Atributos de Mètodo **/
    @Autowired
    private VehiculoDAO myVehiculoDAO;    

    @Override
    public Vehiculo agregarVehiculo(Vehiculo myVehiculo) {
        return myVehiculoDAO.agregarVehiculo(myVehiculo);
    }

    @Override
    public Vehiculo traerVehiculo(Vehiculo myVehiculo) {
        return myVehiculoDAO.traerVehiculo(myVehiculo);
    }

    @Override
    public List<Vehiculo> traerVehiculosGaraje(BigInteger myIdGaraje) {
        return myVehiculoDAO.traerVehiculosGaraje(myIdGaraje);
    }

    @Override
    public Vehiculo actualizarVehiculo(Vehiculo myVehiculo) {
        return myVehiculoDAO.actualizarVehiculo(myVehiculo);
    }

    @Override
    public void bajarVehiculos(BigInteger myIdGaraje) {
        myVehiculoDAO.bajarVehiculos(myIdGaraje);
    }
}