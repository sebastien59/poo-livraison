/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;
import data.Constante;
import data.Matrice;
import data.Solution;
import data.Tournee;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author Loïc
 */
public class Calculatron2000 {
    
    //
    //
    //  GESTION DES COÛTS
    //
    //
    public static double getCost(double tempsTrajet, double distanceTrajet, int nbRem) {
        if (nbRem > 1) nbRem = 1;
        if (nbRem < 0) nbRem = 0;
        double cost = 0;
        cost = Constante.TRUCK_COST_USAGE + (Constante.SEMI_TRAILER_COST_USAGE * nbRem);
        cost+= (tempsTrajet * Constante.TRUCK_COST_H);
        cost+= (distanceTrajet * (Constante.TRUCK_COST_KM + (Constante.SEMI_TRAILER_COST_H * nbRem)));
        System.out.println("\t\tCoût : " + cost);
        return cost;
    }
    public static double getCost(double tempsTrajet, double distanceTrajet) {
        return getCost(tempsTrajet, distanceTrajet, 0);
    }
    
    public static Matrice CostMatrix(Matrice M, int nbRem) {
        System.out.println("Calculating cost for M :");
        System.out.println(M);
        Matrice MC = new Matrice(M.getX(), M.getY()/2);
        for (int i = 1; i <= M.getX(); i++) {
            System.out.println("Ligne " + i);
            for (int j = 1; j <= M.getY()/2; j++) {
                System.out.println("\tColonne " + j);
                if (i == j) {
                    MC.setContent(i, j, 0);
                    System.out.println("\t\t0");
                } else {
                    MC.setContent(i, j, getCost(M.getCell(i, j * 2), M.getCell(i, j + (j - 1)), nbRem));
                }
            }
        }
        return MC;
    }
    public static Matrice CostMatrix(Matrice M) {
        return CostMatrix(M, 0);
    }
    
    //
    //
    // GESTION DES TOURNÉES
    //
    //
    public static Solution initTournee(Matrice M) {
        Solution sol = new Solution(1);
        
        return sol;
    }
}
