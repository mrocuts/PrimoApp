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

/**
 * Interfaz que contiene las funcionalidades del objeto Modelo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 01/04/2020
*/
public interface ModeloDAO {
    public Modelo agregarModelo(Modelo myModelo);
    public List<Modelo> traerModelosMarca(BigInteger myIdMarca);
    public Modelo actualizarModelo(Modelo myModelo);
}