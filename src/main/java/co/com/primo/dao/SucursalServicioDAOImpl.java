/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Sucursal;
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
    public List<SucursalServicio> traerServiciosPorSucursal(BigInteger myIdEmpresa, BigInteger myIdSucursal) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("SucursalServicio.findBySucursal");
        q.setParameter("idEmpresa", myIdEmpresa);
        q.setParameter("idSucursal", myIdSucursal);
        return (List<SucursalServicio>) q.list();
    }

    @Override
    public List<Sucursal> traerSucursalPorServicio(BigInteger myIdEmpresa, BigInteger myIdServicio) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("SucursalServicio.findSucursalByService");
        q.setParameter("idEmpresa", myIdEmpresa);
        q.setParameter("idServicio", myIdServicio);
        return (List<Sucursal>) q.list();
    }

    @Override
    public void borrarServicioPorSucursal(BigInteger myIdEmpresa, BigInteger myIdSucursal, BigInteger myIdServicio) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("SucursalServicio.specificService");
        q.setParameter("idEmpresa", myIdEmpresa);
        q.setParameter("idSucursal", myIdSucursal);
        q.setParameter("idServicio", myIdServicio);
        mySessionFactory.getCurrentSession().delete((SucursalServicio)q.uniqueResult());
    }

    @Override
    public Object actualizarServicioPorSucursal(SucursalServicio mySucursalServicio) {
        mySessionFactory.getCurrentSession().update(mySucursalServicio);
        return mySucursalServicio;
    }
}
