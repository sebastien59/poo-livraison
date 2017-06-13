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
    private double tempsService;
    private double quantiteCommandee;
    private boolean remorque;
    private Arc a;
    private Tournee T;

    public Client(int idClient, String nomClient, double tempsService, double quantiteCommandee, int id, String nom, double x, double y, boolean rem) {
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

    public double getTempsService() {
        return tempsService;
    }

    public void setTempsService(float tempsService) {
        this.tempsService = tempsService;
    }

    public double getQuantiteCommandee() {
        return quantiteCommandee;
    }

    public void setQuantiteCommandee(float quantiteCommandee) {
        this.quantiteCommandee = quantiteCommandee;
    }
    
    public boolean isDeliverableByTrain() {
        return this.remorque;
    }
    
    public void setArc(Arc a) {
        this.a = a;
    }
    
    public Arc getArc() {
        return this.a;
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", nomClient=" + nomClient + ", tempsService=" + tempsService + ", quantiteCommandee=" + quantiteCommandee + ", remorque=" + remorque + '}';
    }

    
    public void setTournee(Tournee T) {
        this.T = T;
    }
    // A GERER
    // Retourner la tournée à laquelle le point est affecté
    public Tournee getTournee() {
        return this.T;
    }
}
