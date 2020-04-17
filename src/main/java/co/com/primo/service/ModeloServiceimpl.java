/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.ModeloDAO;
import co.com.primo.model.Modelo;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Tipo de Modelo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 03/04/2019
 */
@Service
@Transactional
public class ModeloServiceimpl implements ModeloService{
    
    /** Atributos de Mètodo **/
    @Autowired
    private ModeloDAO myModeloDAO;    

    @Override
    public Modelo agregarModelo(Modelo myModelo) {
        return myModeloDAO.agregarModelo(myModelo);
    }

    @Override
    public List<Modelo> traerModelosMarca(BigInteger myIdMarca) {
        return myModeloDAO.traerModelosMarca(myIdMarca);
    }

    @Override
    public Modelo actualizarModelo(Modelo myModelo) {
        return myModeloDAO.actualizarModelo(myModelo);
    }
}
