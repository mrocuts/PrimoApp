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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase que representa el Objeto Modelo
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 01/04/2020
 */

@Entity
@Table(name="vehiculo")
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findByGaraje", query = "SELECT v FROM Vehiculo v WHERE v.myGaraje.idGaraje=:idGaraje")})
public class Vehiculo implements Serializable {
    
    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger idVehiculo;

    @Column
    private BigInteger intAnio;

    @Column
    private String strPlaca;

    @Column
    private String strObservacion;

    @Column
    private String strSerial;

    @Column
    private String strColor;
    
    @Column
    private boolean bitActivo;

    @Column
    private boolean bitSubido;

    @Column
    private BigInteger intPuertas;

    @Column
    private String strMotor;

    @Column
    private String strTransmision;
    
    @ManyToOne
    @JoinColumn(name = "IDTIPOVEHICULO")
    private TipoVehiculo myTipoVehiculo;

    @ManyToOne
    @JoinColumn(name = "IDMODELO")
    private Modelo myModelo;

    @ManyToOne
    @JoinColumn(name = "IDGARAJE")
    private Garaje myGaraje;

    /**
     * @return the idVehiculo
     */
    public BigInteger getIdVehiculo() {
        return idVehiculo;
    }

    /**
     * @param idVehiculo the idVehiculo to set
     */
    public void setIdVehiculo(BigInteger idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    /**
     * @return the intAnio
     */
    public BigInteger getIntAnio() {
        return intAnio;
    }

    /**
     * @param intAnio the intAnio to set
     */
    public void setIntAnio(BigInteger intAnio) {
        this.intAnio = intAnio;
    }

    /**
     * @return the strObservacion
     */
    public String getStrObservacion() {
        return strObservacion;
    }

    /**
     * @param strObservacion the strObservacion to set
     */
    public void setStrObservacion(String strObservacion) {
        this.strObservacion = strObservacion;
    }

    /**
     * @return the strSerial
     */
    public String getStrSerial() {
        return strSerial;
    }

    /**
     * @param strSerial the strSerial to set
     */
    public void setStrSerial(String strSerial) {
        this.strSerial = strSerial;
    }

    /**
     * @return the strColor
     */
    public String getStrColor() {
        return strColor;
    }

    /**
     * @param strColor the strColor to set
     */
    public void setStrColor(String strColor) {
        this.strColor = strColor;
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
     * @return the intPuertas
     */
    public BigInteger getIntPuertas() {
        return intPuertas;
    }

    /**
     * @param intPuertas the intPuertas to set
     */
    public void setIntPuertas(BigInteger intPuertas) {
        this.intPuertas = intPuertas;
    }

    /**
     * @return the strMotor
     */
    public String getStrMotor() {
        return strMotor;
    }

    /**
     * @param strMotor the strMotor to set
     */
    public void setStrMotor(String strMotor) {
        this.strMotor = strMotor;
    }

    /**
     * @return the strTransmision
     */
    public String getStrTransmision() {
        return strTransmision;
    }

    /**
     * @param strTransmision the strTransmision to set
     */
    public void setStrTransmision(String strTransmision) {
        this.strTransmision = strTransmision;
    }

    /**
     * @return the myTipoVehiculo
     */
    public TipoVehiculo getMyTipoVehiculo() {
        return myTipoVehiculo;
    }

    /**
     * @param myTipoVehiculo the myTipoVehiculo to set
     */
    public void setMyTipoVehiculo(TipoVehiculo myTipoVehiculo) {
        this.myTipoVehiculo = myTipoVehiculo;
    }

    /**
     * @return the myModelo
     */
    public Modelo getMyModelo() {
        return myModelo;
    }

    /**
     * @param myModelo the myModelo to set
     */
    public void setMyModelo(Modelo myModelo) {
        this.myModelo = myModelo;
    }

    /**
     * @return the myGaraje
     */
    public Garaje getMyGaraje() {
        return myGaraje;
    }

    /**
     * @param myGaraje the myGaraje to set
     */
    public void setMyGaraje(Garaje myGaraje) {
        this.myGaraje = myGaraje;
    }

    /**
     * @return the strPlaca
     */
    public String getStrPlaca() {
        return strPlaca;
    }

    /**
     * @param strPlaca the strPlaca to set
     */
    public void setStrPlaca(String strPlaca) {
        this.strPlaca = strPlaca;
    }

    /**
     * @return the bitSubido
     */
    public boolean isBitSubido() {
        return bitSubido;
    }

    /**
     * @param bitSubido the bitSubido to set
     */
    public void setBitSubido(boolean bitSubido) {
        this.bitSubido = bitSubido;
    }
}