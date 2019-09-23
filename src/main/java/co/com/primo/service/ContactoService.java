/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Contacto;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que define los servicios del objeto Contacto
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/009/2019
*/
public interface ContactoService {
    public Contacto agregarContacto(Contacto myContacto);
    public Contacto traerContacto(Contacto myContacto);
    public List<Contacto> traerContactoPorEmpresa(BigInteger myIdEmpresa);
    public Contacto actualizarContacto(Contacto myContacto);
}