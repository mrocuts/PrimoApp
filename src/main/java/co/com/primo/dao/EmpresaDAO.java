/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Empresa;
import java.math.BigInteger;
import java.util.List;

/**
 * Interfaz que contiene las funcionalidades del objeto Empresa
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 12/09/2019
*/
public interface EmpresaDAO {
    public Empresa agregarEmpresa(Empresa myEmpresa);
    public Empresa traerEmpresa(Empresa myEmpresa);
    public Empresa traerEmpresa(String myStrIdentificacion);
    public List<Empresa> traerEmpresaPorUsuario(BigInteger myIdUsuario);
    public Empresa actualizarEmpresa(Empresa myEmpresa);
}