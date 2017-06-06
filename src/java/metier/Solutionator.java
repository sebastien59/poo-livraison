/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import data.Arc;
import data.Client;
import data.Depot;
import data.Matrice;
import data.Point;
import data.Solution;
import data.Tournee;
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


    public Solutionator() {
        
        DistanceTimesP = new Parser("C:/Users/Youssra/Documents/projet2017/projet2017/dima/DistanceTimesData.csv");
        FleetP = new Parser("C:/Users/Youssra/Documents/projet2017/projet2017/large_all_with_trailer/Fleet.csv");
        LocationsP = new Parser("C:/Users/Youssra/Documents/projet2017/projet2017/large_all_with_trailer/Locations.csv");
        SwapActionsP = new Parser("C:/Users/Youssra/Documents/projet2017/projet2017/large_all_with_trailer/SwapActions.csv");
    }
    
    public void triviale() throws IOException{

        DistanceTimesP.read();
        FleetP.read();
        LocationsP.read();
        SwapActionsP.read();
        
        M= DistanceTimesP.makeMatrice();
        Depot D = LocationsP.getDepot();
        clients = LocationsP.getClients();
        
        Calculatron2000.calculateCostMatrix(M);
        Solution S = new Solution();
        Tournee T1 = new Tournee();
        
        for(Client c: clients){
        Arc a1 = new Arc(D,c);
        Arc a2 = new Arc(c,D);
        T1.addArc(a1);
        T1.addArc(a2);
        S.addTournee(T1);
        }
        
        cout = S.getCoutTotal();
        System.out.println("Cout total :" + cout);
    }
    
    public static void main(String[] args) throws IOException {
       Solutionator S = new Solutionator();
       S.triviale();
       
    }
 
}
