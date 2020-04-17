/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.TipoVehiculoDAO;
import co.com.primo.model.TipoVehiculo;
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
public class TipoVehiculoServiceImpl implements TipoVehiculoService{
    
    /** Atributos de Mètodo **/
    @Autowired
    private TipoVehiculoDAO myTipoVehiculoDAO;    

    @Override
    public TipoVehiculo agregarTipoVehiculo(TipoVehiculo myTipoVehiculo) {
        return myTipoVehiculoDAO.agregarTipoVehiculo(myTipoVehiculo);
    }

    @Override
    public List<TipoVehiculo> traerTiposVehiculo() {
        return myTipoVehiculoDAO.traerTiposVehiculo();
    }

    @Override
    public TipoVehiculo actualizarTipoVehiculo(TipoVehiculo myTipoVehiculo) {
        return myTipoVehiculoDAO.actualizarTipoVehiculo(myTipoVehiculo);
    }
}