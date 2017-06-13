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
public final class Optimizer {
    private static Solution sol;
    
    private static Solution getOptimizedSolution(double delta, Collection<Point> points, Point depot) {
        double profit = 0;
        Arc retour;
        Client toAdd;
        double tmpCost = 0;
        Tournee tmpT;
        Collection<Point> tmpPts;
        for (Tournee t : sol.getTournees()) {
            tmpPts = points;
            tmpPts.removeAll(t.getPoints());
            retour = t.getRetour();
            toAdd = (Client) retour.getP1().getClosest(tmpPts);
            // Insérer test de faisabilité d'insertion de toAdd dans t (genre check capacité, temps, etc...)
            tmpCost = t.getCoutTotal();
            tmpCost-= retour.getCost();
            tmpCost+= Calculatron2000.getCostMatrixValue(retour.getP1(), toAdd);
            tmpCost+= Calculatron2000.getCostMatrixValue(toAdd, depot);
            if ((profit+= ((t.getCoutTotal() + toAdd.getArc().getTournee().getCoutTotal()) - tmpCost)) > 0) {
                t.getArcs().remove(retour);
                t.setCoutTotal(t.getCoutTotal() - retour.getCost());
                t.addArc(new Arc(retour.getP1(), toAdd));
                t.addArc(new Arc(toAdd, depot));
                sol.getTournees().remove(toAdd.getArc().getTournee());
                // remove arc retour from t
                // add arc retour.p1 => toAdd to t
                // add arc toAdd => depot to t
                // remove toAdd.arc.tournee from sol
                // calculate profit
                // if profit >= delta, repeat.
            }
        }
        if (profit >= delta) {
            return getOptimizedSolution(delta, points, depot);
        }
        return sol;
    }
    
    private static Solution getOptimizedSolution(Collection<Point> points, Point depot) {
        return getOptimizedSolution(1, points, depot);
    }
    
    private Optimizer(Point Depart){
        Point p = PointPlusProche(Depart);

        if(Depart instanceof Depot){
            
            /*switch (p.getTypeP()){
                case "T":
                    TtmtCamion(p);
                    break;
                case "Tc":
                    TtmtTrain(p);
                    break;
                case "C":
                    TtmtTrainCamion(p);
                    break;
                default : 
                    System.err.println("Undefined type");
                    break;
            }*/
        }
        
    }
       
    public void TtmtCamion(Point P1 ){
        Point P2 = PointPlusProche(P1);
        
        //int CoutP1 = P1.getT().getCout();
        //int CoutP2 = P2.getT().getCout();
        /*int CoutTotale = P1.getT().add(Point(P2).getCout);
        
        if(P1+P2 < CoutTotale){
            sol.add(Point(P2).getT());
        }
        //Supprime p pour la liste de point de tournée de la solution 
            P1.get
        */
    }
    
    private void TtmtTrain(Point p){    
        System.err.println("TtmtTrain");
    }
    
    private void TtmtTrainCamion(Point p){    
        System.err.println("TtmtTrainCamion");
    }
    
    private Point PointPlusProche(Point D) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
