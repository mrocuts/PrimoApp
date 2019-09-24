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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase que representa el Objeto Sucursal Direccion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 15/08/2019
 */

@Entity
@Table(name="sucursal_direccion")
@NamedQueries({
    @NamedQuery(name = "SucursalDireccion.findBySucursal", query = "SELECT sd FROM SucursalDireccion sd WHERE sd.mySucursal.idSucursal=:idSucursal")})
public class SucursalDireccion implements Serializable {

    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger idSucursalDireccion;
    
    @ManyToOne
    @JoinColumn(name = "IDSUCURSAL")
    private Sucursal mySucursal;
   
    @ManyToOne
    @JoinColumn(name = "IDDIRECCION")
    private Direccion myDireccion;

    /**
     * Constructor vacio de la Clase SucursalDireccion
     */
    public SucursalDireccion(){
        super();
    } 

    /**
     * Constructor de la Clase SucursalDireccion
     * @param mySucursal
     * @param myDireccion
     */
    public SucursalDireccion(Sucursal mySucursal, Direccion myDireccion){
        this.mySucursal = mySucursal;
        this.myDireccion = myDireccion;
    } 

    /**
     * @return the idSucursalDireccion
     */
    public BigInteger getIdSucursalDireccion() {
        return idSucursalDireccion;
    }

    /**
     * @return the mySucursal
     */
    public Sucursal getMySucursal() {
        return mySucursal;
    }

    /**
     * @return the myDireccion
     */
    public Direccion getMyDireccion() {
        return myDireccion;
    }

    /**
     * @param idSucursalDireccion the idSucursalDireccion to set
     */
    public void setIdSucursalDireccion(BigInteger idSucursalDireccion) {
        this.idSucursalDireccion = idSucursalDireccion;
    }

    /**
     * @param mySucursal the mySucursal to set
     */
    public void setMySucursal(Sucursal mySucursal) {
        this.mySucursal = mySucursal;
    }

    /**
     * @param myDireccion the myDireccion to set
     */
    public void setMyDireccion(Direccion myDireccion) {
        this.myDireccion = myDireccion;
    }
}