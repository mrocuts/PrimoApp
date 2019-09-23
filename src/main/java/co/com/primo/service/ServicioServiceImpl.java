/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.dao.ServicioDAO;
import co.com.primo.model.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa los servicios del objeto Servicio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 23/09/2019
 */
@Service
@Transactional
public class ServicioServiceImpl implements ServicioService{

    /** Atributos de Mètodo **/
    @Autowired
    private ServicioDAO myServicioDAO;    

    @Override
    public Servicio agregarServicio(Servicio myServicio) {
        return myServicioDAO.agregarServicio(myServicio);
    }

    @Override
    public Servicio traerServicio(Servicio myServicio) {
        return myServicioDAO.traerServicio(myServicio);
    }

    @Override
    public Servicio actualizarServicio(Servicio myServicio) {
        return myServicioDAO.actualizarServicio(myServicio);
    }
}