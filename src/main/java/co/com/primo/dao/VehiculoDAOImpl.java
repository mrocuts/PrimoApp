/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Vehiculo;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Vehiculo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 03/04/2020
 */
@Repository
public class VehiculoDAOImpl implements VehiculoDAO{
  
    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Vehiculo agregarVehiculo(Vehiculo myVehiculo) {
        mySessionFactory.getCurrentSession().save(myVehiculo);
        return myVehiculo;
    }

    @Override
    public Vehiculo traerVehiculo(Vehiculo myVehiculo) {
        return (Vehiculo) mySessionFactory.getCurrentSession().get(Vehiculo.class, myVehiculo.getIdVehiculo());
    }

    @Override
    public List<Vehiculo> traerVehiculosGaraje(BigInteger myIdGaraje) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("Vehiculo.findByGaraje");
        q.setParameter("idGaraje", myIdGaraje);
        return (List<Vehiculo>) q.list();
    }

    @Override
    public Vehiculo actualizarVehiculo(Vehiculo myVehiculo) {
        mySessionFactory.getCurrentSession().update(myVehiculo);
        return myVehiculo;
    }   

    @Override
    public void bajarVehiculos(BigInteger myIdGaraje) {
        Query q = mySessionFactory.getCurrentSession().createQuery("UPDATE Vehiculo v SET v.bitSubido = 0 WHERE v.myGaraje.idGaraje = :myIdGaraje");
        q.setParameter("myIdGaraje", myIdGaraje);
        q.executeUpdate();
    }
}