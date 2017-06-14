/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CONSTANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Constante.findAll", query = "SELECT c FROM Constante c"),
    @NamedQuery(name = "Constante.findByIdconstante", query = "SELECT c FROM Constante c WHERE c.idconstante = :idconstante"),
    @NamedQuery(name = "Constante.findByPark", query = "SELECT c FROM Constante c WHERE c.park = :park"),
    @NamedQuery(name = "Constante.findBySwap", query = "SELECT c FROM Constante c WHERE c.swap = :swap"),
    @NamedQuery(name = "Constante.findByExchange", query = "SELECT c FROM Constante c WHERE c.exchange = :exchange"),
    @NamedQuery(name = "Constante.findByPickup", query = "SELECT c FROM Constante c WHERE c.pickup = :pickup"),
    @NamedQuery(name = "Constante.findByTruckCapacity", query = "SELECT c FROM Constante c WHERE c.truckCapacity = :truckCapacity"),
    @NamedQuery(name = "Constante.findByTruckCostKm", query = "SELECT c FROM Constante c WHERE c.truckCostKm = :truckCostKm"),
    @NamedQuery(name = "Constante.findByTruckCostH", query = "SELECT c FROM Constante c WHERE c.truckCostH = :truckCostH"),
    @NamedQuery(name = "Constante.findByTruckCostUsage", query = "SELECT c FROM Constante c WHERE c.truckCostUsage = :truckCostUsage"),
    @NamedQuery(name = "Constante.findByTruckOperatingTime", query = "SELECT c FROM Constante c WHERE c.truckOperatingTime = :truckOperatingTime"),
    @NamedQuery(name = "Constante.findBySemiTrailerCapacity", query = "SELECT c FROM Constante c WHERE c.semiTrailerCapacity = :semiTrailerCapacity"),
    @NamedQuery(name = "Constante.findBySemiTrailerCostKm", query = "SELECT c FROM Constante c WHERE c.semiTrailerCostKm = :semiTrailerCostKm"),
    @NamedQuery(name = "Constante.findBySemiTrailerCostH", query = "SELECT c FROM Constante c WHERE c.semiTrailerCostH = :semiTrailerCostH"),
    @NamedQuery(name = "Constante.findBySemiTrailerCostUsage", query = "SELECT c FROM Constante c WHERE c.semiTrailerCostUsage = :semiTrailerCostUsage"),
    @NamedQuery(name = "Constante.findBySemiTrailerOperatingTime", query = "SELECT c FROM Constante c WHERE c.semiTrailerOperatingTime = :semiTrailerOperatingTime"),
    @NamedQuery(name = "Constante.findBySwapBodyCapacity", query = "SELECT c FROM Constante c WHERE c.swapBodyCapacity = :swapBodyCapacity"),
    @NamedQuery(name = "Constante.findBySwapBodyCostKm", query = "SELECT c FROM Constante c WHERE c.swapBodyCostKm = :swapBodyCostKm"),
    @NamedQuery(name = "Constante.findBySwapBodyCostH", query = "SELECT c FROM Constante c WHERE c.swapBodyCostH = :swapBodyCostH"),
    @NamedQuery(name = "Constante.findBySwapBodyCostUsage", query = "SELECT c FROM Constante c WHERE c.swapBodyCostUsage = :swapBodyCostUsage"),
    @NamedQuery(name = "Constante.findBySwapBodyOperatingTime", query = "SELECT c FROM Constante c WHERE c.swapBodyOperatingTime = :swapBodyOperatingTime")})
