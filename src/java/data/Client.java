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
public abstract class Client extends Point {
    
    private int idClient;
    private String nomClient;
    private float tempsService;
    private float quantiteCommandee;

    public Client(int idClient, String nomClient, float tempsService, float quantiteCommandee, int id, String nom, float x, float y) {
        super(id, nom, x, y);
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.tempsService = tempsService;
        this.quantiteCommandee = quantiteCommandee;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public float getTempsService() {
        return tempsService;
    }

    public void setTempsService(float tempsService) {
        this.tempsService = tempsService;
    }

    public float getQuantiteCommandee() {
        return quantiteCommandee;
    }

    public void setQuantiteCommandee(float quantiteCommandee) {
        this.quantiteCommandee = quantiteCommandee;
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", nomClient=" + nomClient + ", tempsService=" + tempsService + ", quantiteCommandee=" + quantiteCommandee + '}';
    }

    
    
}
