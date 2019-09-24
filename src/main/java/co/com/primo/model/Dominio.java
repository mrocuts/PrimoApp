/*
 * PACKAGE
 */
package co.com.primo.model;

/*
 * IMPORTS
 */
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase que representa el Objeto Dominio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 07/08/2019
 */

@Entity
@Table(name="dominio")
@NamedQueries({
    @NamedQuery(name = "Dominio.findByTipo", query = "SELECT d FROM Dominio d WHERE d.myTipoDominio.idTipoDominio=:idTipoDominio")})
public class Dominio {
    
    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger idDominio;

    @Column
    private String strDescripcion;
    
    @ManyToOne
    private TipoDominio myTipoDominio;
    
    @ManyToOne
    private Dominio myDominioPadre;

    /**
     * Constructor
     */
    public Dominio(BigInteger idDominio){
        this.idDominio = idDominio;
    }
    
    /**
     * @return the idDominio
     */
    public BigInteger getIdDominio() {
        return idDominio;
    }

    /**
     * @return the strDescripcion
     */
    public String getStrDescripcion() {
        return strDescripcion;
    }

    /**
     * @return the myTipoDominio
     */
    public TipoDominio getMyTipoDominio() {
        return myTipoDominio;
    }

    /**
     * @return the myDominioPadre
     */
    public Dominio getMyDominioPadre() {
        return myDominioPadre;
    }

    /**
     * @param idDominio the idDominio to set
     */
    public void setIdDominio(BigInteger idDominio) {
        this.idDominio = idDominio;
    }

    /**
     * @param strDescripcion the strDescripcion to set
     */
    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    /**
     * @param myTipoDominio the myTipoDominio to set
     */
    public void setMyTipoDominio(TipoDominio myTipoDominio) {
        this.myTipoDominio = myTipoDominio;
    }

    /**
     * @param myDominioPadre the myDominioPadre to set
     */
    public void setMyDominioPadre(Dominio myDominioPadre) {
        this.myDominioPadre = myDominioPadre;
    }

}
