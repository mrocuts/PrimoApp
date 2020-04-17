/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Garaje;
import java.math.BigInteger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Garaje
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 31/03/2020
 */
@Repository
public class GarajeDAOImpl implements GarajeDAO {

    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Garaje agregarGaraje(Garaje myGaraje) {
        mySessionFactory.getCurrentSession().save(myGaraje);
        return myGaraje;
    }

    @Override
    public Garaje traerGaraje(Garaje myGaraje) {
        return (Garaje) mySessionFactory.getCurrentSession().get(Garaje.class, myGaraje.getIdGaraje());
    }

    @Override
    public Garaje traerGarajePorUsuario(BigInteger myIdUsuario) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("Garaje.findByUsuario");
        q.setParameter("idUsuario", myIdUsuario);
        return (Garaje) q.list().get(0);
    }

    @Override
    public Garaje actualizarGaraje(Garaje myGaraje) {
        mySessionFactory.getCurrentSession().update(myGaraje);
        return myGaraje;
    }   
}