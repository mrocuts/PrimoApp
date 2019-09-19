/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Sucursal;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Sucursal
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 18/09/2019
 */
@Repository
public class SucursalDAOImpl implements SucursalDAO{

    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Sucursal agregarSucursal(Sucursal mySucursal) {
        mySessionFactory.getCurrentSession().save(mySucursal);
        return mySucursal;
    }

    @Override
    public Sucursal traerSucursal(Sucursal mySucursal) {
        return (Sucursal) mySessionFactory.getCurrentSession().get(Sucursal.class, mySucursal.getIdSucursal());
    }

    @Override
    public Sucursal actualizarSucursal(Sucursal mySucursal) {
        mySessionFactory.getCurrentSession().update(mySucursal);
        return mySucursal;
    }    
}