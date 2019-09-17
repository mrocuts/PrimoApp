/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.EmpresaDAO;
import co.com.primo.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Empresa
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 13/09/2019
 */
@Service
@Transactional
public class EmpresaServiceImpl implements EmpresaService{

    /** Atributos de Mètodo **/
    @Autowired
    private EmpresaDAO myEmpresaDAO;    

    @Override
    public Empresa agregarEmpresa(Empresa myEmpresa) {
        return myEmpresaDAO.agregarEmpresa(myEmpresa);
    }

    @Override
    public Empresa traerEmpresa(Empresa myEmpresa) {
        return myEmpresaDAO.traerEmpresa(myEmpresa);
    }

    @Override
    public Empresa actualizarEmpresa(Empresa myEmpresa) {
        return myEmpresaDAO.actualizarEmpresa(myEmpresa);
    }
}