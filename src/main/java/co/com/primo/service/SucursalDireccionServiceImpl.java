/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.SucursalDireccionDAO;
import co.com.primo.model.SucursalDireccion;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Sucursal Direccion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
 */
@Service
@Transactional
public class SucursalDireccionServiceImpl implements SucursalDireccionService{
    
    /** Atributos de Mètodo **/
    @Autowired
    private SucursalDireccionDAO mySucursalDireccionDAO;    

    @Override
    public SucursalDireccion agregarSucursalDireccion(SucursalDireccion mySucursalDireccion) {
        return mySucursalDireccionDAO.agregarSucursalDireccion(mySucursalDireccion);
    }    

    @Override
    public List<SucursalDireccion> traerDireccionPorSucursal(BigInteger myIdSucursal) {
        return mySucursalDireccionDAO.traerDireccionPorSucursal(myIdSucursal);
    }
}