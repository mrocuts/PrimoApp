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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase que representa el Objeto Contacto
 * @author Mauricio Alejandro Rocuts
 * @version 1.0
 * @date 15/08/2019
 */

@Entity
@Table(name="contacto")
@NamedQueries({
    @NamedQuery(name = "Contacto.findByEmpresa", query = "SELECT c FROM Contacto c WHERE c.myEmpresa.idEmpresa=:idEmpresa")})
public class Contacto implements Serializable {
    
    /** Atributos de Clase **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger idContacto;
    
    @Column
    private String strIdentificacion;
    
    @Column
    private String strNombre;
    
    @Column
    private String strApellido;
    
    @Column
    private String strDireccion;
    
    @Column
    private String strTelefono;
    
    @Column
    private String strEmail;
    
    @Column
    private Date dtmFechaNacimiento;
 
    @ManyToOne
    @JoinColumn(name = "IDEMPRESA")
    private Empresa myEmpresa;

    @ManyToOne
    @JoinColumn(name = "IDDOMINIO")
    private Dominio myDominio;

    /**
     * @return the idContacto
     */
    public BigInteger getIdContacto() {
        return idContacto;
    }

    /**
     * @return the strIdentificacion
     */
    public String getStrIdentificacion() {
        return strIdentificacion;
    }

    /**
     * @return the strNombre
     */
    public String getStrNombre() {
        return strNombre;
    }

    /**
     * @return the strApellido
     */
    public String getStrApellido() {
        return strApellido;
    }

    /**
     * @return the strDireccion
     */
    public String getStrDireccion() {
        return strDireccion;
    }

    /**
     * @return the strTelefono
     */
    public String getStrTelefono() {
        return strTelefono;
    }

    /**
     * @return the strEmail
     */
    public String getStrEmail() {
        return strEmail;
    }

    /**
     * @return the dtmFechaNacimiento
     */
    public Date getDtmFechaNacimiento() {
        return dtmFechaNacimiento;
    }

    /**
     * @return the myEmpresa
     */
    public Empresa getMyEmpresa() {
        return myEmpresa;
    }

    /**
     * @return the myDominio
     */
    public Dominio getMyDominio() {
        return myDominio;
    }

    /**
     * @param idContacto the idContacto to set
     */
    public void setIdContacto(BigInteger idContacto) {
        this.idContacto = idContacto;
    }

    /**
     * @param strIdentificacion the strIdentificacion to set
     */
    public void setStrIdentificacion(String strIdentificacion) {
        this.strIdentificacion = strIdentificacion;
    }

    /**
     * @param strNombre the strNombre to set
     */
    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    /**
     * @param strApellido the strApellido to set
     */
    public void setStrApellido(String strApellido) {
        this.strApellido = strApellido;
    }

    /**
     * @param strDireccion the strDireccion to set
     */
    public void setStrDireccion(String strDireccion) {
        this.strDireccion = strDireccion;
    }

    /**
     * @param strTelefono the strTelefono to set
     */
    public void setStrTelefono(String strTelefono) {
        this.strTelefono = strTelefono;
    }

    /**
     * @param strEmail the strEmail to set
     */
    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    /**
     * @param dtmFechaNacimiento the dtmFechaNacimiento to set
     */
    public void setDtmFechaNacimiento(Date dtmFechaNacimiento) {
        this.dtmFechaNacimiento = dtmFechaNacimiento;
    }

    /**
     * @param myEmpresa the myEmpresa to set
     */
    public void setMyEmpresa(Empresa myEmpresa) {
        this.myEmpresa = myEmpresa;
    }

    /**
     * @param myDominio the myDominio to set
     */
    public void setMyDominio(Dominio myDominio) {
        this.myDominio = myDominio;
    }
}