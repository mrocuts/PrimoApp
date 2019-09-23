/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.SucursalServicio;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Sucursal Servicio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
 */
@Repository
public class SucursalServicioDAOImpl implements SucursalServicioDAO{

    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public SucursalServicio agregarSucursalServicio(SucursalServicio mySucursalServicio) {
        mySessionFactory.getCurrentSession().save(mySucursalServicio);
        return mySucursalServicio;
    }

    @Override
    public List<SucursalServicio> traerServicioPorSucursal(BigInteger myIdSucursal) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("SucursalServicio.findBySucursal");
        q.setParameter("idSucursal", myIdSucursal);
        return (List<SucursalServicio>) q.list();
    }
}