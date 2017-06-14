/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import data.Arc;
import data.Camion;
import data.Client;
import data.Depot;
import data.Matrice;
import data.Point;
import data.Solution;
import data.Tournee;
import data.Train;
import data.Vehicule;
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

    public Solutionator() {
        String size = "small";
        DistanceTimesP = new Parser("C:\\Users\\Youssra\\Desktop\\projet2017\\dima\\DistanceTimesData.csv");
        FleetP = new Parser("C:\\Users\\Youssra\\Desktop\\projet2017\\"+size+"_normal/Fleet.csv");
        LocationsP = new Parser("C:\\Users\\Youssra\\Desktop\\projet2017\\"+size+"_normal/Locations.csv");
        SwapActionsP = new Parser("C:\\Users\\Youssra\\Desktop\\projet2017\\"+size+"_normal/SwapActions.csv");
        S= new Solution();
    }
    
    public String triviale() throws IOException{

        DistanceTimesP.read();
        FleetP.read();
        LocationsP.read();
        SwapActionsP.read();
        
        M = DistanceTimesP.makeMatrice();
        Depot D = LocationsP.getDepot();
        clients = LocationsP.getClients();
        
        Calculatron2000.calculateCostMatrix(M);
        Tournee T;
        Vehicule v;

        for(Client c: clients){
            String type = c.getTypeP();
            switch(type){
            case "C" :
                v = new Camion();

            case "Tc" :
                v = new Camion();

            case "T" :
                v = new Train();
            default:
                v = new Camion();
            }
            Arc a1 = new Arc(D,c,v);
            Arc a2 = new Arc(c,D,v);
            
            T = new Tournee();
            
            T.addArc(a1);
            T.addArc(a2);
            S.addTournee(T);
        }

       
        cout = S.getCoutTotal();
        System.out.println("Cout total : " + cout);
        System.out.println("\n -------------------- SOLUTION ---------------- \n");
        return S.toString();
    }
    
    public static void CreerSortie(String file) throws IOException{
        Solutionator S = new Solutionator();
        String solutionStr = S.triviale();
       
        System.out.println(solutionStr);
        
        File f = new File(file + "_triviale");
        f.delete();
        
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(solutionStr);
        fileWriter.close(); 
        
        f = new File(file + "_opti");
        f.delete();
        
        fileWriter = new FileWriter(file,true);
        fileWriter.write(solutionStr);
        fileWriter.close(); 
        
    }   
    
    public static void main(String[] args) throws IOException {
        Solutionator.CreerSortie("Solution.csv");
    }
}