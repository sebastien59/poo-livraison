package data;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.lang.Double;
import java.util.ArrayList;
import java.util.function.Predicate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastien
 */
public abstract class Point extends Point2D.Double{
    
    private static int row = 1;
    private int id;
    private String nom;
    private String type;
    

    public Point(int id, String nom, double x, double y) {
        //this.id = id;
        this.id = row;
        row++;
        this.nom = nom;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public Point getClosest(Collection<Point> points) {
        //double dist = java.lang.Double.MAX_VALUE;
        double dist = 999999999;
        double tmpD = 0;
        Point tmpPt;
        Point closest = null;
        //System.out.println("Searching among : ");
        //System.out.println(points.toString());
        for (int i=0; i < points.size(); i++) {
            //System.out.println("Comparing " + dist);
            if (dist > (tmpD = this.distance(tmpPt = (Point) points.toArray()[i]))) {
                dist = tmpD;
                closest = tmpPt;
            }
        }
        //System.out.println("Return");
        //System.out.println("Using : " + closest.toString());
        return closest;
    }

    @Override
    public String toString() {
        return "Point{" + "id=" + id + ", nom=" + nom + "}";
    }

    public String getTypeP() {
        String c = this.getClass().toString();
        
        switch(c){
            case "class data.Client" :
                //System.out.println((((Client)this).isDeliverableByTrain() ? "TRAIN" : "CAMION") + ((Client)this).getQuantiteCommandee());
                if (((Client) this).isDeliverableByTrain() && ((Client) this).getQuantiteCommandee() >= Constante.SWAP_BODY_CAPACITY) {
                    return "T";
                } else if (((Client) this).isDeliverableByTrain()) {
                    return "Tc";
                } else {
                    return "C";
                }
            case "class data.Depot" :
                return "D";
            case "class data.Swaplocation" :
                return "SL";
            default:
                return "";    
        }
    }


   public String getType(){
        String c = this.getClass().toString();
        //System.out.println(c);
        switch(c){
            case "class data.Client" :
                   return "CUSTOMER";
            case "class data.Depot" :
                   return "DEPOT";
            case "class data.Swaplocation" :
                   return "LOCATION";
            default:
                return "";
        }
    }    
}
