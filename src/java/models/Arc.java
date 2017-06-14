/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebastien
 */
@Entity
@Table(name = "ARC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arc.findAll", query = "SELECT a FROM Arc a"),
    @NamedQuery(name = "Arc.findByIdarc", query = "SELECT a FROM Arc a WHERE a.idarc = :idarc"),
    @NamedQuery(name = "Arc.findByCost", query = "SELECT a FROM Arc a WHERE a.cost = :cost"),
    @NamedQuery(name = "Arc.findByRem", query = "SELECT a FROM Arc a WHERE a.rem = :rem")})
public class Arc implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COST")
    private double cost;
    @Column(name = "REM")
    private Integer rem;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDARC")
    private Integer idarc;
    @JoinTable(name = "ARC_HAS_POINT", joinColumns = {
        @JoinColumn(name = "ARC_IDARC", referencedColumnName = "IDARC")}, inverseJoinColumns = {
        @JoinColumn(name = "POINT_IDPOINT", referencedColumnName = "IDPOINT")})
    @ManyToMany
    private Collection<Point> pointCollection;
    @JoinColumn(name = "NTOURNEE", referencedColumnName = "IDTOURNEE")
    @ManyToOne(optional = false)
    private Tournee ntournee;
    @JoinColumn(name = "NVEHICULE", referencedColumnName = "IDVEHICULE")
    @ManyToOne(optional = false)
    private Vehicule nvehicule;

    public Arc() {
    }

    public Arc(Integer idarc) {
        this.idarc = idarc;
    }

    public Integer getIdarc() {
        return idarc;
    }

    public void setIdarc(Integer idarc) {
        this.idarc = idarc;
    }

    public Point getP1() {
        return ((ArrayList<Point>) pointCollection).get(0);
    }

    public void setP1(Point p1) {
        ((ArrayList<Point>) pointCollection).set(0, p1);
    }
    
    public Point getP2() {
        return ((ArrayList<Point>) pointCollection).get(0);
    }

    public void setP2(Point p2) {
        ((ArrayList<Point>) pointCollection).set(0, p2);
    }
    
    @XmlTransient
    public Collection<Point> getPointCollection() {
        return pointCollection;
    }

    public void setPointCollection(Collection<Point> pointCollection) {
        this.pointCollection = pointCollection;
    }

    public Tournee getNtournee() {
        return ntournee;
    }

    public void setNtournee(Tournee ntournee) {
        this.ntournee = ntournee;
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
        hash += (idarc != null ? idarc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arc)) {
            return false;
        }
        Arc other = (Arc) object;
        if ((this.idarc == null && other.idarc != null) || (this.idarc != null && !this.idarc.equals(other.idarc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Arc[ idarc=" + idarc + " ]";
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Integer getRem() {
        return rem;
    }

    public void setRem(Integer rem) {
        this.rem = rem;
    }
    
}
