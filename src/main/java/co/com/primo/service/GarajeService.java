/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Garaje;
import java.math.BigInteger;

/**
 * Interfaz que define los servicios del objeto Garaje
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 31/03/2020
*/
public interface GarajeService {
    public Garaje agregarGaraje(Garaje myGaraje);
    public Garaje traerGaraje(Garaje myGaraje);
    public Garaje traerGarajePorUsuario(BigInteger myIdUsuario);
    public Garaje actualizarGaraje(Garaje myGaraje);    
}
