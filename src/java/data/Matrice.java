package data;


import java.util.Arrays;
import java.util.stream.DoubleStream;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Loïc
 */
public class Matrice {
    private int x;
    private int y;
    private double[][] content;
    
    public Matrice(int x, int y) {
        if (x == 0) {
            x = 1;
        }
        if (y == 0) {
            y = 1;
        }
        this.x = x;
        this.y = y;
        this.content = new double[x][y];
    }
    
    public Matrice(int x) {
        this(x, x);
    }
    
    public double[] getRow(int x) {
        double[] result = new double[this.y];
        x--;
        System.arraycopy(this.content[x], 0, result, 0, this.y);
        return result;
    }
    
    public double[] getColumn(int y) {
        double[] result = new double[this.x];
        y--;
        for (int i = 0; i < this.x; i++) {
            result[i] = this.content[i][y];
        }
        return result;
    }
    
    public double getRowSum(int x) {
        return Math.round(DoubleStream.of(this.getRow(x)).sum() * 100.0) / 100.0;
    }
    
    public double getColSum(int y) {
        return Math.round(DoubleStream.of(this.getColumn(y)).sum() * 100.0) / 100.0;
    }
    
    public double getMatSum() {
        double sum = 0;
        for (double[] x : this.content) {
            for (double y : x) {
                sum = Math.round((sum + y) * 100.0) / 100.0;
            }
        }
        return sum;
    }
    
    public double getCell(int x, int y) {
        return content[x-1][y-1];
    }

    public int getX() {
        return (x);
    }

    public int getY() {
        return (y);
    }
    
    public boolean setContent(int x, int y, double val) {
        if ((x > this.x) || (y > this.y)) {
            return false;
        }
        this.content[x-1][y-1] = val;
        return true;
    }
    
    public boolean setContent(int x, double val) {
        return this.setContent(x, x, val);
    }
    
    public boolean setContent(double[] subarr, int it, char mode) {
        it--;
        if ((subarr == null) || (subarr.length == 0)) {
            return false;
        }
        if (mode == 'c') {
            if (!((subarr.length != this.x) || (it >= this.y))) {
                for (int i = 0; i < this.x; i++) {
                    this.content[i][it] = subarr[i];
                }
            } else {
                return false;
            }
        } else if (mode == 'r') {
            if (!((subarr.length != this.y) || (it >= this.x))) {
                System.arraycopy(subarr, 0, this.content[it], 0, this.y);
            } else {
                return false;
            }
        }
        return true;
    }
    
    
    public boolean setContent(double[][] arr) {
        if ((arr == null) || (arr.length == 0)) {
            return false;
        }
        
        if ((arr.length != this.x) || (arr[0].length != this.y)) {
            return false;
        }
        
        this.content = arr;
        
        return true;
    }
    
    public double[][] getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        String str = "";
        str+= "Matrice (" + (x) + "," + (y) +") :\n";
        str+= "[\n";
        for (double[] x : this.content) {
            for (double y : x) {
                str+= "\t" + y;
            }
            str+= "\n";
        }
        str+= "]";
        return str;
    }
    

    /*
    EXEMPLES : 
    public static void main(String[] args) {
        Matrice test = new Matrice(2, 3);
        Matrice colTest = new Matrice(2, 1);
        Matrice rowTest = new Matrice(1, 3);
        Matrice test2 = new Matrice (2, 3);
        
        // On remplit la matrice test.
        test.setContent(1, 5.2);
        test.setContent(1, 2, 4);
        test.setContent(1, 3, 18.9);
        test.setContent(2, 1, -4);
        test.setContent(2, 1.6);
        test.setContent(2, 3, 4.8);
        
        // On remplit la matrice colTest avec la 2ème colonne de la matrice test
        colTest.setContent(test.getColumn(2), 1, 'c');
        // On remplit la matrice rowTest avec la 1ère ligne de la matrice test
        rowTest.setContent(test.getRow(1), 1, 'r');
        
        // On remplit la matrice test2 avec la matricte test.
        test2.setContent(test.getContent());
        
        System.out.println("Matrice test :");
        System.out.println(test);
        System.out.println("Matrice colTest (2nd column of test) :");
        System.out.println(colTest);
        System.out.println("Matrice rowTest (1st row of test) :");
        System.out.println(rowTest);
        System.out.println("Matrice test2 :");
        System.out.println(test2);
        
        System.out.println("\nSums");
        System.out.println("Sums of test :");
        System.out.println(test);
        System.out.println("Sum 1st Row");
        // On calcule la somme de toutes les valeurs présentes sur la 1ère ligne de test
        System.out.println(test.getRowSum(1));
        System.out.println("Sum 2nd Col");
        // On calcule la somme de toutes les valeurs présentes sur la 2ème colonne de test
        System.out.println(test.getColSum(2));
        System.out.println("Total Sum");
        // On calcule la somme de toutes les valeurs de la matrice
        System.out.println(test.getMatSum());
    }
    */
}
