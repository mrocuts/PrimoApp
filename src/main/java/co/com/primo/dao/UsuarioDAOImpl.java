/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Usuario;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Usuario
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 19/07/2019
 */
@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Usuario agregarUsuario(Usuario myUsuario) {
        mySessionFactory.getCurrentSession().saveOrUpdate(myUsuario);
        return myUsuario;
    }

    @Override
    public Usuario traerUsuario(Usuario myUsuario) {
        return (Usuario) mySessionFactory.getCurrentSession().get(Usuario.class, myUsuario.getIdUsuario());
    }
    
    @Override
    public Usuario traerUsuario(String email) {
        Query q = mySessionFactory.getCurrentSession().getNamedQuery("Usuario.findByEmail");
        q.setParameter("strUsuario", email);
        return (Usuario) q.uniqueResult();
    }
    
    @Override
    public Usuario actualizarUsuario(Usuario myUsuario) {
        mySessionFactory.getCurrentSession().update(myUsuario);
        return myUsuario; 
    }

    @Override
    public Usuario login(Usuario myUsuario) {
        //Crear la consulta del Usuario
        Query myQuery = mySessionFactory.getCurrentSession().createQuery("from Usuario u where u.strUsuario = :usuario and u.strPassword = :password and u.bitActivo = true and u.intTipoUsuario = :intTipoUsuario ");
        myQuery.setParameter("usuario", myUsuario.getStrUsuario());
        myQuery.setParameter("password", myUsuario.getStrPassword());
        myQuery.setParameter("intTipoUsuario", myUsuario.getIntTipoUsuario());
        return (Usuario) myQuery.uniqueResult();
    }

    @Override
    public Usuario verificarUsuario(Usuario myUsuario) {
        //Crear la consulta del Usuario
        Query myQuery = mySessionFactory.getCurrentSession().createQuery("from Usuario u where u.strUsuario = :usuario ");
        myQuery.setParameter("usuario", myUsuario.getStrUsuario());
        return (Usuario) myQuery.uniqueResult();
    }
}
