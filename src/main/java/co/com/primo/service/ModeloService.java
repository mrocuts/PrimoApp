/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Modelo;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que define los servicios del objeto Modelo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 03/04/2019
*/
public interface ModeloService {
    public Modelo agregarModelo(Modelo myModelo);
    public List<Modelo> traerModelosMarca(BigInteger myIdMarca);
    public Modelo actualizarModelo(Modelo myModelo);
}
