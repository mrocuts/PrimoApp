/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Contacto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Contacto
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 18/09/2019
 */
@Repository
public class ContactoDAOImpl implements ContactoDAO{

    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Contacto agregarContacto(Contacto myContacto) {
        mySessionFactory.getCurrentSession().save(myContacto);
        return myContacto;
    }

    @Override
    public Contacto traerContacto(Contacto myContacto) {
        return (Contacto) mySessionFactory.getCurrentSession().get(Contacto.class, myContacto.getIdContacto());
    }

    @Override
    public Contacto actualizarContacto(Contacto myContacto) {
        mySessionFactory.getCurrentSession().update(myContacto);
        return myContacto;
    }
}