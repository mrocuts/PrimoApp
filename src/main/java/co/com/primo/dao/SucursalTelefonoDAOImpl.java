/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.SucursalTelefono;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Sucursal Telefono
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/09/2019
 */
@Repository
public class SucursalTelefonoDAOImpl implements SucursalTelefonoDAO{
    
    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public SucursalTelefono agregarSucursalTelefono(SucursalTelefono mySucursalTelefono) {
        mySessionFactory.getCurrentSession().save(mySucursalTelefono);
        return mySucursalTelefono;
    }

    @Override
    public List<SucursalTelefono> traerTelefonoPorSucursal(BigInteger myIdSucursal) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("SucursalTelefono.findBySucursal");
        q.setParameter("idSucursal", myIdSucursal);
        return (List<SucursalTelefono>) q.list();
    }
}