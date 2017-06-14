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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebastien
 */
@Entity
@Table(name = "TOURNEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tournee.findAll", query = "SELECT t FROM Tournee t"),
    @NamedQuery(name = "Tournee.findByIdtournee", query = "SELECT t FROM Tournee t WHERE t.idTournee = :idTournee"),
    @NamedQuery(name = "Tournee.findByCouttotal", query = "SELECT t FROM Tournee t WHERE t.coutTotal = :coutTotal"),
    @NamedQuery(name = "Tournee.findByTempstotal", query = "SELECT t FROM Tournee t WHERE t.tempsTotal = :tempsTotal"),
    @NamedQuery(name = "Tournee.findByMaxSemiTrailerAttached", query = "SELECT t FROM Tournee t WHERE t.max_semi_tr_at = :maxSemiTrailerAttached"),
    @NamedQuery(name = "Tournee.findByMaxSwapBodyTr", query = "SELECT t FROM Tournee t WHERE t.max_swap_body_tr = :maxSwapBodyTr"),
    @NamedQuery(name = "Tournee.findByMaxSwapBodySm", query = "SELECT t FROM Tournee t WHERE t.max_swap_body_sm = :maxSwapBodySm")})
public class Tournee implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ntournee")
    private Collection<Arc> arcs;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTOURNEE")
    private Integer idTournee;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COUTTOTAL")
    private double coutTotal;
    @Column(name = "TEMPSTOTAL")
    private double tempsTotal;
    @Column(name = "MAX_SEMI_TRAILER_ATTACHED")
    private Integer max_semi_tr_at;
    @Column(name = "MAX_SWAP_BODY_TR")
    private Integer max_swap_body_tr;
    @Column(name = "MAX_SWAP_BODY_SM")
    private Integer max_swap_body_sm;
    @ManyToOne(optional = false)
    private Solution solution;

    private int type = 0;
    
    public Tournee() {
        this.max_semi_tr_at=0;
        this.max_swap_body_tr=0;
        this.max_swap_body_sm=0;
    }

    public Tournee(int idTournee, Collection<Arc> arcs, double coutTotal, double tempsTotal) {
        this.idTournee = idTournee;
        this.arcs = arcs;
        this.coutTotal = coutTotal;
        this.tempsTotal = tempsTotal;
        
        this.max_semi_tr_at=0;
        this.max_swap_body_tr=0;
        this.max_swap_body_sm=0;
    }
    

    public Integer getIdTournee() {
        return idTournee;
    }

    public void setIdTournee(Integer idTournee) {
        this.idTournee = idTournee;
    }

    public double getCoutTotal() {
        return coutTotal;
    }

    public void setCoutTotal(double coutTotal) {
        this.coutTotal = coutTotal;
    }

    public double getTempstotal() {
        return tempsTotal;
    }

    public void setTempstotal(double tempsTotal) {
        this.tempsTotal = tempsTotal;
    }

    public Integer getMaxSemiTrailerAttached() {
        return max_semi_tr_at;
    }

    public void setMaxSemiTrailerAttached(Integer max_semi_tr_at) {
        this.max_semi_tr_at = max_semi_tr_at;
    }

    public Integer getMaxSwapBodyTr() {
        return max_swap_body_tr;
    }

    public void setMaxSwapBodyTr(Integer max_swap_body_tr) {
        this.max_swap_body_tr = max_swap_body_tr;
    }

    public Integer getMaxSwapBodySm() {
        return max_swap_body_sm;
    }

    public void setMaxSwapBodySm(Integer max_swap_body_sm) {
        this.max_swap_body_sm = max_swap_body_sm;
    }

    @XmlTransient
    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTournee != null ? idTournee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tournee)) {
            return false;
        }
        Tournee other = (Tournee) object;
        if ((this.idTournee == null && other.idTournee != null) || (this.idTournee != null && !this.idTournee.equals(other.idTournee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Tournee[ idTournee=" + idTournee + " ]";
    }

    @XmlTransient
    public Collection<Arc> getArcs() {
        return arcs;
    }

    public void setArcs(Collection<Arc> arcs) {
        this.arcs = arcs;
    }
    
     public void addArc(Arc a) {
        if (this.type == 0) {
            this.type = (a.isRem() ? 1 : 0);
        }
        if (this.arcs == null) {
            this.arcs = new ArrayList<Arc>();
        }
        a.setTournee(this);
        this.max_semi_tr_at = (a.isRem())?1:0;
        
        if(a.getP1() instanceof Client){ // On calcule le nombre de remorque dont on a besoin
            if(max_swap_body_sm < (int) (a.isRem()?Math.ceil(((Client)a.getP1()).getQuantiteCommandee()/Constante.SWAP_BODY_CAPACITY ):0))
                max_swap_body_sm = (int) (a.isRem()?Math.ceil(((Client)a.getP1()).getQuantiteCommandee()/Constante.SWAP_BODY_CAPACITY ):0);   
        }else{
            if(max_swap_body_sm < (int) (a.isRem()?Math.ceil(((Client) a.getP2()).getQuantiteCommandee()/Constante.SWAP_BODY_CAPACITY ):0))
                max_swap_body_sm = (int) (a.isRem()?Math.ceil(((Client) a.getP2()).getQuantiteCommandee()/Constante.SWAP_BODY_CAPACITY ):0);
        }
        
        // TODO: Faire le test pour savoir quand le wap body truck vaut 1
        max_swap_body_tr = 1; 
        
        this.arcs.add(a);
        this.coutTotal+= a.getCost();
        this.tempsTotal+= a.getTps();
    }
    
}
