/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.MarcaDAO;
import co.com.primo.model.Marca;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Tipo de Marca
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 03/04/2019
 */
@Service
@Transactional
public class MarcaServiceImpl implements MarcaService{

    /** Atributos de Mètodo **/
    @Autowired
    private MarcaDAO myMarcaDAO;    

    @Override
    public Marca agregarMarca(Marca myMarca) {
        return myMarcaDAO.agregarMarca(myMarca);
    }

    @Override
    public List<Marca> traerMarcasTipoVehiculo(BigInteger myIdTipoVehiculo) {
        return myMarcaDAO.traerMarcasTipoVehiculo(myIdTipoVehiculo);
    }

    @Override
    public Marca actualizarMarca(Marca myMarca) {
        return myMarcaDAO.actualizarMarca(myMarca);
    }
}
