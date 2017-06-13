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
    
    public void removeTournee(Tournee t) {
        this.tournees.remove(t);
        this.coutTotal-= t.getCoutTotal();
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
        //Header du tableau
        String str = "TOUR_ID;TOUR_POSITION;LOCATION_ID;LOCATION_TYPE;SEMI_TRAILER_ATTACHED;SWAP_BODY_TRUCK;SWAP_BODY_SEMI_TRAILER;SWAP_ACTION;SWAP_BODY_1_QUANTITY;SWAP_BODY_2_QUANTITY\n";
        
        for(Tournee t : tournees){
            ArrayList<Arc> arcs = (ArrayList)t.getArcs();
            
            // Utilisation des valeurs maximal comme variable tampon pour le dernier point de la tournée (Dépot)
            Depot D = (Depot) arcs.get(0).getP1();
            for(Arc a : arcs){
                str += "R"+(t.getIdTournee()+1)+";"; // On indique le nom de la tournée
                str += (arcs.indexOf(a)+1)+";"; // On indique la position de la localisation dans tournée
                str += a.getP1().getNom()+";";
                str += a.getP1().getType()+";";
               
                // On check si on peut mettre une remorque
                
                str += t.getMax_semi_tr_at()+";";
                
                str += t.getMax_swap_body_tr()+";"; // SWAP BODY TRUCK 
                
                str += t.getMax_swap_body_sm()+";"; // SWAP BODY SEMI TRAILER
                
                
                str += "NONE;"; // SWAP ACTION 
                if(a.getP1() instanceof Client){ // On divise la commande en 2 quantités si besoin
                    if(((Client)a.getP1()).getQuantiteCommandee()>Constante.SWAP_BODY_CAPACITY )
                        str +=Constante.SWAP_BODY_CAPACITY+";"+(((Client)a.getP1()).getQuantiteCommandee()-Constante.SWAP_BODY_CAPACITY );
                    else
                        str +=((Client)a.getP1()).getQuantiteCommandee()+";0";
                }else
                    str += "0;0";
                
                str += "\n";
            }
            
            // On créé la ligne de la dernière localisation de la tournée
            str += "R"+(t.getIdTournee()+1)+";";
            str += (arcs.size()+1)+";";
            str += D.getNom()+";";
            str += D.getType()+";";
            str += t.getMax_semi_tr_at()+";"; 
            str += t.getMax_swap_body_tr()+";"; // SWAP BODY TRUCK 
            str += t.getMax_swap_body_sm()+";"; // SWAP BODY SEMI TRAILER
            str += "NONE;"; // SWAP ACTION
            str += "0;"; // SWAP BODY 1 QUANTITY
            str += "0"; // SWAP BODY 2 QUANTITY
            str += "\n";
        }
        return str;
    }

    
    /* @Override
    public String toString() {
        //Header du tableau
        String str = "TOUR_ID;TOUR_POSITION;LOCATION_ID;LOCATION_TYPE;SEMI_TRAILER_ATTACHED;SWAP_BODY_TRUCK;SWAP_BODY_SEMI_TRAILER;SWAP_ACTION;SWAP_BODY_1_QUANTITY;SWAP_BODY_2_QUANTITY\n";
        
        for(Tournee t : tournees){
            ArrayList<Arc> arcs = (ArrayList)t.getArcs();
            
            // Utilisation des valeurs maximal comme variable tampon pour le dernier point de la tournée (Dépot)
            int max_semi_tr_at = 0;
            int max_swap_body_tr = 0;
            int max_swap_body_sm = 0;
            
            Depot D = (Depot) arcs.get(0).getP1();
            for(Arc a : arcs){
                str += "R"+(t.getIdTournee()+1)+";"; // On indique le nom de la tournée
                str += (arcs.indexOf(a)+1)+";"; // On indique la position de la localisation dans tournée
                str += a.getP1().getNom()+";";
                str += a.getP1().getType()+";";
               
                // On check si on peut mettre une remorque
                if(a.isRem())
                    max_semi_tr_at = 1;
                
                str += max_semi_tr_at+";";
                
                str += "1;"; // SWAP BODY TRUCK 
                
                if(a.getP1() instanceof Client){ // On calcule le nombre de remorque dont on a besoin
                    if(max_swap_body_sm < (int) (a.isRem()?Math.ceil(((Client)a.getP1()).getQuantiteCommandee()/Constante.SWAP_BODY_CAPACITY ):0))
                        max_swap_body_sm = (int) (a.isRem()?Math.ceil(((Client)a.getP1()).getQuantiteCommandee()/Constante.SWAP_BODY_CAPACITY ):0);
                    str += max_swap_body_sm+";"; // SWAP BODY SEMI TRAILER
                }else{
                    if(max_swap_body_sm < (int) (a.isRem()?Math.ceil(((Client)a.getP2()).getQuantiteCommandee()/Constante.SWAP_BODY_CAPACITY ):0))
                        max_swap_body_sm = (int) (a.isRem()?Math.ceil(((Client)a.getP2()).getQuantiteCommandee()/Constante.SWAP_BODY_CAPACITY ):0);
                    str += max_swap_body_sm+";"; // SWAP BODY SEMI TRAILER
                }
                
                str += "NONE;"; // SWAP ACTION 
                if(a.getP1() instanceof Client){ // On divise la commande en 2 quantités si besoin
                    if(((Client)a.getP1()).getQuantiteCommandee()>Constante.SWAP_BODY_CAPACITY )
                        str +=Constante.SWAP_BODY_CAPACITY+";"+(((Client)a.getP1()).getQuantiteCommandee()-Constante.SWAP_BODY_CAPACITY );
                    else
                        str +=((Client)a.getP1()).getQuantiteCommandee()+";0";
                }else
                    str += "0;0";
                
                str += "\n";
            }
            
            // On créé la ligne de la dernière localisation de la tournée
            str += "R"+(t.getIdTournee()+1)+";";
            str += (arcs.size()+1)+";";
            str += D.getNom()+";";
            str += D.getType()+";";
            str += max_semi_tr_at+";"; 
            str += "1;"; // SWAP BODY TRUCK 
            str += max_swap_body_sm+";"; // SWAP BODY SEMI TRAILER
            str += "NONE;"; // SWAP ACTION
            str += "0;"; // SWAP BODY 1 QUANTITY
            str += "0"; // SWAP BODY 2 QUANTITY
            str += "\n";
        }
        return str;
    }
    */
}