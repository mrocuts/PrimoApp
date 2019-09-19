/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Telefono;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Telefono
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 18/09/2019
 */
@Repository
public class TelefonoDAOImpl implements TelefonoDAO{
    
    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Telefono agregarTelefono(Telefono myTelefono) {
        mySessionFactory.getCurrentSession().save(myTelefono);
        return myTelefono;
    }

    @Override
    public Telefono traerTelefono(Telefono myTelefono) {
        return (Telefono) mySessionFactory.getCurrentSession().get(Telefono.class, myTelefono.getIdTelefono());
    }

    @Override
    public Telefono actualizarTelefono(Telefono myTelefono) {
        mySessionFactory.getCurrentSession().update(myTelefono);
        return myTelefono;
    }    
}
