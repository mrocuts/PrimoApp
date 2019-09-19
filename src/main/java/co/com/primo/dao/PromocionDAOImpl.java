/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Promocion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Promocion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
 */
@Repository
public class PromocionDAOImpl implements PromocionDAO{
    
    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Promocion agregarPromocion(Promocion myPromocion) {
        mySessionFactory.getCurrentSession().save(myPromocion);
        return myPromocion;
    }

    @Override
    public Promocion traerPromocion(Promocion myPromocion) {
        return (Promocion) mySessionFactory.getCurrentSession().get(Promocion.class, myPromocion.getIdPromocion());
    }

    @Override
    public Promocion actualizarPromocion(Promocion myPromocion) {
        mySessionFactory.getCurrentSession().update(myPromocion);
        return myPromocion;
    }    

}
