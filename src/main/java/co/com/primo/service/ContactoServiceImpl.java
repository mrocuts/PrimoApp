/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.ContactoDAO;
import co.com.primo.model.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Contacto
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
 */
@Service
@Transactional
public class ContactoServiceImpl implements ContactoService{
    
    /** Atributos de Mètodo **/
    @Autowired
    private ContactoDAO myContactoDAO;    

    @Override
    public Contacto agregarContacto(Contacto myContacto) {
        return myContactoDAO.agregarContacto(myContacto);
    }

    @Override
    public Contacto traerContacto(Contacto myContacto) {
        return myContactoDAO.traerContacto(myContacto);
    }

    @Override
    public Contacto actualizarContacto(Contacto myContacto) {
        return myContactoDAO.actualizarContacto(myContacto);
    }
}