/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebastien
 */
@Entity
@Table(name = "SWAPLOCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Swaplocation.findAll", query = "SELECT s FROM Swaplocation s"),
    @NamedQuery(name = "Swaplocation.findByIdswaplocation", query = "SELECT s FROM Swaplocation s WHERE s.idSwapLocation = :idSwapLocation"),
    @NamedQuery(name = "Swaplocation.findByName", query = "SELECT s FROM Swaplocation s WHERE s.name = :name"),
    @NamedQuery(name = "Swaplocation.findByTempsaction", query = "SELECT s FROM Swaplocation s WHERE s.tempsAction = :tempsAction")})
public class Swaplocation extends Point implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSWAPLOCATION")
    private Integer idSwapLocation;
    @Size(max = 45)
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TEMPSACTION")
    private double tempsAction;
    @OneToMany(mappedBy = "swaplocation")
    private Collection<Swapbody> swapbodys;
    /*@JoinColumn(name = "NPOINT", referencedColumnName = "IDPOINT")
    @ManyToOne(optional = false)
    private Point npoint;*/

    public Swaplocation() {
    }

   public Swaplocation(int idSwapLocation, Collection<Swapbody> swapbodys, double tempsAction, int id, String nom, float x, float y) {
        super(id, nom, x, y);
        this.idSwapLocation = idSwapLocation;
        this.swapbodys = swapbodys;
        this.tempsAction = tempsAction;
    }


    public Integer getIdswaplocation() {
        return idSwapLocation;
    }

    public void setIdswaplocation(Integer idSwapLocation) {
        this.idSwapLocation = idSwapLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTempsaction() {
        return tempsAction;
    }

    public void setTempsaction(double tempsAction) {
        this.tempsAction = tempsAction;
    }

    @XmlTransient
    public Collection<Swapbody> getSwapbodyCollection() {
        return swapbodys;
    }

    public void setSwapbodyCollection(Collection<Swapbody> swapbodyCollection) {
        this.swapbodys = swapbodyCollection;
    }

    /*public Point getNpoint() {
        return npoint;
    }

    public void setNpoint(Point npoint) {
        this.npoint = npoint;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSwapLocation != null ? idSwapLocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Swaplocation)) {
            return false;
        }
        Swaplocation other = (Swaplocation) object;
        if ((this.idSwapLocation == null && other.idSwapLocation != null) || (this.idSwapLocation != null && !this.idSwapLocation.equals(other.idSwapLocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Swaplocation[ idSwapLocation=" + idSwapLocation + " ]";
    }
    
}
