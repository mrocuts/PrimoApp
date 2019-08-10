/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Usuario;

/**
 * Interfaz que define los servicios del objeto Usuario
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/07/2019
 */

public interface UsuarioService {
    public Usuario agregarUsuario(Usuario myUsuario);
    public Usuario traerUsuario(Usuario myUsuario);
    public Usuario traerUsuario(String email);
    public Usuario actualizarUsuario(Usuario myUsuario);
    public Usuario login(Usuario myUsuario);
    public Usuario verificarUsuario(Usuario myUsuario);
}
