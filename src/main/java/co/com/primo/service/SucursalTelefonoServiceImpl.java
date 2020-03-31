/*
 * PACKAGE
 */
package co.com.primo.service;

import co.com.primo.dao.SucursalTelefonoDAO;
import co.com.primo.model.SucursalTelefono;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Sucursal Telefono
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
 */
@Service
@Transactional
public class SucursalTelefonoServiceImpl implements SucursalTelefonoService{
    
    /** Atributos de Mètodo **/
    @Autowired
    private SucursalTelefonoDAO mySucursalTelefonoDAO;    

    @Override
    public SucursalTelefono agregarSucursalTelefono(SucursalTelefono mySucursalTelefono) {
        return mySucursalTelefonoDAO.agregarSucursalTelefono(mySucursalTelefono);
    }    

    @Override
    public List<SucursalTelefono> traerTelefonoPorSucursal(BigInteger myIdSucursal) {
        return mySucursalTelefonoDAO.traerTelefonoPorSucursal(myIdSucursal);
    }
}
