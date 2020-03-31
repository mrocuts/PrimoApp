/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Contacto;
import co.com.primo.model.Garaje;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que contiene las funcionalidades del objeto Garaje
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 31/03/2020
*/
public interface GarajeDAO {
    public Garaje agregarGaraje(Garaje myGaraje);
    public Garaje traerGajare(Garaje myGaraje);
    public Garaje traerGarajePorUsuario(BigInteger myIdUsuario);
    public Garaje actualizarContacto(Contacto myContacto);
}