/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastien
 */
public class Camion extends Vehicule{
    
    private int idCamion;
    private String nom; //pas obligatoire

    public Camion(int idCamion, String nom, int idVehicule, Swapbody chargement, float coutFixe, float coefTemps, float coefDistance) {
        super(idVehicule, chargement, coutFixe, coefTemps, coefDistance);
        this.idCamion = idCamion;
        this.nom = nom;
    }

    public int getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idCamion;
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
        final Camion other = (Camion) obj;
        if (this.idCamion != other.idCamion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Camion{" + "idCamion=" + idCamion + ", nom=" + nom + '}';
    }

    
    
}
