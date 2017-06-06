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
    
    Client c1;
    Client c2;
    Depot D;
    Tournee T1;
    Tournee T2;
    Tournee T3;
    Tournee T4;
    Arc a;
    

    
    

    public Solutionator() {

    }
    public static void main(String[] args) throws IOException {
        Double cout;
        Matrice M;
        List<Client> clients;
        
        Parser P = new Parser("C:/Users/Youssra/Documents/projet2017/projet2017/dima/DistanceTimesData.csv");
        Parser P1 = new Parser("C:/Users/Youssra/Documents/projet2017/projet2017/large_all_with_trailer/Fleet.csv");
        Parser P2 = new Parser("C:/Users/Youssra/Documents/projet2017/projet2017/large_all_with_trailer/Locations.csv");
        Parser P3 = new Parser("C:/Users/Youssra/Documents/projet2017/projet2017/large_all_with_trailer/SwapActions.csv");

        P.read();
        P1.read();
        P2.read();
        P3.read();
        
        M= P.makeMatrice();
        Depot D = P2.getDepot();
        clients = P2.getClients();
        
        Calculatron2000.calculateCostMatrix(M);
        Solution S = new Solution();
        Tournee T1 = new Tournee();
        Tournee T2 = new Tournee();
        Tournee T3 = new Tournee();
        Tournee T4 = new Tournee();
        
        /*Client c1 = new Client(1,"Client",2.000, 40,3, "client",0.678, 0.8889,false);
        Client c2 = new Client(2,"Client2",2.000, 40,3, "client2",0.99, 0.444,false);
        Depot D = new Depot("D1","Depot de Youss",1,"Nom", 0.444,0.5555);*/
        
        
        Arc a1 = new Arc(D,clients.get(1));
        Arc a2 = new Arc(clients.get(1),D);
        T1.addArc(a1);
        T1.addArc(a2);
        S.addTournee(T1);
        cout = S.getCoutTotal();
        System.out.println("Cout total :" + cout);  
        
    }
 
}
