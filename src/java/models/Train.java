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
@Table(name = "TRAIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Train.findAll", query = "SELECT t FROM Train t"),
    @NamedQuery(name = "Train.findByIdtrain", query = "SELECT t FROM Train t WHERE t.idTrain = :idTrain")})
public class Train extends Vehicule implements Serializable {

    private static final long serialVersionUID = 1L;
    /*@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTRAIN")*/
    private Integer idTrain;
    @JoinColumn(name = "CHARGEMENT", referencedColumnName = "IDSWAPBODY")
    @ManyToOne
    private Swapbody remorque;
    @JoinColumn(name = "NVEHICULE", referencedColumnName = "IDVEHICULE")
    @ManyToOne(optional = false)
    private Vehicule nvehicule;

    public Train() {
    }

    public Train(int idTrain, Swapbody remorque, int idVehicule, Swapbody chargement, double coutFixe, double coefTemps, double coefDistance) {
        super(idVehicule, chargement, coutFixe, coefTemps, coefDistance);
        this.idTrain = idTrain;
        this.remorque = remorque;
    }

    public Integer getIdtrain() {
        return idTrain;
    }

    public void setIdtrain(Integer idTrain) {
        this.idTrain = idTrain;
    }

    public Swapbody getRemorque() {
        return remorque;
    }

    public void setRemorque(Swapbody remorque) {
        this.remorque = remorque;
    }

    public Vehicule getNvehicule() {
        return nvehicule;
    }

    public void setNvehicule(Vehicule nvehicule) {
        this.nvehicule = nvehicule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrain != null ? idTrain.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Train)) {
            return false;
        }
        Train other = (Train) object;
        if ((this.idTrain == null && other.idTrain != null) || (this.idTrain != null && !this.idTrain.equals(other.idTrain))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Train[ idTrain=" + idTrain + " ]";
    }
    
}
