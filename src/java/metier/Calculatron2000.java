/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;
import data.*;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author Loïc
 */
public class Calculatron2000 {
    private static Matrice costMatrix;
    private static Matrice costMatrixRem;
    
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
    
    public static void calculateCostMatrix(Matrice M) {
        Calculatron2000.costMatrix = Calculatron2000.costMatrix(M);
        Calculatron2000.costMatrixRem = costMatrix(M, 1);
    }
    
    public static Matrice getCostMatrix(int nbRem) {
        return (nbRem == 0 ? Calculatron2000.costMatrix : Calculatron2000.costMatrixRem);
    }
    
    public static Matrice getCostMatrix() {
        return Calculatron2000.getCostMatrix(0);
    }
    
    public static double getCostMatrixValue(int x, int y, int nbRem) {
        return (nbRem == 0 ? Calculatron2000.costMatrix.getCell(x, y) : Calculatron2000.costMatrixRem.getCell(x, y));
    }
    public static double getCostMatrixValue(int x, int y) {
        return getCostMatrixValue(x, y, 0);
    }
    public static double getCostMatrixValue(Point x, Point y, int nbRem) {
        return getCostMatrixValue(x.getId(), y.getId(), nbRem);
    }
    public static double getCostMatrixValue(Point x, Point y) {
        return getCostMatrixValue(x.getId(), y.getId(), 0);
    }
    
    public static Matrice costMatrix(Matrice M, int nbRem) {
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
    public static Matrice costMatrix(Matrice M) {
        return costMatrix(M, 0);
    }
    
    //
    //
    // GESTION DES TOURNÉES
    //
    //
    public static Solution initTournee(Matrice M) {
        //Point depot = new Depot(0, "Dépôt", 1, 1);
        Solution sol = new Solution(1);
        ArrayList<Tournee> tList = new ArrayList<Tournee>();
        Tournee t = new Tournee(1);
        int i;
        for (i = 1; i <= M.getY(); i++) {
            
        }
        return sol;
    }
}
