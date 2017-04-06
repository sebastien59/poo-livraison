package data;


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
    private Collection<Point> points;
    private float coutTotal;
    private float tempsTotal;

    public Tournee(int idTournee, Vehicule vehicule, Collection<Point> points, float coutTotal, float tempsTotal) {
        this.idTournee = idTournee;
        this.vehicule = vehicule;
        this.points = points;
        this.coutTotal = coutTotal;
        this.tempsTotal = tempsTotal;
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

    public Collection<Point> getPoints() {
        return points;
    }

    public void setPoints(Collection<Point> points) {
        this.points = points;
    }

    public float getCoutTotal() {
        return coutTotal;
    }

    public void setCoutTotal(float coutTotal) {
        this.coutTotal = coutTotal;
    }

    public float getTempsTotal() {
        return tempsTotal;
    }

    public void setTempsTotal(float tempsTotal) {
        this.tempsTotal = tempsTotal;
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

    @Override
    public String toString() {
        return "Tournee{" + "idTournee=" + idTournee + ", vehicule=" + vehicule + ", points=" + points + ", coutTotal=" + coutTotal + ", tempsTotal=" + tempsTotal + '}';
    }
    
    
}
