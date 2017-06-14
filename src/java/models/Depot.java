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
@Table(name = "DEPOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Depot.findAll", query = "SELECT d FROM Depot d"),
    @NamedQuery(name = "Depot.findByIddepot", query = "SELECT d FROM Depot d WHERE d.idDepot = :idDepot"),
    @NamedQuery(name = "Depot.findByNomdepot", query = "SELECT d FROM Depot d WHERE d.nomDepot = :nomDepot")})
public class Depot extends Point implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDEPOT")
    private Integer idDepot;
    @Size(max = 45)
    @Column(name = "NOMDEPOT")
    private String nomDepot;
    /*@JoinColumn(name = "NPOINT", referencedColumnName = "IDPOINT")
    @ManyToOne(optional = false)*/
    private Point npoint;

    public Depot() {
    }

    public Depot(String idDepot, String nomDepot, int id, String nom, double x, double y) {
        super(id, nom, x, y);
        this.nomDepot = nomDepot;
    }

    public Integer getIddepot() {
        return idDepot;
    }

    public void setIddepot(Integer idDepot) {
        this.idDepot = idDepot;
    }

    public String getNomdepot() {
        return nomDepot;
    }

    public void setNomdepot(String nomDepot) {
        this.nomDepot = nomDepot;
    }

    public Point getNpoint() {
        return npoint;
    }

    public void setNpoint(Point npoint) {
        this.npoint = npoint;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepot != null ? idDepot.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Depot)) {
            return false;
        }
        Depot other = (Depot) object;
        if ((this.idDepot == null && other.idDepot != null) || (this.idDepot != null && !this.idDepot.equals(other.idDepot))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Depot{" + "idDepot=" + idDepot + ", nomDepot=" + nomDepot + ", npoint=" + npoint + '}';
    }

   
}
