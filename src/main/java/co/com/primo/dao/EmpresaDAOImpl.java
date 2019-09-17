/*
 * PACKAGE
 */
package co.com.primo.dao;

/*
 * IMPORTS
 */
import co.com.primo.model.Empresa;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa las funcionalidades del objeto Empresa
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 12/09/2019
 */
@Repository
public class EmpresaDAOImpl implements EmpresaDAO {

    /** Atributos de Clase **/
    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Empresa agregarEmpresa(Empresa myEmpresa) {
        mySessionFactory.getCurrentSession().saveOrUpdate(myEmpresa);
        return myEmpresa;
    }

    @Override
    public Empresa traerEmpresa(Empresa myEmpresa) {
        return (Empresa) mySessionFactory.getCurrentSession().get(Empresa.class, myEmpresa.getIdEmpresa());
    }

    @Override
    public Empresa actualizarEmpresa(Empresa myEmpresa) {
       mySessionFactory.getCurrentSession().update(myEmpresa);
       return myEmpresa;
    }   
}