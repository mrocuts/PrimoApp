/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.DireccionDAO;
import co.com.primo.model.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Direccion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
 */
@Service
@Transactional
public class DireccionServiceImpl implements DireccionService{

    /** Atributos de Mètodo **/
    @Autowired
    private DireccionDAO myDireccionDAO;    

    @Override
    public Direccion agregarDireccion(Direccion myDireccion) {
        return myDireccionDAO.agregarDireccion(myDireccion);
    }

    @Override
    public Direccion traerDireccion(Direccion myDireccion) {
        return myDireccionDAO.traerDireccion(myDireccion);
    }

    @Override
    public Direccion actualizarDireccion(Direccion myDireccion) {
        return myDireccionDAO.actualizarDireccion(myDireccion);
    }    
}