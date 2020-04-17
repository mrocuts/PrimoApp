/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Modelo;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Modelo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 03/04/2020
 */
@Repository
public class ModeloDAOImpl implements ModeloDAO{
    
    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Modelo agregarModelo(Modelo myModelo) {
        mySessionFactory.getCurrentSession().save(myModelo);
        return myModelo;
    }

    @Override
    public List<Modelo> traerModelosMarca(BigInteger myIdMarca) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("Modelo.findByMarca");
        q.setParameter("idMarca", myIdMarca);
        return (List<Modelo>) q.list();
    }

    @Override
    public Modelo actualizarModelo(Modelo myModelo) {
        mySessionFactory.getCurrentSession().update(myModelo);
        return myModelo;
    }
}