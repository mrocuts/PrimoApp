/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.TelefonoDAO;
import co.com.primo.model.Telefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Telefono
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
 */
@Service
@Transactional
public class TelefonoServiceImpl implements TelefonoService{
    
    /** Atributos de Mètodo **/
    @Autowired
    private TelefonoDAO myTelefonoDAO;    

    @Override
    public Telefono agregarTelefono(Telefono myTelefono) {
        return myTelefonoDAO.agregarTelefono(myTelefono);
    }

    @Override
    public Telefono traerTelefono(Telefono myTelefono) {
        return myTelefonoDAO.traerTelefono(myTelefono);
    }

    @Override
    public Telefono actualizarTelefono(Telefono myTelefono) {
        return myTelefonoDAO.actualizarTelefono(myTelefono);
    }    
}
