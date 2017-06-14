/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "POINT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Point.findAll", query = "SELECT p FROM Point p"),
    @NamedQuery(name = "Point.findByIdpoint", query = "SELECT p FROM Point p WHERE p.idpoint = :idpoint"),
    @NamedQuery(name = "Point.findByNom", query = "SELECT p FROM Point p WHERE p.nom = :nom"),
    @NamedQuery(name = "Point.findByX", query = "SELECT p FROM Point p WHERE p.x = :x"),
    @NamedQuery(name = "Point.findByY", query = "SELECT p FROM Point p WHERE p.y = :y")})
public class Point extends Point2D.Double implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "X")
    private java.lang.Double x;
    @Column(name = "Y")
    private java.lang.Double y;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "npoint")
    private Collection<Swaplocation> swaplocationCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPOINT")
    private Integer idpoint;
    @Size(max = 45)
    @Column(name = "NOM")
    private String nom;
    @ManyToMany(mappedBy = "pointCollection")
    private Collection<Arc> arcCollection;

    public Point() {
    }

     public Point(int id, String nom, double x, double y) {
        this.idpoint = id;
        this.nom = nom;
        this.x = x;
        this.y = y;
    }
    public Integer getIdpoint() {
        return idpoint;
    }

    public void setIdpoint(Integer idpoint) {
        this.idpoint = idpoint;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @XmlTransient
    public Collection<Arc> getArcCollection() {
        return arcCollection;
    }

    public void setArcCollection(Collection<Arc> arcCollection) {
        this.arcCollection = arcCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpoint != null ? idpoint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Point)) {
            return false;
        }
        Point other = (Point) object;
        if ((this.idpoint == null && other.idpoint != null) || (this.idpoint != null && !this.idpoint.equals(other.idpoint))) {
            return false;
        }
        return true;
    }
    
     public Point getClosest(Collection<Point> points) {
        //double dist = java.lang.Double.MAX_VALUE;
        double dist = 0;
        double tmpD = 0;
        Point tmpPt;
        Point closest = null;
        for (int i=0; i < points.size()-1; i++) {
            if (dist > (tmpD = this.distance(tmpPt = (Point) points.toArray()[i]))) {
                dist = tmpD;
                closest = tmpPt;
            }
        }
        return closest;
    }

    @Override
    public String toString() {
        return "models.Point[ idpoint=" + idpoint + " ]";
    }

    public double getX() {
        return x;
    }

    public void setX(java.lang.Double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(java.lang.Double y) {
        this.y = y;
    }

    @XmlTransient
    public Collection<Swaplocation> getSwaplocationCollection() {
        return swaplocationCollection;
    }

    public void setSwaplocationCollection(Collection<Swaplocation> swaplocationCollection) {
        this.swaplocationCollection = swaplocationCollection;
    }
    
}
