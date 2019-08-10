/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Usuario;

/**
 * Interfaz que contiene las funcionalidades del objeto Usuario
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/07/2019
*/
public interface UsuarioDAO {
    public Usuario agregarUsuario(Usuario myUsuario);
    public Usuario traerUsuario(Usuario myUsuario);
    public Usuario traerUsuario(String myUsuario);
    public Usuario actualizarUsuario(Usuario myUsuario);
    public Usuario login(Usuario myUsuario);
    public Usuario verificarUsuario(Usuario myUsuario);
}
