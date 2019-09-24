/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Dominio;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que define los servicios del objeto Dominio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 24/09/2019
*/
public interface DominioService {
    public List<Dominio> traerDominioTipo(BigInteger myIdTipoDominio);
}