/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastien
 */
@Entity
@Table(name = "SWAPBODY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Swapbody.findAll", query = "SELECT s FROM Swapbody s"),
    @NamedQuery(name = "Swapbody.findByIdswapbody", query = "SELECT s FROM Swapbody s WHERE s.idswapbody = :idswapbody"),
    @NamedQuery(name = "Swapbody.findByQuantite", query = "SELECT s FROM Swapbody s WHERE s.quantite = :quantite")})
public class Swapbody implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSWAPBODY")
    private Integer idswapbody;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTITE")
    private double quantite;
    @JoinColumn(name = "SWAPLOCATION", referencedColumnName = "IDSWAPLOCATION")
    @ManyToOne
    private Swaplocation swaplocation;

    public Swapbody() {
    }

    public Swapbody(Integer idswapbody) {
        this.idswapbody = idswapbody;
    }

    public Integer getIdswapbody() {
        return idswapbody;
    }

    public void setIdswapbody(Integer idswapbody) {
        this.idswapbody = idswapbody;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public Swaplocation getSwaplocation() {
        return swaplocation;
    }

    public void setSwaplocation(Swaplocation swaplocation) {
        this.swaplocation = swaplocation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idswapbody != null ? idswapbody.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Swapbody)) {
            return false;
        }
        Swapbody other = (Swapbody) object;
        if ((this.idswapbody == null && other.idswapbody != null) || (this.idswapbody != null && !this.idswapbody.equals(other.idswapbody))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Swapbody[ idswapbody=" + idswapbody + " ]";
    }
    
}
