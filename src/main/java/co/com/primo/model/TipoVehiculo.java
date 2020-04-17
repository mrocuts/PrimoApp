/*
 * PACKAGE
 */
package co.com.primo.model;

/*
 * IMPORTS
 */
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase que representa el Objeto Tipo de Vehiculo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 01/04/2020
 */

@Entity
@Table(name="tipo_vehiculo")
@NamedQueries({
    @NamedQuery(name = "TipoVehiculo.getAll", query = "SELECT t FROM TipoVehiculo t")})
public class TipoVehiculo implements Serializable {
    
    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger idTipoVehiculo;
    
    @Column
    private String strDescripcion;

    /**
     * @return the IdTipoVehiculo
     */
    public BigInteger getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    /**
     * @param IdTipoVehiculo the IdTipoVehiculo to set
     */
    public void setIdTipoVehiculo(BigInteger idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    /**
     * @return the strDescripcion
     */
    public String getStrDescripcion() {
        return strDescripcion;
    }

    /**
     * @param strDescripcion the strDescripcion to set
     */
    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }   
}