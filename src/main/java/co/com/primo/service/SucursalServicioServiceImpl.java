/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.SucursalServicioDAO;
import co.com.primo.model.SucursalServicio;
import co.com.primo.model.SucursalServicio;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Sucursal Servicio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
 */
@Service
@Transactional
public class SucursalServicioServiceImpl implements SucursalServicioService{

        /** Atributos de Mètodo **/
    @Autowired
    private SucursalServicioDAO mySucursalServicioDAO;    

    @Override
    public SucursalServicio agregarSucursalServicio(SucursalServicio mySucursalServicio) {
        return mySucursalServicioDAO.agregarSucursalServicio(mySucursalServicio);
    }    

    @Override
    public List<SucursalServicio> traerServicioPorSucursal(BigInteger myIdSucursal) {
        return mySucursalServicioDAO.traerServicioPorSucursal(myIdSucursal);
    }
}