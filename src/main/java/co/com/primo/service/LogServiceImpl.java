/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.LogDAO;
import co.com.primo.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Log
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 07/08/2019
 */
@Service
@Transactional
public class LogServiceImpl implements LogService{

    /** Atributos de Mètodo **/
    @Autowired
    private LogDAO myLogDAO;
    
    @Override
    public void agregarLog(Log myLog) {
        myLogDAO.agregarLog(myLog);
    }
}
