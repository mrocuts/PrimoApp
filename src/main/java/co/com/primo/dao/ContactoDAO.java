/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Contacto;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que contiene las funcionalidades del objeto Contacto
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 18/09/2019
*/
public interface ContactoDAO {
    public Contacto agregarContacto(Contacto myContacto);
    public Contacto traerContacto(Contacto myContacto);
    public List<Contacto> traerContactoPorEmpresa(BigInteger myIdEmpresa);
    public Contacto actualizarContacto(Contacto myContacto);
}