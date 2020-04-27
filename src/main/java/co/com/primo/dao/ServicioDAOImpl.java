/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Servicio;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Servicio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
 */
@Repository
public class ServicioDAOImpl implements ServicioDAO{

    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Servicio agregarServicio(Servicio myServicio) {
        mySessionFactory.getCurrentSession().save(myServicio);
        return myServicio;
    }

    @Override
    public Servicio traerServicio(Servicio myServicio) {
        return (Servicio) mySessionFactory.getCurrentSession().get(Servicio.class, myServicio.getIdservicio());
    }

    @Override
    public Servicio actualizarServicio(Servicio myServicio) {
        mySessionFactory.getCurrentSession().update(myServicio);
        return myServicio;
    }    

    @Override
    public List<Servicio> traerServiciosPorEmpresa(BigInteger idEmpresa) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("Servicio.findByCompany");
        q.setParameter("idEmpresa", idEmpresa);
        return (List<Servicio>) q.list();
    }
}