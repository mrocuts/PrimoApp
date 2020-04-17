/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.TipoVehiculo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Tipo de Vehiculo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 03/04/2020
 */
@Repository
public class TipoVehiculoDAOImpl implements TipoVehiculoDAO{
    
    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public TipoVehiculo agregarTipoVehiculo(TipoVehiculo myTipoVehiculo) {
        mySessionFactory.getCurrentSession().save(myTipoVehiculo);
        return myTipoVehiculo;
    }

    @Override
    public List<TipoVehiculo> traerTiposVehiculo() {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("TipoVehiculo.getAll");
        return (List<TipoVehiculo>) q.list();
    }

    @Override
    public TipoVehiculo actualizarTipoVehiculo(TipoVehiculo myTipoVehiculo) {
        mySessionFactory.getCurrentSession().update(myTipoVehiculo);
        return myTipoVehiculo;
    }
}