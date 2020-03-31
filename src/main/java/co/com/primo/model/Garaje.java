/*
 * PACKAGE
 */
package co.com.primo.model;

/*
 * IMPORTS
 */
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Clase que representa el Objeto Garaje
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 31/03/2019
 */

@Entity
@Table(name="garaje")
public class Garaje implements Serializable {
    
    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger idGaraje;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtmFechaCreacion;
    
    @Column
    private boolean bitActivo;
    
    @ManyToOne
    @JoinColumn(name = "IDUSUARIO")
    private Usuario myUsuario;

    /**
     * Constructor Vacio de la clase Garaje
     */
    public Garaje(){
    }

    /**
     * Constructor de la clase Garaje
     * @param dtmFechaCreacion
     * @param bitActivo
     * @param myUsuario 
     */
    public Garaje(Date dtmFechaCreacion,boolean bitActivo,Usuario myUsuario){
        this.dtmFechaCreacion = dtmFechaCreacion;
        this.bitActivo = bitActivo;
        this.myUsuario = myUsuario;
    }
    
    /**
     * @return the idGaraje
     */
    public BigInteger getIdGaraje() {
        return idGaraje;
    }

    /**
     * @param idGaraje the idGaraje to set
     */
    public void setIdGaraje(BigInteger idGaraje) {
        this.idGaraje = idGaraje;
    }

    /**
     * @return the dtmFechaCreacion
     */
    public Date getDtmFechaCreacion() {
        return dtmFechaCreacion;
    }

    /**
     * @param dtmFechaCreacion the dtmFechaCreacion to set
     */
    public void setDtmFechaCreacion(Date dtmFechaCreacion) {
        this.dtmFechaCreacion = dtmFechaCreacion;
    }

    /**
     * @return the bitActivo
     */
    public boolean isBitActivo() {
        return bitActivo;
    }

    /**
     * @param bitActivo the bitActivo to set
     */
    public void setBitActivo(boolean bitActivo) {
        this.bitActivo = bitActivo;
    }

    /**
     * @return the myUsuario
     */
    public Usuario getMyUsuario() {
        return myUsuario;
    }

    /**
     * @param myUsuario the myUsuario to set
     */
    public void setMyUsuario(Usuario myUsuario) {
        this.myUsuario = myUsuario;
    }
}