
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

    public Solution(int idSolution, Collection<Tournee> tournees) {
        this.idSolution = idSolution;
        this.tournees = tournees;
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

    @Override
    public String toString() {
        return "Solution{" + "idSolution=" + idSolution + ", tournees=" + tournees + '}';
    }
    
    
    
}
