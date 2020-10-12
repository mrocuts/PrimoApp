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

/**
 * Clase que representa el Objeto Promocion
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 15/08/2019
 */

@Entity
@Table(name="promocion")
public class Promocion implements Serializable {

    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idPromocion;
    @Column
    private double dblPorcentajeDescuento;
    @Column
    private Date dtmFechaInicial;
    @Column
    private Date dtmFechaFinal;
    @Column
    private String strDescripcion;
    @Column
    private boolean bitActivo;
    
    @ManyToOne
    @JoinColumn(name = "IDSUCURSALSERVICIO")
    private SucursalServicio mySucursalServicio;

    /**
     * @return the idPromocion
     */
    public BigInteger getIdPromocion() {
        return idPromocion;
    }

    /**
     * @return the dblPorcentajeDescuento
     */
    public double getDblPorcentajeDescuento() {
        return dblPorcentajeDescuento;
    }

    /**
     * @return the dtmFechaInicial
     */
    public Date getDtmFechaInicial() {
        return dtmFechaInicial;
    }

    /**
     * @return the dtmFechaFinal
     */
    public Date getDtmFechaFinal() {
        return dtmFechaFinal;
    }

    /**
     * @return the strDescripcion
     */
    public String getStrDescripcion() {
        return strDescripcion;
    }

    /**
     * @return the bitActivo
     */
    public boolean isBitActivo() {
        return bitActivo;
    }

    /**
     * @return the mySucursalServicio
     */
    public SucursalServicio getMySucursalServicio() {
        return mySucursalServicio;
    }

    /**
     * @param idPromocion the idPromocion to set
     */
    public void setIdPromocion(BigInteger idPromocion) {
        this.idPromocion = idPromocion;
    }

    /**
     * @param dblPorcentajeDescuento the dblPorcentajeDescuento to set
     */
    public void setDblPorcentajeDescuento(double dblPorcentajeDescuento) {
        this.dblPorcentajeDescuento = dblPorcentajeDescuento;
    }

    /**
     * @param dtmFechaInicial the dtmFechaInicial to set
     */
    public void setDtmFechaInicial(Date dtmFechaInicial) {
        this.dtmFechaInicial = dtmFechaInicial;
    }

    /**
     * @param dtmFechaFinal the dtmFechaFinal to set
     */
    public void setDtmFechaFinal(Date dtmFechaFinal) {
        this.dtmFechaFinal = dtmFechaFinal;
    }

    /**
     * @param strDescripcion the strDescripcion to set
     */
    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    /**
     * @param bitActivo the bitActivo to set
     */
    public void setBitActivo(boolean bitActivo) {
        this.bitActivo = bitActivo;
    }

    /**
     * @param mySucursalServicio the mySucursalServicio to set
     */
    public void setMySucursalServicio(SucursalServicio mySucursalServicio) {
        this.mySucursalServicio = mySucursalServicio;
    }
}