/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metierDao;

import dao.ArcDao;
import dao.CamionDao;
import dao.ClientDao;
import dao.DaoFactory;
import dao.DepotDao;
import dao.PersistenceType;
import static dao.PersistenceType.JPA;
import dao.SolutionDao;
import dao.TourneeDao;
import dao.TrainDao;
import metierDao.*;
import data.Matrice;
import models.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Youssra
 */
public class Solutionator {
    private Double cout;
    private Matrice M;
    private List<Client> clients;
    private Parser DistanceTimesP;
    private Parser FleetP;
    private Parser LocationsP;
    private Parser SwapActionsP;
    private Solution S;
    
    private DepotDao DepotManager;
    private ClientDao ClientManager;
    private CamionDao CamionManager;
    private TrainDao TrainManager;
    private ArcDao  ArcManager;
    private TourneeDao  TourneeManager;
    private SolutionDao SolutionManager;
    
    private PersistenceType type = JPA;
        
    public Solutionator() {
        String size = "small";
        DistanceTimesP = new Parser("/Users/sebastien/Documents/IG2I/Cours/L4/POO/projet/projet2017/dima/DistanceTimesData.csv");
        FleetP = new Parser("/Users/sebastien/Documents/IG2I/Cours/L4/POO/projet/projet2017/"+size+"_normal/Fleet.csv");
        LocationsP = new Parser("/Users/sebastien/Documents/IG2I/Cours/L4/POO/projet/projet2017/"+size+"_normal/Locations.csv");
        SwapActionsP = new Parser("/Users/sebastien/Documents/IG2I/Cours/L4/POO/projet/projet2017/"+size+"_normal/SwapActions.csv");
        S= new Solution();
        
        DepotManager = DaoFactory.getDaoFactory(type).getDepotDao();
        ClientManager = DaoFactory.getDaoFactory(type).getClientDao();
        CamionManager = DaoFactory.getDaoFactory(type).getCamionDao();
        ArcManager = DaoFactory.getDaoFactory(type).getArcDao();
        TourneeManager = DaoFactory.getDaoFactory(type).getTourneeDao();
        TrainManager = DaoFactory.getDaoFactory(type).getTrainDao();
        SolutionManager = DaoFactory.getDaoFactory(type).getSolutionDao();
    }
    
    public String triviale() throws IOException{

        DistanceTimesP.read();
        FleetP.read();
        LocationsP.read();
        SwapActionsP.read();
        
        M = DistanceTimesP.makeMatrice();
        Depot D = LocationsP.getDepot();
        
        DepotManager.create(D);
        
        clients = LocationsP.getClients();
        
        Calculatron2000.calculateCostMatrix(M);
        Tournee T;
        Vehicule v;

        for(Client c: clients){
//            ClientManager.create(c);
            String type = c.getTypeP();
            switch(type){
            case "C" :
                v = new Camion();
                CamionManager.create((Camion)v);
            case "Tc" :
                v = new Camion();
                CamionManager.create((Camion)v);
            case "T" :
                v = new Train();
                TrainManager.create((Train)v);
            default:
                v = new Camion();
                CamionManager.create((Camion)v);
            }
            Arc a1 = new Arc(D,c,v);
            Arc a2 = new Arc(c,D,v);
            
            T = new Tournee();
            
            T.addArc(a1);
            T.addArc(a2);
            
            /*ArcManager.create(a1); 
            ArcManager.create(a2);*/
            
          //  TourneeManager.create(T);
            S.addTournee(T);
        }

        System.out.println(S.getNtournee());
        SolutionManager.create(S);
        
        cout = S.getCoutTotal();
        
        System.out.println("Cout total : " + cout);
        System.out.println("\n -------------------- SOLUTION ---------------- \n");
        return S.toString();
    }
    
    public static void CreerSortie(String file) throws IOException{
        Solutionator S = new Solutionator();
        String solutionStr = S.triviale();
       
        System.out.println(solutionStr);
        
        File f = new File(file);
        f.delete();
        
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(solutionStr);
        fileWriter.close(); 
    }   
    
    public static void main(String[] args) throws IOException {
        Solutionator.CreerSortie("Solution.csv");
    }
}