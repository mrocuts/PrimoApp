/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Marca;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que define los servicios del objeto Marca
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 03/04/2019
*/
public interface MarcaService {
    public Marca agregarMarca(Marca myMarca);
    public List<Marca> traerMarcasTipoVehiculo(BigInteger myIdTipoVehiculo);
    public Marca actualizarMarca(Marca myMarca);
}
