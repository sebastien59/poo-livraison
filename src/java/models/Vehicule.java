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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "VEHICULE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicule.findAll", query = "SELECT v FROM Vehicule v"),
    @NamedQuery(name = "Vehicule.findByIdvehicule", query = "SELECT v FROM Vehicule v WHERE v.idVehicule = :idVehicule"),
    @NamedQuery(name = "Vehicule.findByCoutfixe", query = "SELECT v FROM Vehicule v WHERE v.coutFixe = :coutFixe"),
    @NamedQuery(name = "Vehicule.findByCoeftemp", query = "SELECT v FROM Vehicule v WHERE v.coefTemps = :coefTemps"),
    @NamedQuery(name = "Vehicule.findByCoefdistance", query = "SELECT v FROM Vehicule v WHERE v.coefDistance = :coefDistance")})
public class Vehicule implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nvehicule")
    private Collection<Arc> arcCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVEHICULE")
    private Integer idVehicule;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COUTFIXE")
    private double coutFixe;
    @Column(name = "COEFTEMPS")
    private double coefTemps;
    @Column(name = "COEFDISTANCE")
    private double coefDistance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nvehicule")
    private Collection<Camion> camionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nvehicule")
    private Collection<Train> trainCollection;
    @JoinColumn(name = "NSWAPBODY", referencedColumnName = "IDSWAPBODY")
    @ManyToOne(optional = false)
    private Swapbody chargement;

    public Vehicule() {
    }

    public Vehicule(int idVehicule, Swapbody chargement, double coutFixe, double coefTemps, double coefDistance) {
        this.idVehicule = idVehicule;
        this.chargement = chargement;
        this.coutFixe = coutFixe;
        this.coefTemps = coefTemps;
        this.coefDistance = coefDistance;
    }

    public Integer getIdvehicule() {
        return idVehicule;
    }

    public void setIdvehicule(Integer idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Double getCoutfixe() {
        return coutFixe;
    }

    public void setCoutfixe(Double coutFixe) {
        this.coutFixe = coutFixe;
    }

    public double getCoeftemp() {
        return coefTemps;
    }

    public void setCoeftemp(double coefTemps) {
        this.coefTemps = coefTemps;
    }

    public Double getCoefdistance() {
        return coefDistance;
    }

    public void setCoefdistance(Double coefDistance) {
        this.coefDistance = coefDistance;
    }

    @XmlTransient
    public Collection<Camion> getCamionCollection() {
        return camionCollection;
    }

    public void setCamionCollection(Collection<Camion> camionCollection) {
        this.camionCollection = camionCollection;
    }

    @XmlTransient
    public Collection<Train> getTrainCollection() {
        return trainCollection;
    }

    public void setTrainCollection(Collection<Train> trainCollection) {
        this.trainCollection = trainCollection;
    }

    public Swapbody getChargement() {
        return chargement;
    }

    public void setNswapbody(Swapbody nswapbody) {
        this.chargement = nswapbody;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehicule != null ? idVehicule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicule)) {
            return false;
        }
        Vehicule other = (Vehicule) object;
        if ((this.idVehicule == null && other.idVehicule != null) || (this.idVehicule != null && !this.idVehicule.equals(other.idVehicule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Vehicule[ idVehicule=" + idVehicule + " ]";
    }

    @XmlTransient
    public Collection<Arc> getArcCollection() {
        return arcCollection;
    }

    public void setArcCollection(Collection<Arc> arcCollection) {
        this.arcCollection = arcCollection;
    }
    
}
