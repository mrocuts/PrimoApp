/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.GarajeDAO;
import co.com.primo.model.Garaje;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Garaje
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 31/03/2020
 */
@Service
@Transactional
public class GarajeServiceImpl implements GarajeService{

    /** Atributos de Mètodo **/
    @Autowired
    private GarajeDAO myGarajeDAO;    

    @Override
    public Garaje agregarGaraje(Garaje myGaraje) {
        return myGarajeDAO.agregarGaraje(myGaraje);
    }

    @Override
    public Garaje traerGaraje(Garaje myGaraje) {
        return myGarajeDAO.traerGaraje(myGaraje);
    }

    @Override
    public Garaje traerGarajePorUsuario(BigInteger myIdUsuario) {
        return myGarajeDAO.traerGarajePorUsuario(myIdUsuario);
    }

    @Override
    public Garaje actualizarGaraje(Garaje myGaraje) {
        return myGarajeDAO.actualizarGaraje(myGaraje);
    }
}
