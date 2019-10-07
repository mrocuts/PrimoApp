/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Dominio;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Dominio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 24/09/2019
 */
@Repository
public class DominioDAOImpl implements DominioDAO{

    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public List<Dominio> traerDominioTipo(BigInteger myIdTipoDominio) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("Dominio.findByTipo");
        q.setParameter("idTipoDominio", myIdTipoDominio);
        return (List<Dominio>) q.list();
    }

    @Override
    public List<Dominio> traerDominioPadre(BigInteger myIdDominioPadre) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("Dominio.findByPadre");
        q.setParameter("idDominioPadre", myIdDominioPadre);
        return (List<Dominio>) q.list();
    }
}
