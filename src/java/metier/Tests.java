/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;
import data.*;
/**
 *
 * @author Loïc
 */
public class Tests {
    public static void main(String[] args) {
        Parser pfleet = new Parser("C:\\Users\\Loïc\\Desktop\\Travail IG2I\\POO\\Projet\\FichiersSources\\Fleet.csv");
        Parser ploca = new Parser("C:\\Users\\Loïc\\Desktop\\Travail IG2I\\POO\\Projet\\FichiersSources\\Locations.csv");
        Parser pswap = new Parser("C:\\Users\\Loïc\\Desktop\\Travail IG2I\\POO\\Projet\\FichiersSources\\SwapActions.csv");
        Matrice M = new Matrice(4, 8);
        Matrice MC;
        Matrice MCR;
        try {
            pfleet.read();
            ploca.read();
            pswap.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        M.setContent(1, 1, 0);
        M.setContent(1, 2, 0);
        M.setContent(1, 3, 2);
        M.setContent(1, 4, 1);
        M.setContent(1, 5, 3);
        M.setContent(1, 6, 1);
        M.setContent(1, 7, 3);
        M.setContent(1, 8, 2);
        M.setContent(2, 2, 1);
        M.setContent(2, 1, 2);
        M.setContent(2, 3, 0);
        M.setContent(2, 4, 0);
        M.setContent(2, 5, 3);
        M.setContent(2, 6, 4);
        M.setContent(2, 7, 3);
        M.setContent(2, 8, 4);
        M.setContent(3, 1, 1);
        M.setContent(3, 3, 3);
        M.setContent(3, 2, 2);
        M.setContent(3, 4, 4);
        M.setContent(3, 5, 0);
        M.setContent(3, 6, 0);
        M.setContent(3, 7, 5);
        M.setContent(3, 8, 3);
        M.setContent(4, 1, 1);
        M.setContent(4, 4, 2);
        M.setContent(4, 3, 2);
        M.setContent(4, 2, 3);
        M.setContent(4, 5, 5);
        M.setContent(4, 6, 4);
        M.setContent(4, 7, 0);
        M.setContent(4, 8, 0);
        /*MC = Calculatron2000.CostMatrix(M);
        MCR = Calculatron2000.CostMatrix(M, 1);
        System.out.println("Matrice de test :");
        System.out.println(M);
        System.out.println("Matrice de coûts normaux :");
        System.out.println(MC);
        System.out.println("Matrice de coûts camion :");
        System.out.println(MCR);*/
        Calculatron2000.calculateCostMatrix(M);
        System.out.println("Matrice de test :");
        System.out.println(M);
        System.out.println("Matrice de coûts normaux :");
        System.out.println();
        System.out.println("Matrice de coûts camion :");
        System.out.println();
        
    }
}
