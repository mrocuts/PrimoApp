/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Direccion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Direccion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 18/09/2019
 */
@Repository
public class DireccionDAOImpl implements DireccionDAO{
    
    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Direccion agregarDireccion(Direccion myDireccion) {
        mySessionFactory.getCurrentSession().save(myDireccion);
        return myDireccion;
    }

    @Override
    public Direccion traerDireccion(Direccion myDireccion) {
        return (Direccion) mySessionFactory.getCurrentSession().get(Direccion.class, myDireccion.getIdDireccion());
    }

    @Override
    public Direccion actualizarDireccion(Direccion myDireccion) {
        mySessionFactory.getCurrentSession().update(myDireccion);
        return myDireccion;
    }    
}
