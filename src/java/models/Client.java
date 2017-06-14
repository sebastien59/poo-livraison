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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastien
 */
@Entity
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdclient", query = "SELECT c FROM Client c WHERE c.idclient = :idclient"),
    @NamedQuery(name = "Client.findByNomclient", query = "SELECT c FROM Client c WHERE c.nomClient = :nomClient"),
    @NamedQuery(name = "Client.findByTempsservice", query = "SELECT c FROM Client c WHERE c.tempsService = :tempsService"),
    @NamedQuery(name = "Client.findByQuantitecommandee", query = "SELECT c FROM Client c WHERE c.quantiteCommandee = :quantiteCommandee"),
    @NamedQuery(name = "Client.findByRemorque", query = "SELECT c FROM Client c WHERE c.remorque = :remorque")})

public class Client extends Point implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCLIENT")
    private Integer idclient;
    @Size(max = 45)
    @Column(name = "NOMCLIENT")
    private String nomClient;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TEMPSSERVICE")
    private double tempsService;
    @Column(name = "QUANTITECOMMANDEE")
    private double quantiteCommandee;
    @Column(name = "REMORQUE")
    private boolean remorque;
    /*@JoinColumn(name = "NPOINT", referencedColumnName = "IDPOINT")
    @ManyToOne(optional = false)
    private Point npoint;*/
    @JoinColumn(name = "NTOURNEE", referencedColumnName = "IDTOURNEE")
    @ManyToOne(optional = false)
    private Tournee ntournee;
    
    @JoinColumn(name = "ARC", referencedColumnName="IDARC")
    private Arc a;

    public Client() {
    }

    public Client(int idClient, String nomClient, double tempsService, double quantiteCommandee, int id, String nom, double x, double y, boolean rem) {
        super(id, nom, x, y);
        //this.idClient = idClient;
        this.nomClient = nomClient;
        this.tempsService = tempsService;
        this.quantiteCommandee = quantiteCommandee;
        this.remorque = rem;
    }

     public Client(int idClient, String nomClient, float tempsService, float quantiteCommandee, int id, String nom, double x, double y) {
         this(idClient, nomClient, tempsService, quantiteCommandee, id, nom, x, y, false);
     }
    
   /* public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }*/

    public String getNomclient() {
        return nomClient;
    }

    public void setNomclient(String nomClient) {
        this.nomClient = nomClient;
    }

    public double getTempsservice() {
        return tempsService;
    }

    public void setTempsservice(double tempsService) {
        this.tempsService = tempsService;
    }

    public double getQuantiteCommandee() {
        return quantiteCommandee;
    }

    public void setQuantiteCommandee(double quantiteCommandee) {
        this.quantiteCommandee = quantiteCommandee;
    }

    public boolean isDeliverableByTrain() {
        return remorque;
    }

    /*public Point getNpoint() {
        return npoint;
    }

    public void setNpoint(Point npoint) {
        this.npoint = npoint;
    }*/
    
     public void setArc(Arc a) {
        this.a = a;
    }
    
    public Arc getArc() {
        return this.a;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclient != null ? idclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        return !((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId())));
    }

    @Override
    public String toString() {
        return "models.Client[ idclient=" + idclient + " ]";
    }
    
    public void setTournee(Tournee T) {
        this.ntournee = T;
    }
    
}
