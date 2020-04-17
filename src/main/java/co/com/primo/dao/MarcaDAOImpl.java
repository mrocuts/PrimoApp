/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Marca;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Marca
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 03/04/2020
 */
@Repository
public class MarcaDAOImpl implements MarcaDAO{
    
    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Marca agregarMarca(Marca myMarca) {
        mySessionFactory.getCurrentSession().save(myMarca);
        return myMarca;
    }

    @Override
    public List<Marca> traerMarcasTipoVehiculo(BigInteger myIdTipoVehiculo) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("Marca.findByTipoVehiculo");
        q.setParameter("idTipoVehiculo", myIdTipoVehiculo);
        return (List<Marca>) q.list();
    }

    @Override
    public Marca actualizarMarca(Marca myMarca) {
        mySessionFactory.getCurrentSession().update(myMarca);
        return myMarca;
    }
}
