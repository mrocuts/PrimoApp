/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Log;

/**
 * Interfaz que contiene las funcionalidades del objeto Log
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 07/08/2019
*/
public interface LogDAO {
    public void agregarLog(Log myLog);
}
