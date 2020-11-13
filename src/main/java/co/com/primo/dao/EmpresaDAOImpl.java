/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Empresa;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Empresa
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 12/09/2019
 */
@Repository
public class EmpresaDAOImpl implements EmpresaDAO {

    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Empresa agregarEmpresa(Empresa myEmpresa) {
        mySessionFactory.getCurrentSession().save(myEmpresa);
        return myEmpresa;
    }

    @Override
    public Empresa traerEmpresa(Empresa myEmpresa) {
        System.out.println(((Empresa)mySessionFactory.getCurrentSession().get(Empresa.class, myEmpresa.getIdEmpresa())).getDtmFechaFundacion().toString());
        return (Empresa) mySessionFactory.getCurrentSession().get(Empresa.class, myEmpresa.getIdEmpresa());
    }

    @Override
    public Empresa traerEmpresa(String myStrIdentificacion) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("Empresa.findByIdentificacion");
        System.out.println("Consultado");
        q.setParameter("strIdentificacion", myStrIdentificacion);
        return (Empresa) q.uniqueResult();
    }
    
    @Override
    public List<Empresa> traerEmpresaPorUsuario(BigInteger myIdUsuario) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("Empresa.findByUsuario");
        q.setParameter("idUsuario", myIdUsuario);
        return (List<Empresa>) q.list();
    }

    @Override
    public Empresa actualizarEmpresa(Empresa myEmpresa) {
       mySessionFactory.getCurrentSession().update(myEmpresa);
       return myEmpresa;
    }   
}