package data;


import java.util.ArrayList;
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastien
 */
public class Tournee {
    
    private int idTournee;
    private Vehicule vehicule;
    private Collection<Arc> arcs;
    private double coutTotal;
    private float tempsTotal;
    private static int lastID = 0;

    public Tournee(int idTournee, Vehicule vehicule, Collection<Arc> arcs, float coutTotal, float tempsTotal) {
        this.idTournee = idTournee;
        this.vehicule = vehicule;
        this.arcs = arcs;
        this.coutTotal = coutTotal;
        this.tempsTotal = tempsTotal;
    }
    
    public Tournee(int idTournee) {
        this(idTournee, null, null, 0, 0);
    }
    
    public Tournee() {
        this(Tournee.lastID++);
    }

    public int getIdTournee() {
        return idTournee;
    }

    public void setIdTournee(int idTournee) {
        this.idTournee = idTournee;
    }
    
    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public ArrayList<Arc> getArcs() {
        return (ArrayList<Arc>) arcs;
    }

    public void setArcs(Collection<Arc> arcs) {
        this.arcs = arcs;
    }
    
    public void addArc(Arc a) {
        if (this.arcs == null) {
            this.arcs = new ArrayList<Arc>();
        }
        a.setTournee(this);
        this.arcs.add(a);
        this.coutTotal+= a.getCost();
    }

    public double getCoutTotal() {
        return coutTotal;
    }

    public void setCoutTotal(double coutTotal) {
        this.coutTotal = coutTotal;
    }

    public float getTempsTotal() {
        return tempsTotal;
    }

    public void setTempsTotal(float tempsTotal) {
        this.tempsTotal = tempsTotal;
    }
    
    public Collection<Point> getPoints() {
        Collection<Point> points = new ArrayList<>();
        for (Arc a : this.arcs) {
            points.add(a.getP1());
        }
        return points;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idTournee;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tournee other = (Tournee) obj;
        if (this.idTournee != other.idTournee) {
            return false;
        }
        return true;
    }
    
    public Arc getRetour() {
        return (Arc) this.arcs.toArray()[this.arcs.size() - 1];
    }

    @Override
    public String toString() {
        return "Tournee{" + "idTournee=" + idTournee + ", vehicule=" + vehicule + ", points=" + arcs + ", coutTotal=" + coutTotal + ", tempsTotal=" + tempsTotal + '}';
    }
    
    
}
