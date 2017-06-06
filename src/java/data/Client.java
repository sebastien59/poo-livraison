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
public class Client extends Point {
    
    private int idClient;
    private String nomClient;
    private float tempsService;
    private float quantiteCommandee;
    private boolean remorque;

    public Client(int idClient, String nomClient, float tempsService, float quantiteCommandee, int id, String nom, float x, float y, boolean rem) {
        super(id, nom, x, y);
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.tempsService = tempsService;
        this.quantiteCommandee = quantiteCommandee;
        this.remorque = rem;
    }
    
     public Client(int idClient, String nomClient, float tempsService, float quantiteCommandee, int id, String nom, float x, float y) {
         this(idClient, nomClient, tempsService, quantiteCommandee, id, nom, x, y, false);
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
    
    public boolean isDeliverableByTrain() {
        return this.remorque;
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", nomClient=" + nomClient + ", tempsService=" + tempsService + ", quantiteCommandee=" + quantiteCommandee + '}';
    }

    
    
}
