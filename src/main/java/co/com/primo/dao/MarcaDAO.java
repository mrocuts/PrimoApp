/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Marca;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que contiene las funcionalidades del objeto Marca
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 01/04/2020
*/
public interface MarcaDAO {
    public Marca agregarMarca(Marca myMarca);
    public List<Marca> traerMarcasTipoVehiculo(BigInteger myIdTipoVehiculo);
    public Marca actualizarMarca(Marca myMarca);
}