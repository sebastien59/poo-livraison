/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Solution.findByIdsolution", query = "SELECT s FROM Solution s WHERE s.idSolution = :idSolution")})
public class Solution implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSOLUTION")
    private Integer idSolution;
    @JoinColumn(name = "NTOURNEE", referencedColumnName = "IDTOURNEE")
    @ManyToOne(optional = false)
    private Tournee ntournee;

    public Solution() {
    }

    public Solution(int idSolution, Collection<Tournee> tournees) {
        this.idSolution = idSolution;
        this.ntournee = ntournee;
    }
    

    public Integer getIdsolution() {
        return idSolution;
    }

    public void setIdsolution(Integer idSolution) {
        this.idSolution = idSolution;
    }

    public Tournee getNtournee() {
        return ntournee;
    }

    public void setNtournee(Tournee ntournee) {
        this.ntournee = ntournee;
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
        return "models.Solution[ idSolution=" + idSolution + " ]";
    }
    
}
