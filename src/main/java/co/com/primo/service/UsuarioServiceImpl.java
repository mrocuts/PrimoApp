/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.UsuarioDAO;
import co.com.primo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Usuario
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/07/2019
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

    /** Atributos de Mètodo **/
    @Autowired
    private UsuarioDAO myUsuarioDAO;
    
    @Override
    public Usuario agregarUsuario(Usuario myUsuario) {
        return myUsuarioDAO.agregarUsuario(myUsuario);
    }

    @Override
    public Usuario traerUsuario(Usuario myUsuario) {
        return myUsuarioDAO.traerUsuario(myUsuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario myUsuario) {
        return myUsuarioDAO.actualizarUsuario(myUsuario);
    }

    @Override
    public Usuario login(Usuario myUsuario) {
        return myUsuarioDAO.login(myUsuario);
    }
}