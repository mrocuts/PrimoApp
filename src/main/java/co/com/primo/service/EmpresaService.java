/*
 * PACKAGE
 */
package co.com.primo.service;

/*
 * IMPORTS
 */
import co.com.primo.model.Empresa;

/**
 * Interfaz que define los servicios del objeto Empresa
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 13/09/2019
 */
public interface EmpresaService {
    public Empresa agregarEmpresa(Empresa myEmpresa);
    public Empresa traerEmpresa(Empresa myEmpresa);
    public Empresa actualizarEmpresa(Empresa myEmpresa);
}