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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa el Objeto Telefono
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 15/08/2019
 */

@Entity
@Table(name="telefono")
public class Telefono implements Serializable {

    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idTelefono;

    @Column
    private String strTelefono;

    @Column
    private boolean bitPrincipal;

    @ManyToOne
    @JoinColumn(name = "IDDOMINIO")
    private Dominio myDominio;

    /**
     * Constructor vacio de la Clase Telefono
     */
    public Telefono(){
        super();
    } 

    /**
     * Constructor de la Clase Telefono
     * @param idTelefono
     */
    public Telefono(BigInteger idTelefono){
        this.idTelefono = idTelefono;
    } 

    /**
     * @return the idTelefono
     */
    public BigInteger getIdTelefono() {
        return idTelefono;
    }

    /**
     * @return the strTelefono
     */
    public String getStrTelefono() {
        return strTelefono;
    }

    /**
     * @return the bitPrincipal
     */
    public boolean isBitPrincipal() {
        return bitPrincipal;
    }

    /**
     * @return the myDominio
     */
    public Dominio getMyDominio() {
        return myDominio;
    }

    /**
     * @param idTelefono the idTelefono to set
     */
    public void setIdTelefono(BigInteger idTelefono) {
        this.idTelefono = idTelefono;
    }

    /**
     * @param strTelefono the strTelefono to set
     */
    public void setStrTelefono(String strTelefono) {
        this.strTelefono = strTelefono;
    }

    /**
     * @param bitPrincipal the bitPrincipal to set
     */
    public void setBitPrincipal(boolean bitPrincipal) {
        this.bitPrincipal = bitPrincipal;
    }

    /**
     * @param myDominio the myDominio to set
     */
    public void setMyDominio(Dominio myDominio) {
        this.myDominio = myDominio;
    }
}