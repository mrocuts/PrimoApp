/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.SucursalDAO;
import co.com.primo.model.Sucursal;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Sucursal
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
 */
@Service
@Transactional
public class SucursalServiceImpl implements SucursalService{

    /** Atributos de Mètodo **/
    @Autowired
    private SucursalDAO mySucursalDAO;    

    @Override
    public Sucursal agregarSucursal(Sucursal mySucursal) {
        return mySucursalDAO.agregarSucursal(mySucursal);
    }

    @Override
    public Sucursal traerSucursal(Sucursal mySucursal) {
        return mySucursalDAO.traerSucursal(mySucursal);
    }

    @Override
    public List<Sucursal> traerSucursalPorEmpresa(BigInteger myIdEmpresa) {
        return mySucursalDAO.traerSucursalPorEmpresa(myIdEmpresa);
    }

    @Override
    public Sucursal actualizarSucursal(Sucursal mySucursal) {
        return mySucursalDAO.actualizarSucursal(mySucursal);
    }
}