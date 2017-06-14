/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastien
 */
@Entity
@Table(name = "SOLUTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solution.findAll", query = "SELECT s FROM Solution s"),
    @NamedQuery(name = "Solution.findByIdsolution", query = "SELECT s FROM Solution s WHERE s.idSolution = :idSolution"),
    @NamedQuery(name = "Solution.findAllTournees", query = "SELECT s FROM Solution s WHERE s.idSolution = :idSolution")}
)
    

public class Solution implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSOLUTION")
    private Integer idSolution;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solution")
    private Collection<Tournee> tournees;

    private double coutTotal;

    public double getCoutTotal() {
        return coutTotal;
    }

    public void setCoutTotal(double coutTotal) {
        this.coutTotal = coutTotal;
    }
    
    public Solution() {
    }

    public Solution(int idSolution, Collection<Tournee> tournees) {
        this.idSolution = idSolution;
        this.tournees = tournees;
    }
    
    public Integer getIdsolution() {
        return idSolution;
    }

    public void setIdsolution(Integer idSolution) {
        this.idSolution = idSolution;
    }

    public Collection<Tournee> getNtournee() {
        return tournees;
    }

    public void setNtournee(Collection<Tournee> tournees) {
        this.tournees = tournees;
    }
    
    
    public void addTournee(Tournee t) {
        if (this.tournees == null) {
            this.tournees = new ArrayList<Tournee>();
        }
        t.setSolution(this);
        this.tournees.add(t);
        this.coutTotal+= t.getCoutTotal();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolution != null ? idSolution.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solution)) {
            return false;
        }
        Solution other = (Solution) object;
        if ((this.idSolution == null && other.idSolution != null) || (this.idSolution != null && !this.idSolution.equals(other.idSolution))) {
            return false;
        }
        return true;
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
                
                str += t.getMaxSemiTrailerAttached()+";";
                
                str += t.getMaxSwapBodyTr()+";"; // SWAP BODY TRUCK 
                
                str += t.getMaxSwapBodySm()+";"; // SWAP BODY SEMI TRAILER
                
                
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
            str += t.getMaxSemiTrailerAttached()+";";
    
            str += t.getMaxSwapBodyTr()+";"; // SWAP BODY TRUCK 
            str += t.getMaxSwapBodySm()+";"; // SWAP BODY SEMI TRAILER    
            str += "NONE;"; // SWAP ACTION
            str += "0;"; // SWAP BODY 1 QUANTITY
            str += "0"; // SWAP BODY 2 QUANTITY
            str += "\n";
        }
        return str;
    }
    
}
