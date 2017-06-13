/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;
import data.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
/**
 *
 * @author Loïc
 */
public final class Optimizer {
    private static Solution sol;
    private static Collection<Point> listeNonTraites;
    
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
    
    
    // Fonction à bouger d'ici
    // Critères :
    // T - enlève les trains
    // tc - enlève les trains-camions
    // C - enlève les camions
    // L - enlève les swapLoca
    // D - enlève les dépôts
    // Q - check contrainte quantité
    // H - check contraine temps
    public Collection<Point> filtrer(Point origin, Collection<Point> lp, String criteria, double q, double t) {
        if ("".equals(criteria)) return lp;
        Predicate<Point> predi = null;
        Predicate<Point> prediTemp = null;
        
        if (criteria.contains("T")) {
            prediTemp = (Point p) -> {
                return (p.getType().equals("CUSTOMER") && ((Client) p).isDeliverableByTrain() && (((Client) p).getQuantiteCommandee() > Constante.SEMI_TRAILER_CAPACITY));
            };
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.and(prediTemp);
            }
        }
        if (criteria.contains("tc")) {
            prediTemp = (Point p) -> {
                return (p.getType().equals("CUSTOMER") && ((Client) p).isDeliverableByTrain() && (((Client) p).getQuantiteCommandee() <= Constante.SEMI_TRAILER_CAPACITY));
            };
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.and(prediTemp);
            }
        }
        if (criteria.contains("C")) {
            prediTemp = (Point p) -> {
                return (p.getType().equals("CUSTOMER") && !((Client) p).isDeliverableByTrain());
            };
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.and(prediTemp);
            }
        }
        if (criteria.contains("L")) {
            prediTemp = (Point p) -> {
                return (p.getType().equals("LOCATION"));
            };
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.and(prediTemp);
            }
        }
        if (criteria.contains("D")) {
            prediTemp = (Point p) -> {
                return (p.getType().equals("DEPOT"));
            };
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.and(prediTemp);
            }
        }
        if (criteria.contains("Q")) {
            prediTemp = (Point p) -> {
                return (p.getType().equals("CUSTOMER") && (((Client) p).getQuantiteCommandee() <= q));
            };
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.and(prediTemp);
            }
        }

        if (criteria.contains("H")) {
            prediTemp = (Point p) -> {
                return (new Arc(origin, p, 0).getTps() <= t);
            };
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.and(prediTemp);
            }
        }
        lp.removeIf(predi);
        return lp;
    }
    
    public Collection<Point> filtrer(Point origin, Collection<Point> lp, String criteria) {
        // TODO : Constante TMax à la place du "1" final
        return filtrer(origin, lp, criteria, Constante.SEMI_TRAILER_CAPACITY, 1);
    }
    
        
    public Point plusProcheVoisin(Point P) {
        Collection listePoint = listeNonTraites;
        Point retour;
        switch (P.getTypeP()) {
            case "T":
                listePoint = filtrer(P, listePoint, "DCL");
            case "C":
                listePoint = filtrer(P, listePoint, "DTL");
            case "SL":
                listePoint = filtrer(P, listePoint, "DTL");
                if (listePoint.isEmpty()) return new Depot();
            default:
                listePoint = filtrer(P, listePoint, "DL");
        }
        listePoint = filtrer(P, listePoint, "QH");
        if (listePoint.isEmpty()) {
            listePoint = listeNonTraites;
            switch (P.getTypeP()) {
                case "T":
                    listePoint = filtrer(P, listePoint, "DTCtcH");
                    if (listePoint.isEmpty()) return new Depot();
                case "C":
                    return new Depot();
                case "SL":
                    return new Depot();
                case "D":
                    return new Depot();
                case "Tc":
                    return new Depot();
            }
        }
        retour = P.getClosest(listePoint);
        if (retour instanceof Swaplocation) {
            if (plusProcheVoisin(retour) instanceof Depot) return new Depot();
        }
        
        return retour;
    }
    
}
