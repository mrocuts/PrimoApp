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
 * Clase que representa el Objeto Sucursal Telefono
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 15/08/2019
 */

@Entity
@Table(name="sucursal_telefono")
@NamedQueries({
    @NamedQuery(name = "SucursalTelefono.findBySucursal", query = "SELECT sd FROM SucursalTelefono sd WHERE sd.mySucursal.idSucursal=:idSucursal")})
public class SucursalTelefono implements Serializable {

    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idSucursalTelefono;
    
    @ManyToOne
    @JoinColumn(name = "IDSUCURSAL")
    private Sucursal mySucursal;
    
    @ManyToOne
    @JoinColumn(name = "IDTELEFONO")
    private Telefono myTelefono;

    /**
     * Constructor vacio de la Clase SucursalTelefono
     */
    public SucursalTelefono(){
        super();
    } 

    /**
     * Constructor de la Clase SucursalTelefono
     * @param mySucursal
     * @param myTelefono
     */
    public SucursalTelefono(Sucursal mySucursal, Telefono myTelefono){
        this.mySucursal = mySucursal;
        this.myTelefono = myTelefono;
    } 

    /**
     * @return the idSucursalTelefono
     */
    public BigInteger getIdSucursalTelefono() {
        return idSucursalTelefono;
    }

    /**
     * @return the mySucursal
     */
    public Sucursal getMySucursal() {
        return mySucursal;
    }

    /**
     * @return the myTelefono
     */
    public Telefono getMyTelefono() {
        return myTelefono;
    }

    /**
     * @param idSucursalTelefono the idSucursalTelefono to set
     */
    public void setIdSucursalTelefono(BigInteger idSucursalTelefono) {
        this.idSucursalTelefono = idSucursalTelefono;
    }

    /**
     * @param mySucursal the mySucursal to set
     */
    public void setMySucursal(Sucursal mySucursal) {
        this.mySucursal = mySucursal;
    }

    /**
     * @param myTelefono the myTelefono to set
     */
    public void setMyTelefono(Telefono myTelefono) {
        this.myTelefono = myTelefono;
    }
}