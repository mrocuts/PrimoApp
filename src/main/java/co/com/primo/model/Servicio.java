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
 * Clase que representa el Objeto Servicio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 15/08/2019
 */

@Entity
@Table(name="servicio")
public class Servicio implements Serializable {

    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger idServicio;

    @Column
    private String strNombre;

    @Column
    private double  dblValor;
    
    @ManyToOne
    @JoinColumn(name = "IDDOMINIO")
    private Dominio myDominio;

    /**
     * Constructor vacio de la Clase Servicio
     */
    public Servicio(){
        super();
    } 

    /**
     * Constructor de la Clase Servicio
     * @param idServicio
     */
    public Servicio(BigInteger idServicio){
        this.idServicio = idServicio;
    } 

    /**
     * @return the idServicio
     */
    public BigInteger getIdServicio() {
        return idServicio;
    }

    /**
     * @return the strNombre
     */
    public String getStrNombre() {
        return strNombre;
    }

    /**
     * @return the dblValor
     */
    public double getDblValor() {
        return dblValor;
    }

    /**
     * @return the myDominio
     */
    public Dominio getMyDominio() {
        return myDominio;
    }

    /**
     * @param idServicio the idServicio to set
     */
    public void setIdServicio(BigInteger idServicio) {
        this.idServicio = idServicio;
    }

    /**
     * @param strNombre the strNombre to set
     */
    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    /**
     * @param dblValor the dblValor to set
     */
    public void setDblValor(double dblValor) {
        this.dblValor = dblValor;
    }

    /**
     * @param myDominio the myDominio to set
     */
    public void setMyDominio(Dominio myDominio) {
        this.myDominio = myDominio;
    }
}