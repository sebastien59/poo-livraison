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
public class Train extends Vehicule {
    
    private int idTrain;
    private Swapbody remorque;

    public Train(int idTrain, Swapbody remorque, int idVehicule, Swapbody chargement, float coutFixe, float coefTemps, float coefDistance) {
        super(idVehicule, chargement, coutFixe, coefTemps, coefDistance);
        this.idTrain = idTrain;
        this.remorque = remorque;
    }

    public int getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }

    public Swapbody getRemorque() {
        return remorque;
    }

    public void setRemorque(Swapbody remorque) {
        this.remorque = remorque;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idTrain;
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
        final Train other = (Train) obj;
        if (this.idTrain != other.idTrain) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Train{" + "idTrain=" + idTrain + ", remorque=" + remorque + '}';
    }

    
}
