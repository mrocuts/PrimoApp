/*
 * PACKAGE
 */
package co.com.primo.model;

/*
 * IMPORTS
 */
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Blob;
import java.util.Date;
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
 * Clase que representa el Objeto Empresa
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 12/08/2019
 */

@Entity
@Table(name="empresa")
@NamedQueries({
    @NamedQuery(name = "Empresa.findByIdentificacion", query = "SELECT e FROM Empresa e WHERE e.strIdentificacion=:strIdentificacion"),
    @NamedQuery(name = "Empresa.findByUsuario", query = "SELECT e FROM Empresa e WHERE e.myUsuario.idUsuario=:idUsuario")})
public class Empresa implements Serializable {
    
    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger idEmpresa;
    
    @Column
    private String strIdentificacion;
    
    @Column
    private String strRazonSocial;
    
    @Column
    private Date dtmFechaFundacion;
    
    @Column
    private Blob imgLogo;
    
    @ManyToOne
    @JoinColumn(name = "IDUSUARIO")
    private Usuario myUsuario;
    
    @ManyToOne
    @JoinColumn(name = "IDDOMINIO")
    private Dominio myDominio;

    /**
     * @return the idEmpresa
     */
    public BigInteger getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @return the strIdentificacion
     */
    public String getStrIdentificacion() {
        return strIdentificacion;
    }

    /**
     * @return the strRazonSocial
     */
    public String getStrRazonSocial() {
        return strRazonSocial;
    }

    /**
     * @return the dtmFechaFundacion
     */
    public Date getDtmFechaFundacion() {
        return dtmFechaFundacion;
    }

    /**
     * @return the imgLogo
     */
    public Blob getImgLogo() {
        return imgLogo;
    }

    /**
     * @return the myUsuario
     */
    public Usuario getMyUsuario() {
        return myUsuario;
    }

    /**
     * @return the myDominio
     */
    public Dominio getMyDominio() {
        return myDominio;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(BigInteger idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * @param strIdentificacion the strIdentificacion to set
     */
    public void setStrIdentificacion(String strIdentificacion) {
        this.strIdentificacion = strIdentificacion;
    }

    /**
     * @param strRazonSocial the strRazonSocial to set
     */
    public void setStrRazonSocial(String strRazonSocial) {
        this.strRazonSocial = strRazonSocial;
    }

    /**
     * @param dtmFechaFundacion the dtmFechaFundacion to set
     */
    public void setDtmFechaFundacion(Date dtmFechaFundacion) {
        this.dtmFechaFundacion = dtmFechaFundacion;
    }

    /**
     * @param imgLogo the imgLogo to set
     */
    public void setImgLogo(Blob imgLogo) {
        this.imgLogo = imgLogo;
    }

    /**
     * @param myUsuario the myUsuario to set
     */
    public void setMyUsuario(Usuario myUsuario) {
        this.myUsuario = myUsuario;
    }

    /**
     * @param myDominio the myDominio to set
     */
    public void setMyDominio(Dominio myDominio) {
        this.myDominio = myDominio;
    }
}