/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.DominioDAO;
import co.com.primo.model.Dominio;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Dominio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 24/09/2019
 */
@Service
@Transactional
public class DominioServiceImpl implements DominioService{

    /** Atributos de Mètodo **/
    @Autowired
    private DominioDAO myDominioDAO;
    
    @Override
    public List<Dominio> traerDominioTipo(BigInteger myIdTipoDominio) {
        return myDominioDAO.traerDominioTipo(myIdTipoDominio);
    }
}