public class Constante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCONSTANTE")
    public static Integer idconstante;
    @Column(name = "PARK")
    public static Integer PARK;
    @Column(name = "SWAP")
    public static Integer SWAP;
    @Column(name = "EXCHANGE")
    public static Integer EXCHANGE;
    @Column(name = "PICKUP")
    public static Integer PICKUP;
    @Column(name = "TRUCK_CAPACITY")
    public static Integer TRUCK_CAPACITY;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TRUCK_COST_KM")
    public static Double TRUCK_COST_KM;
    @Column(name = "TRUCK_COST_H")
    public static Double TRUCK_COST_H;
    @Column(name = "TRUCK_COST_USAGE")
    public static Double TRUCK_COST_USAGE;
    @Column(name = "TRUCK_OPERATING_TIME")
    public static Integer TRUCK_OPERATING_TIME;
    @Column(name = "SEMI_TRAILER_CAPACITY")
    public static Integer SEMI_TRAILER_CAPACITY;
    @Column(name = "SEMI_TRAILER_COST_KM")
    public static Double SEMI_TRAILER_COST_KM;
    @Column(name = "SEMI_TRAILER_COST_H")
    public static Double SEMI_TRAILER_COST_H;
    @Column(name = "SEMI_TRAILER_COST_USAGE")
    public static Double SEMI_TRAILER_COST_USAGE;
    @Column(name = "SEMI_TRAILER_OPERATING_TIME")
    public static Integer SEMI_TRAILER_OPERATING_TIME;
    @Column(name = "SWAP_BODY_CAPACITY")
    public static Integer SWAP_BODY_CAPACITY;
    @Column(name = "SWAP_BODY_COST_KM")
    public static Double SWAP_BODY_COST_KM;
    @Column(name = "SWAP_BODY_COST_H")
    public static Double SWAP_BODY_COST_H;
    @Column(name = "SWAP_BODY_COST_USAGE")
    public static Double SWAP_BODY_COST_USAGE;
    @Column(name = "SWAP_BODY_OPERATING_TIME")
    public static Integer SWAP_BODY_OPERATING_TIME;
    @Id
    private Long id;

    public Constante() {
    }

    public Constante(Integer idconstante) {
        this.idconstante = idconstante;
    }

    public Integer getIdconstante() {
        return idconstante;
    }

    public void setIdconstante(Integer idconstante) {
        this.idconstante = idconstante;
    }

    public static Integer getPARK() {
        return PARK;
    }

    public static void setPARK(Integer PARK) {
        Constante.PARK = PARK;
    }

    public static Integer getSWAP() {
        return SWAP;
    }

    public static void setSWAP(Integer SWAP) {
        Constante.SWAP = SWAP;
    }

    public static Integer getEXCHANGE() {
        return EXCHANGE;
    }

    public static void setEXCHANGE(Integer EXCHANGE) {
        Constante.EXCHANGE = EXCHANGE;
    }

    public static Integer getPICKUP() {
        return PICKUP;
    }

    public static void setPICKUP(Integer PICKUP) {
        Constante.PICKUP = PICKUP;
    }

    public static Integer getTRUCK_CAPACITY() {
        return TRUCK_CAPACITY;
    }

    public static void setTRUCK_CAPACITY(Integer TRUCK_CAPACITY) {
        Constante.TRUCK_CAPACITY = TRUCK_CAPACITY;
    }

    public static Double getTRUCK_COST_KM() {
        return TRUCK_COST_KM;
    }

    public static void setTRUCK_COST_KM(Double TRUCK_COST_KM) {
        Constante.TRUCK_COST_KM = TRUCK_COST_KM;
    }

    public static Double getTRUCK_COST_H() {
        return TRUCK_COST_H;
    }

    public static void setTRUCK_COST_H(Double TRUCK_COST_H) {
        Constante.TRUCK_COST_H = TRUCK_COST_H;
    }

    public static Double getTRUCK_COST_USAGE() {
        return TRUCK_COST_USAGE;
    }

    public static void setTRUCK_COST_USAGE(Double TRUCK_COST_USAGE) {
        Constante.TRUCK_COST_USAGE = TRUCK_COST_USAGE;
    }

    public static Integer getTRUCK_OPERATING_TIME() {
        return TRUCK_OPERATING_TIME;
    }

    public static void setTRUCK_OPERATING_TIME(Integer TRUCK_OPERATING_TIME) {
        Constante.TRUCK_OPERATING_TIME = TRUCK_OPERATING_TIME;
    }

    public static Integer getSEMI_TRAILER_CAPACITY() {
        return SEMI_TRAILER_CAPACITY;
    }

    public static void setSEMI_TRAILER_CAPACITY(Integer SEMI_TRAILER_CAPACITY) {
        Constante.SEMI_TRAILER_CAPACITY = SEMI_TRAILER_CAPACITY;
    }

    public static Double getSEMI_TRAILER_COST_KM() {
        return SEMI_TRAILER_COST_KM;
    }

    public static void setSEMI_TRAILER_COST_KM(Double SEMI_TRAILER_COST_KM) {
        Constante.SEMI_TRAILER_COST_KM = SEMI_TRAILER_COST_KM;
    }

    public static Double getSEMI_TRAILER_COST_H() {
        return SEMI_TRAILER_COST_H;
    }

    public static void setSEMI_TRAILER_COST_H(Double SEMI_TRAILER_COST_H) {
        Constante.SEMI_TRAILER_COST_H = SEMI_TRAILER_COST_H;
    }

    public static Double getSEMI_TRAILER_COST_USAGE() {
        return SEMI_TRAILER_COST_USAGE;
    }

    public static void setSEMI_TRAILER_COST_USAGE(Double SEMI_TRAILER_COST_USAGE) {
        Constante.SEMI_TRAILER_COST_USAGE = SEMI_TRAILER_COST_USAGE;
    }

    public static Integer getSEMI_TRAILER_OPERATING_TIME() {
        return SEMI_TRAILER_OPERATING_TIME;
    }

    public static void setSEMI_TRAILER_OPERATING_TIME(Integer SEMI_TRAILER_OPERATING_TIME) {
        Constante.SEMI_TRAILER_OPERATING_TIME = SEMI_TRAILER_OPERATING_TIME;
    }

    public static Integer getSWAP_BODY_CAPACITY() {
        return SWAP_BODY_CAPACITY;
    }

    public static void setSWAP_BODY_CAPACITY(Integer SWAP_BODY_CAPACITY) {
        Constante.SWAP_BODY_CAPACITY = SWAP_BODY_CAPACITY;
    }

    public static Double getSWAP_BODY_COST_KM() {
        return SWAP_BODY_COST_KM;
    }

    public static void setSWAP_BODY_COST_KM(Double SWAP_BODY_COST_KM) {
        Constante.SWAP_BODY_COST_KM = SWAP_BODY_COST_KM;
    }

    public static Double getSWAP_BODY_COST_H() {
        return SWAP_BODY_COST_H;
    }

    public static void setSWAP_BODY_COST_H(Double SWAP_BODY_COST_H) {
        Constante.SWAP_BODY_COST_H = SWAP_BODY_COST_H;
    }

    public static Double getSWAP_BODY_COST_USAGE() {
        return SWAP_BODY_COST_USAGE;
    }

    public static void setSWAP_BODY_COST_USAGE(Double SWAP_BODY_COST_USAGE) {
        Constante.SWAP_BODY_COST_USAGE = SWAP_BODY_COST_USAGE;
    }

    public static Integer getSWAP_BODY_OPERATING_TIME() {
        return SWAP_BODY_OPERATING_TIME;
    }

    public static void setSWAP_BODY_OPERATING_TIME(Integer SWAP_BODY_OPERATING_TIME) {
        Constante.SWAP_BODY_OPERATING_TIME = SWAP_BODY_OPERATING_TIME;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconstante != null ? idconstante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Constante)) {
            return false;
        }
        Constante other = (Constante) object;
        if ((this.idconstante == null && other.idconstante != null) || (this.idconstante != null && !this.idconstante.equals(other.idconstante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Constante[ idconstante=" + idconstante + " ]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
