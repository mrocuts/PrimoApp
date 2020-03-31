/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.PromocionDAO;
import co.com.primo.model.Promocion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Promocion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
 */
@Service
@Transactional
public class PromocionServiceImpl implements PromocionService{

    /** Atributos de Mètodo **/
    @Autowired
    private PromocionDAO myPromocionDAO;    

    @Override
    public Promocion agregarPromocion(Promocion myPromocion) {
        return myPromocionDAO.agregarPromocion(myPromocion);
    }

    @Override
    public Promocion traerPromocion(Promocion myPromocion) {
        return myPromocionDAO.traerPromocion(myPromocion);
    }

    @Override
    public Promocion actualizarPromocion(Promocion myPromocion) {
        return myPromocionDAO.actualizarPromocion(myPromocion);
    }
}