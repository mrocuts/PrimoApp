/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Servicio;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que contiene las funcionalidades del objeto Servicio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 18/09/2019
*/
public interface ServicioDAO {
    public Servicio agregarServicio(Servicio myServicio);
    public Servicio traerServicio(Servicio myServicio);
    public Servicio actualizarServicio(Servicio myServicio);
    public List<Servicio> traerServiciosPorEmpresa(BigInteger idEmpresa);
}
