/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Sucursal;
import co.com.primo.model.SucursalDireccion;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Sucursal Direccion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
 */
@Repository
public class SucursalDireccionDAOImpl implements SucursalDireccionDAO{

    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public SucursalDireccion agregarSucursalDireccion(SucursalDireccion mySucursalDireccion) {
        mySessionFactory.getCurrentSession().save(mySucursalDireccion);
        return mySucursalDireccion;
    }

    @Override
    public List<SucursalDireccion> traerDireccionPorSucursal(BigInteger myIdSucursal) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("SucursalDireccion.findBySucursal");
        q.setParameter("idSucursal", myIdSucursal);
        return (List<SucursalDireccion>) q.list();
    }
}
