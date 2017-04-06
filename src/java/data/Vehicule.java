package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastien
 */
public abstract class Vehicule {
    
    private int idVehicule;
    private Swapbody chargement;
    private float coutFixe;
    private float coefTemps;
    private float coefDistance;

    public Vehicule(int idVehicule, Swapbody chargement, float coutFixe, float coefTemps, float coefDistance) {
        this.idVehicule = idVehicule;
        this.chargement = chargement;
        this.coutFixe = coutFixe;
        this.coefTemps = coefTemps;
        this.coefDistance = coefDistance;
    }

    public int getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(int idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Swapbody getChargement() {
        return chargement;
    }

    public void setChargement(Swapbody chargement) {
        this.chargement = chargement;
    }

    public float getCoutFixe() {
        return coutFixe;
    }

    public void setCoutFixe(float coutFixe) {
        this.coutFixe = coutFixe;
    }

    public float getCoefTemps() {
        return coefTemps;
    }

    public void setCoefTemps(float coefTemps) {
        this.coefTemps = coefTemps;
    }

    public float getCoefDistance() {
        return coefDistance;
    }

    public void setCoefDistance(float coefDistance) {
        this.coefDistance = coefDistance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idVehicule;
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
        final Vehicule other = (Vehicule) obj;
        if (this.idVehicule != other.idVehicule) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "idVehicule=" + idVehicule + ", chargement=" + chargement + ", coutFixe=" + coutFixe + ", coefTemps=" + coefTemps + ", coefDistance=" + coefDistance + '}';
    }
    
    
    
    
    
    
    
}
