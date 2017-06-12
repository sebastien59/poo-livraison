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
public class Depot extends Point{
    
    private String idDepot;
    private String nomDepot;

    
    public Depot(String idDepot, String nomDepot, int id, String nom, double x, double y) {
        super(id, nom, x, y);
        this.idDepot = idDepot;
        this.nomDepot = nomDepot;
    }
    
    public Depot() {
        this("", "", 0, "", 0, 0);
    }

    public String getIdDepot() {
        return idDepot;
    }

    public void setIdDepot(String idDepot) {
        this.idDepot = idDepot;
    }

    public String getNomDepot() {
        return nomDepot;
    }

    public void setNomDepot(String nomDepot) {
        this.nomDepot = nomDepot;
    }

    @Override
    public String toString() {
        return "Depot{" + "idDepot=" + idDepot + ", nomDepot=" + nomDepot + '}';
    }
}
