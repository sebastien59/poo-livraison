package data;


import java.util.ArrayList;
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastien
 */
public class Solution {
    
    private int idSolution;
    private Collection<Tournee> tournees;
    private static int lastId;
    private double coutTotal;

    public Solution(int idSolution, Collection<Tournee> tournees) {
        this.idSolution = idSolution;
        this.tournees = tournees;
    }
    
    public Solution(int idSolution) {
        this(idSolution, null);
    }
    
    public Solution() {
        this(Solution.lastId++);
    }

    public int getIdSolution() {
        return idSolution;
    }

    public void setIdSolution(int idSolution) {
        this.idSolution = idSolution;
    }

    public Collection<Tournee> getTournees() {
        return tournees;
    }

    public void setTournees(Collection<Tournee> tournees) {
        this.tournees = tournees;
    }
    
    public void addTournee(Tournee t) {
        if (this.tournees == null) {
            this.tournees = new ArrayList<Tournee>();
        }
        this.tournees.add(t);
        this.coutTotal+= t.getCoutTotal();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.idSolution;
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
        final Solution other = (Solution) obj;
        if (this.idSolution != other.idSolution) {
            return false;
        }
        return true;
    }

    public double getCoutTotal() {
        return coutTotal;
    }
    
   
    @Override
    public String toString() {
        String str = "";
        
        for(Tournee t : tournees){
            ArrayList<Arc> arcs = (ArrayList)t.getArcs();
            Depot D = (Depot) arcs.get(0).getP1();
            for(Arc a : arcs){

                str += "R"+t.getIdTournee()+";";
                str +=  arcs.indexOf(a)+";";  
                str += a.getP1().getNom()+";";
                str += a.getP1().getType()+";";
                if(a.getP1() instanceof Client){
                    Client c = (Client) a.getP1();
                    str += c.isDeliverableByTrain();
                }else{
                    str += "0;";
                }
                str += "\n";
            }
            str += "R"+t.getIdTournee()+";";
            str += arcs.size()+";";
            str += D.getNom()+";";
            str += D.getType()+";";
            str += "0;";
            str += "\n";
        }
        return str;
    }

}