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
import javax.persistence.Table;

/**
 * Clase que representa el Objeto Tipo de Dominio
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 07/08/2019
 */

@Entity
@Table(name="tipodominio")
public class TipoDominio {
    
    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idTipoDominio;

    @Column
    private String strDescripcion;

    /**
     * @return the idTipoDominio
     */
    public BigInteger getIdTipoDominio() {
        return idTipoDominio;
    }

    /**
     * @return the strDescripcion
     */
    public String getStrDescripcion() {
        return strDescripcion;
    }

    /**
     * @param idTipoDominio the idTipoDominio to set
     */
    public void setIdTipoDominio(BigInteger idTipoDominio) {
        this.idTipoDominio = idTipoDominio;
    }

    /**
     * @param strDescripcion the strDescripcion to set
     */
    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public TipoDominio() {
    }
}