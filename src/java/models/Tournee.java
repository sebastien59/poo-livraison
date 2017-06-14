/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebastien
 */
@Entity
@Table(name = "TOURNEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tournee.findAll", query = "SELECT t FROM Tournee t"),
    @NamedQuery(name = "Tournee.findByIdtournee", query = "SELECT t FROM Tournee t WHERE t.idTournee = :idTournee"),
    @NamedQuery(name = "Tournee.findByCouttotal", query = "SELECT t FROM Tournee t WHERE t.coutTotal = :coutTotal"),
    @NamedQuery(name = "Tournee.findByTempstotal", query = "SELECT t FROM Tournee t WHERE t.tempsTotal = :tempsTotal"),
    @NamedQuery(name = "Tournee.findByMaxSemiTrailerAttached", query = "SELECT t FROM Tournee t WHERE t.maxSemiTrailerAttached = :maxSemiTrailerAttached"),
    @NamedQuery(name = "Tournee.findByMaxSwapBodyTr", query = "SELECT t FROM Tournee t WHERE t.maxSwapBodyTr = :maxSwapBodyTr"),
    @NamedQuery(name = "Tournee.findByMaxSwapBodySm", query = "SELECT t FROM Tournee t WHERE t.maxSwapBodySm = :maxSwapBodySm")})
public class Tournee implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ntournee")
    private Collection<Arc> arcs;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTOURNEE")
    private Integer idTournee;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COUTTOTAL")
    private double coutTotal;
    @Column(name = "TEMPSTOTAL")
    private double tempsTotal;
    @Column(name = "MAX_SEMI_TRAILER_ATTACHED")
    private Integer maxSemiTrailerAttached;
    @Column(name = "MAX_SWAP_BODY_TR")
    private Integer maxSwapBodyTr;
    @Column(name = "MAX_SWAP_BODY_SM")
    private Integer maxSwapBodySm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ntournee")
    private Collection<Solution> solutions;

    public Tournee() {
    }

    public Tournee(int idTournee, Collection<Arc> arcs, double coutTotal, double tempsTotal) {
        this.idTournee = idTournee;
        this.arcs = arcs;
        this.coutTotal = coutTotal;
        this.tempsTotal = tempsTotal;
    }
    

    public Integer getIdtournee() {
        return idTournee;
    }

    public void setIdtournee(Integer idTournee) {
        this.idTournee = idTournee;
    }

    public double getCouttotal() {
        return coutTotal;
    }

    public void setCouttotal(double coutTotal) {
        this.coutTotal = coutTotal;
    }

    public double getTempstotal() {
        return tempsTotal;
    }

    public void setTempstotal(double tempsTotal) {
        this.tempsTotal = tempsTotal;
    }

    public Integer getMaxSemiTrailerAttached() {
        return maxSemiTrailerAttached;
    }

    public void setMaxSemiTrailerAttached(Integer maxSemiTrailerAttached) {
        this.maxSemiTrailerAttached = maxSemiTrailerAttached;
    }

    public Integer getMaxSwapBodyTr() {
        return maxSwapBodyTr;
    }

    public void setMaxSwapBodyTr(Integer maxSwapBodyTr) {
        this.maxSwapBodyTr = maxSwapBodyTr;
    }

    public Integer getMaxSwapBodySm() {
        return maxSwapBodySm;
    }

    public void setMaxSwapBodySm(Integer maxSwapBodySm) {
        this.maxSwapBodySm = maxSwapBodySm;
    }

    @XmlTransient
    public Collection<Solution> getSolutionCollection() {
        return solutions;
    }

    public void setSolutionCollection(Collection<Solution> solutionCollection) {
        this.solutions = solutionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTournee != null ? idTournee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tournee)) {
            return false;
        }
        Tournee other = (Tournee) object;
        if ((this.idTournee == null && other.idTournee != null) || (this.idTournee != null && !this.idTournee.equals(other.idTournee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Tournee[ idTournee=" + idTournee + " ]";
    }

    @XmlTransient
    public Collection<Arc> getArcCollection() {
        return arcs;
    }

    public void setArcCollection(Collection<Arc> arcs) {
        this.arcs = arcs;
    }
    
}
