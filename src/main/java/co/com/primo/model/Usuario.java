/*
 * PACKAGE
 */
package co.com.primo.model;

/*
 * IMPORTS
 */
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Clase que representa el Objeto Usuario
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 17/07/2019
 */

@Entity
@Table(name="usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT g FROM Usuario g"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT g FROM Usuario g WHERE g.strUsuario=:strUsuario")})
public class Usuario implements Serializable {
    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idUsuario;
    
    @Column
    private BigInteger intTipoUsuario;

    @Column
    private String strUsuario;
    
    @Column
    private String strPassword;
    
    @Column
    private int intNumIntentos;
    
    @Column
    private boolean bitActivo;

    /**
     * @return the idUsuario
     */
    public BigInteger getIdUsuario() {
        return idUsuario;
    }

    /**
     * @return the strUsuario
     */
    public String getStrUsuario() {
        return strUsuario;
    }

    /**
     * @return the strPassword
     */
    public String getStrPassword() {
        return strPassword;
    }

    /**
     * @return the intNumIntentos
     */
    public int getIntNumIntentos() {
        return intNumIntentos;
    }

    /**
     * @return the bitActivo
     */
    public boolean isBitActivo() {
        return bitActivo;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(BigInteger idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @param strUsuario the strUsuario to set
     */
    public void setStrUsuario(String strUsuario) {
        this.strUsuario = strUsuario;
    }

    /**
     * @param strPassword the strPassword to set
     */
    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    /**
     * @param intNumIntentos the intNumIntentos to set
     */
    public void setIntNumIntentos(int intNumIntentos) {
        this.intNumIntentos = intNumIntentos;
    }

    /**
     * @param bitActivo the bitActivo to set
     */
    public void setBitActivo(boolean bitActivo) {
        this.bitActivo = bitActivo;
    }

    /**
     * @return the intTipoUsuario
     */
    public BigInteger getIntTipoUsuario() {
        return intTipoUsuario;
    }

    /**
     * @param intTipoUsuario the intTipoUsuario to set
     */
    public void setIntTipoUsuario(BigInteger intTipoUsuario) {
        this.intTipoUsuario = intTipoUsuario;
    }

    public Usuario() {
    }
}