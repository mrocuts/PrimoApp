/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.primo.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author OvalleGA
 */
@Entity
@Table(name = "servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s"),
    @NamedQuery(name = "Servicio.findByIdservicio", query = "SELECT s FROM Servicio s WHERE s.idservicio = :idservicio"),
    @NamedQuery(name = "Servicio.findByStrnombre", query = "SELECT s FROM Servicio s WHERE s.strnombre = :strnombre")})
public class Servicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger idservicio;
    @Basic(optional = false)
    @Column(name = "STRNOMBRE")
    private String strnombre;
    @JoinColumn(name = "IDDOMINIO", referencedColumnName = "IDDOMINIO")
    @ManyToOne(optional = false)
    private Dominio iddominio;
    @JoinColumn(name = "IDEMPRESA", referencedColumnName = "IDEMPRESA")
    @ManyToOne(optional = false)
    private Empresa idempresa;

    public Servicio() {
    }

    public Servicio(BigInteger idservicio) {
        this.idservicio = idservicio;
    }

    public Servicio(BigInteger idservicio, String strnombre) {
        this.idservicio = idservicio;
        this.strnombre = strnombre;
    }

    public BigInteger getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(BigInteger idservicio) {
        this.idservicio = idservicio;
    }

    public String getStrnombre() {
        return strnombre;
    }

    public void setStrnombre(String strnombre) {
        this.strnombre = strnombre;
    }

    public Dominio getIddominio() {
        return iddominio;
    }

    public void setIddominio(Dominio iddominio) {
        this.iddominio = iddominio;
    }

    public Empresa getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Empresa idempresa) {
        this.idempresa = idempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservicio != null ? idservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idservicio == null && other.idservicio != null) || (this.idservicio != null && !this.idservicio.equals(other.idservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.primo.model.Servicio[ idservicio=" + idservicio + " ]";
    }
    
}
