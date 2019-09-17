/*
 * PACKAGE
 */
package co.com.primo.model;

/*
 * IMPORTS
 */
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa el Objeto Sucursal Servicio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 15/08/2019
 */

@Entity
@Table(name="sucursal_servicio")
public class SucursalServicio implements Serializable {

    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger idSucursalServicio;
    
    @ManyToOne
    @JoinColumn(name = "IDSUCURSAL")
    private Sucursal mySucursal;

    @ManyToOne
    @JoinColumn(name = "IDSERVICIO")
    private Servicio myServicio;

    /**
     * @return the idSucursalServicio
     */
    public BigInteger getIdSucursalServicio() {
        return idSucursalServicio;
    }

    /**
     * @return the mySucursal
     */
    public Sucursal getMySucursal() {
        return mySucursal;
    }

    /**
     * @return the myServicio
     */
    public Servicio getMyServicio() {
        return myServicio;
    }

    /**
     * @param idSucursalServicio the idSucursalServicio to set
     */
    public void setIdSucursalServicio(BigInteger idSucursalServicio) {
        this.idSucursalServicio = idSucursalServicio;
    }

    /**
     * @param mySucursal the mySucursal to set
     */
    public void setMySucursal(Sucursal mySucursal) {
        this.mySucursal = mySucursal;
    }

    /**
     * @param myServicio the myServicio to set
     */
    public void setMyServicio(Servicio myServicio) {
        this.myServicio = myServicio;
    }
}