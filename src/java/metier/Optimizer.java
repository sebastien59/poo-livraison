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
public class Optimizer {
    private static Solution sol;
    private static Collection<Point> listeNonTraites;
    
    
    public void initList(Collection<Point> l) {
        Optimizer.listeNonTraites = l;
    }
    
    public Optimizer(Solution sol, Collection<Point> liste) {
        Optimizer.sol = sol;
        Optimizer.listeNonTraites = liste;
    }
    
    public Optimizer() {
        this(null, null);
    }
    
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
        //System.out.println("Filter on ");
        //System.out.println(lp);
        //System.out.println("Criteria = " + criteria);
        //System.out.println("Constraints : q " + q + " // t " + t);
        lp = new ArrayList<>(lp);
        lp.remove(origin);
        if ("".equals(criteria)) return lp;
        Predicate<Point> predi = null;
        Predicate<Point> prediTemp = null;
        
        if (criteria.contains("T")) {
            prediTemp = (Point p) -> {
                //return (p.getType().equals("CUSTOMER") && ((Client) p).isDeliverableByTrain() && (((Client) p).getQuantiteCommandee() > (Constante.SWAP_BODY_CAPACITY)));
                return (p.getTypeP().equals("T"));
            };
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.or(prediTemp);
            }
        }
        if (criteria.contains("tc")) {
            prediTemp = (Point p) -> {
                //return (p.getType().equals("CUSTOMER") && ((Client) p).isDeliverableByTrain() && (((Client) p).getQuantiteCommandee() <= (Constante.SWAP_BODY_CAPACITY)));
                return (p.getTypeP().equals("Tc"));
            };
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.or(prediTemp);
            }
        }
        if (criteria.contains("C")) {
            prediTemp = (Point p) -> {
                //return (p.getType().equals("CUSTOMER") && !((Client) p).isDeliverableByTrain());
                return (p.getTypeP().equals("C"));
            };
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.or(prediTemp);
            }
        }
        //if (criteria.contains("L")) {
            prediTemp = p -> (p.getType().equals("LOCATION"));
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.or(prediTemp);
            }
        //}
        if (criteria.contains("D")) {
            prediTemp = p -> (p.getType().equals("DEPOT"));
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.or(prediTemp);
            }
        }
        if (criteria.contains("Q")) {
            prediTemp = (Point p) -> {
                return (p.getType().equals("CUSTOMER") && (((Client) p).getQuantiteCommandee() > q));
            };
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.or(prediTemp);
            }
        }

        if (criteria.contains("H")) {
            prediTemp = (Point p) -> {
                return (new Arc(origin, p, 0, null, ((Client) origin).getQuantiteCommandee()).getTps() > t);
            };
            if (predi == null) {
                predi = prediTemp;
            } else {
                predi = predi.or(prediTemp);
            }
        }
        lp.removeIf(predi);
        //System.out.println("Remainings  : ");
        //System.out.println(lp.toString());
        return lp;
    }
    
    public Collection<Point> filtrer(Point origin, Collection<Point> lp, String criteria) {
        // TODO : Constante TMax à la place du "1" final
        return filtrer(origin, lp, criteria, Constante.SWAP_BODY_CAPACITY, Constante.SWAP_BODY_OPERATING_TIME );
    }
        
    public Point plusProcheVoisin(Point P) {
        //System.out.println("------------------Searching 1nn------------------");
        Collection listePoint = new ArrayList<>(listeNonTraites);
        Point retour = new Depot();
        switch (P.getTypeP()) {
            case "T":
                listePoint = filtrer(P, listePoint, "DCLQH", Constante.SWAP_BODY_CAPACITY * 2 - ((Client)P).getTournee().getQuantiteTotal(), Constante.SWAP_BODY_OPERATING_TIME  - ((Client)P).getTournee().getTempsTotal());
                break;
            case "C":
                listePoint = filtrer(P, listePoint, "DTLQH", Constante.SWAP_BODY_CAPACITY - ((Client)P).getTournee().getQuantiteTotal(), Constante.SWAP_BODY_OPERATING_TIME  - ((Client)P).getTournee().getTempsTotal());
                break;
            //case "SL":
            //    listePoint = filtrer(P, listePoint, "DTL");
             //   if (listePoint.isEmpty()) {System.out.println("Returning empty"); return new Depot();}
            //    break;
            case "Tc":
                if (((Client)P).getTournee().isTruck()) {
                    listePoint = filtrer(P, listePoint, "DTLQH", Constante.SWAP_BODY_CAPACITY * 2 - ((Client)P).getTournee().getQuantiteTotal(),Constante.SWAP_BODY_OPERATING_TIME - ((Client)P).getTournee().getTempsTotal());
                } else if (((Client)P).getTournee().isTrain()) {  
                    listePoint = filtrer(P, listePoint, "DCLQH", Constante.SWAP_BODY_CAPACITY * 2 - ((Client)P).getTournee().getQuantiteTotal(),Constante.SWAP_BODY_OPERATING_TIME  - ((Client)P).getTournee().getTempsTotal());
                } else {
                    listePoint = filtrer(P, listePoint, "DCLQH", Constante.SWAP_BODY_CAPACITY * 2 - ((Client)P).getTournee().getQuantiteTotal(),Constante.SWAP_BODY_OPERATING_TIME  - ((Client)P).getTournee().getTempsTotal());
                    if (listePoint.isEmpty()) {
                        listePoint = listeNonTraites;
                        listePoint = filtrer(P, listePoint, "DTLQH", Constante.SWAP_BODY_CAPACITY - ((Client)P).getTournee().getQuantiteTotal(),Constante.SWAP_BODY_OPERATING_TIME  - ((Client)P).getTournee().getTempsTotal());
                    }
                }
                break;
            default:
                listePoint = filtrer(P, listePoint, "DL");
                break;
        }
        //System.out.println("------------------First fliter------------------");
        //System.out.println(listePoint);
        //listePoint = filtrer(P, listePoint, "QH");
        if (listePoint.isEmpty()) {
            //switch (P.getTypeP()) {
            //    case "T":
            //        listePoint = listeNonTraites;
            //        listePoint = filtrer(P, listePoint, "DTCtcH", 0, 9999999);
            //        if (listePoint.isEmpty()) {/*System.out.println("Returning empty");*/ return new Depot();}
            //        break;
            //    case "C":
            //        /*System.out.println("Returning empty");*/ return new Depot();
            //    //case "SL":
            //    //    /*System.out.println("Returning empty");*/ return new Depot();
            //    case "D":
            //        /*System.out.println("Returning empty");*/ return new Depot();
            //    case "Tc":
            //        /*System.out.println("Returning empty");*/ return new Depot();
             //   default:
            //        /*System.out.println("Returning empty");*/ return new Depot();
            //}
            return new Depot();
        }
        retour = P.getClosest(listePoint);
        if (retour instanceof Swaplocation) {
            if (plusProcheVoisin(retour) instanceof Depot) /*System.out.println("Returning empty");*/ return new Depot();
        }
        //System.out.println(retour.toString());
        //System.out.println("Return point");
        return retour;
    }
    
    public void Optimiser(Point D){
        
        
        Point pointPlusProche = plusProcheVoisin(D);
        //System.out.println(pointPlusProche);
        //System.out.println(pointPlusProche.getTypeP());
        //System.out.println(pointPlusProche.getType());
        //System.out.println(pointPlusProche.getX());
        //System.out.println(pointPlusProche.getY());
        //System.out.println("\n\n\n");
        if(!(pointPlusProche instanceof Depot)){
            
            switch(pointPlusProche.getTypeP()){
                case "T" :
                    //System.out.println("T");
                    TtmtTrain(pointPlusProche); 
                    break;
                 
                case "Tc" :
                    //System.out.println("Tc");
                    TtmtTrainCamion(pointPlusProche); 
                    break;
                    
                case "C" :
                    //System.out.println("C");
                    TtmtCamion(pointPlusProche); 
                    break;
                default:
                    //System.out.println("C'EST LA M**** MEC");
                    break;
            }      
        }
        /*System.out.println("------------------------------------------------------------");
        System.out.println("Points restants dans la liste : \n");
        for (Point P : Optimizer.listeNonTraites) {
            System.out.println("\tPoint " + P.getNom());
        }*/
    }
    
    
    public void TtmtCamion(Point P1){
        if (((Client) P1).getTournee().isTrain()) return;
        //System.out.println("Traitement Camion...");
        Point P2 = plusProcheVoisin(P1);
        //System.out.println(P2.getClass());
        if(P2 instanceof Depot){
            //System.out.println("REMOVING " + P1.toString());
            listeNonTraites.remove(P1);
            return;
        } 
        //System.out.println("---------------------------------");
        //System.out.println("---------------------------------");
        //System.out.println("---------------------------------");
        //System.out.println("---------------------------------");
        //System.out.println(P2);
        //System.out.println(P2.getTypeP());
        //if(!"SL".equals(P2.getTypeP())){
            Tournee TourneeP1 = ((Client)P1).getTournee();
            Tournee TourneeP2 = ((Client)P2).getTournee();
            Tournee TourneeTotale = new Tournee(((Client)P1).getTournee()); // Simulation de la tournée P1 

            TourneeTotale.addPoint(P2 , 0); // on ajoute le point le plus proche  à la tournée de P1!

            if(TourneeTotale.getCoutTotal() < TourneeP1.getCoutTotal() + TourneeP2.getCoutTotal()){
                TourneeTotale.setTruck();
                sol.removeTournee(TourneeP2);
                sol.removeTournee(TourneeP1);
                sol.addTournee(TourneeTotale);
                ((Client) P1).setTournee(TourneeTotale);
                listeNonTraites.remove(P1);
                // RECUR001
                TtmtCamion(P2);
                
            }    
        //}
    }

    private void TtmtTrain(Point P1) {
        if (((Client) P1).getTournee().isTruck()) return;
        //System.out.println("Traitement Train...");
        Point P2 = plusProcheVoisin(P1);
        if(P2 instanceof Depot){
            //System.out.println("REMOVING " + P1.toString());
            listeNonTraites.remove(P1);
            return;
        } 
        //System.out.println("---------------------------------");
        //System.out.println("---------------------------------");
        //System.out.println("---------------------------------");
        //System.out.println("---------------------------------");
        //System.out.println(P2);
        //System.out.println(P2.getTypeP());
        //if(!"SL".equals(P2.getTypeP()) ){
            //System.out.println("Lier trains");
            Tournee TourneeP1 = ((Client)P1).getTournee();
            Tournee TourneeP2 = ((Client)P2).getTournee();
            Tournee TourneeTotale = new Tournee(((Client)P1).getTournee()); // Simulation de la tournée P1 
            //System.out.println(TourneeTotale.getCoutTotal() + " / " + TourneeP1.getCoutTotal());

            TourneeTotale.addPoint(P2 , 1); // on ajoute le point le plus proche  à la tournée de P1!
            
            //System.out.println("Comparing costs : " + TourneeTotale.getCoutTotal() + " vs " + (TourneeP1.getCoutTotal() + TourneeP2.getCoutTotal()));
            if(TourneeTotale.getCoutTotal() < (TourneeP1.getCoutTotal() + TourneeP2.getCoutTotal())){
                TourneeTotale.setTrain();
                //System.out.println("Changing Tournées");
                sol.removeTournee(TourneeP2); 
                sol.removeTournee(TourneeP1);
                sol.addTournee(TourneeTotale);
                ((Client) P1).setTournee(TourneeTotale);
                // RECUR001
                listeNonTraites.remove(P1);
                TtmtTrain(P2);
            }   
       // } else {
            //ajouter SL à la tournee
            //changer le type de tournee
            //relancer un optimiser(P2);
            //Optimiser(P1);
        //}
        //listeNonTraites.remove(P1);
       
    }
    
    private void TtmtTrainCamion(Point P1) {
        //System.out.println("Traitement Train/Camion...");
        
        if (((Client)P1).getTournee().isTrain()) {
            TtmtTrain(P1);
            return;
        }
        if (((Client)P1).getTournee().isTruck()) {
            TtmtCamion(P1);
            return;
        } 
        
        Point P2 = plusProcheVoisin(P1);
        if(P2 instanceof Depot){
            listeNonTraites.remove(P1);
            return;
        } 
        
        if(P2.getTypeP() == "C" ){
            TtmtCamion(P2);
        }else if(P2.getTypeP() == "T" ){
            TtmtTrain(P2);
        }else if(P2.getTypeP() == "Tc" ){
            
            Tournee TourneeP1 = ((Client)P1).getTournee();
            Tournee TourneeP2 = ((Client)P2).getTournee();
            Tournee TourneeTotale = new Tournee(((Client)P1).getTournee()); // Simulation de la tournée P1 
            
            
            if (TourneeTotale.getQuantiteTotal() > Constante.SWAP_BODY_CAPACITY) { //on change de type de véhicule
                TourneeTotale.changeVehicule(new Train());
                TourneeTotale.addPoint(P2, 1);
                TourneeTotale.setTrain();
            } else {
                TourneeTotale.addPoint(P2, 0);
                TourneeTotale.setTruck();
            }

            if(TourneeTotale.getCoutTotal() < TourneeP1.getCoutTotal() + TourneeP2.getCoutTotal()){

                sol.removeTournee(TourneeP2);
                sol.removeTournee(TourneeP1);
                sol.addTournee(TourneeTotale);
                ((Client) P1).setTournee(TourneeTotale);
                listeNonTraites.remove(P1);
                if (TourneeTotale.getQuantiteTotal() > Constante.SWAP_BODY_CAPACITY) {
                    TtmtTrain(P2);
                } else {
                    TtmtCamion(P2);
                }
            }
            //TourneeTotale.addPoint(P2, 0);
            //listeNonTraites.remove(P1);
            
        //}else if(P2.getTypeP() == "SL"){
            //TtmtSwapLocation(P2, P1);
        }
    }
    
    private void TtmtSwapLocation(Point ante, Point P1){
        
        
        //ajouter SL à la tournee
        //changer le type de vehicule sur les arcs
        //relancer un optimiser(P1);
        Tournee T = ((Client) ante).getTournee();
        
        Point P2 = plusProcheVoisin(P1);  
        if (P2 instanceof Depot) {
            return;
        }
        
        T.addSL(P1, P2);
        TtmtCamion(P2);
        T.addSL();
    }
    
    public Solution getSol() {
        return this.sol;
    }

    void OptimiserAll(Depot depot) {
        for (int i=0; i < Optimizer.listeNonTraites.size(); i++) {
            Optimiser(depot);
            if (sol.hasChanged()) {
                sol.restart();
                i = 0;
            }
        }
    }
    
}
