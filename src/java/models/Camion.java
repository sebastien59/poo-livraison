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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastien
 */
@Entity
@Table(name = "CAMION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camion.findAll", query = "SELECT c FROM Camion c"),
    @NamedQuery(name = "Camion.findByIdcamion", query = "SELECT c FROM Camion c WHERE c.idCamion = :idCamion"),
    @NamedQuery(name = "Camion.findByNom", query = "SELECT c FROM Camion c WHERE c.nom = :nom")})
public class Camion extends Vehicule implements Serializable {

    private static final long serialVersionUID = 1L;
    /*@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCAMION")*/
    private Integer idCamion;
    @Size(max = 45)
    @Column(name = "NOM")
    private String nom;
    @JoinColumn(name = "NVEHICULE", referencedColumnName = "IDVEHICULE")
    @ManyToOne(optional = false)
    private Vehicule nvehicule;

    public Camion() {
    }

    public Camion(int idCamion, String nom, int idVehicule, Swapbody chargement, double coutFixe, double coefTemps, double coefDistance) {
        super(idVehicule, chargement, coutFixe, coefTemps, coefDistance);
        this.idCamion = idCamion;
        this.nom = nom;
    }

    public Integer getIdcamion() {
        return idCamion;
    }

    public void setIdcamion(Integer idCamion) {
        this.idCamion = idCamion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        hash += (idCamion != null ? idCamion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camion)) {
            return false;
        }
        Camion other = (Camion) object;
        if ((this.idCamion == null && other.idCamion != null) || (this.idCamion != null && !this.idCamion.equals(other.idCamion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Camion[ idCamion=" + idCamion + " ]";
    }
    
}
