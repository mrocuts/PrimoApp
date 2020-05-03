/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.SucursalServicioDAO;
import co.com.primo.model.Sucursal;
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
    public List<SucursalServicio> traerServiciosPorSucursal(BigInteger myIdSucursal) {
        return mySucursalServicioDAO.traerServiciosPorSucursal(myIdSucursal);
    }

    @Override
    public List<Sucursal> traerSucursalPorServicio(BigInteger myIdEmpresa, BigInteger myIdServicio) {
        return mySucursalServicioDAO.traerSucursalPorServicio(myIdEmpresa, myIdServicio);
    }

    @Override
    public SucursalServicio traerServicio(BigInteger mySucursalServicio, BigInteger myIdServicio) {
        return mySucursalServicioDAO.traerServicioPorSucursal(mySucursalServicio, myIdServicio);
    }

    @Override
    public void borrarSucursalPorServicio(BigInteger myIdEmpresa, BigInteger myIdSucursal, BigInteger myIdServicio) {
        mySucursalServicioDAO.borrarServicioPorSucursal(myIdEmpresa, myIdSucursal, myIdServicio);
    }
}