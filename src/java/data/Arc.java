/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import metier.Calculatron2000;

/**
 *
 * @author Loïc
 */
public class Arc {
    private Point p1;
    private Point p2;
    private double cost;  
    private Tournee t;
    private boolean rem;

    public Arc(Point p1, Point p2, int nbRem) {
        this.p1 = p1;
        this.p2 = p2;
        this.rem = (nbRem == 1);
        this.cost = Calculatron2000.getCostMatrixValue(p1, p2, nbRem);
    }
    
    
    public Arc(Point p1, Client p2) {
        this(p1, p2, (p2.getQuantiteCommandee() >= Constante.TRUCK_CAPACITY ? 1 : 0));
        p2.setArc(this);
    }
    public Arc(Client p1, Point p2) {
        this(p1, p2, (p1.getQuantiteCommandee() >= Constante.TRUCK_CAPACITY ? 1 : 0));
        p1.setArc(this);
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public boolean isRem() {
        return rem;
    }

    public void setRem(boolean rem) {
        this.rem = rem;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public Tournee getTournee() {
        return this.t;
    }
    
    public void setTournee(Tournee t) {
        this.t = t;
    }
   
    @Override
    public String toString() {
        return "Arc{" + "p1=" + p1 + ", p2=" + p2 + ", cost=" + cost + '}';
    }
    
    
}
