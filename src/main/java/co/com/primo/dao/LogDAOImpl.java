/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Log;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Log
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 07/08/2019
 */
@Repository
public class LogDAOImpl implements LogDAO{

    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;
    @Override

    public void agregarLog(Log myLog) {
        mySessionFactory.getCurrentSession().save(myLog);    
    }
}
