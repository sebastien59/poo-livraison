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
    @NamedQuery(name = "Constante.findAll", query = "SELECT c FROM Constante c")
    , @NamedQuery(name = "Constante.findByIdconstante", query = "SELECT c FROM Constante c WHERE c.idconstante = :idconstante")
    , @NamedQuery(name = "Constante.findByPark", query = "SELECT c FROM Constante c WHERE c.park = :park")
    , @NamedQuery(name = "Constante.findBySwap", query = "SELECT c FROM Constante c WHERE c.swap = :swap")
    , @NamedQuery(name = "Constante.findByExchange", query = "SELECT c FROM Constante c WHERE c.exchange = :exchange")
    , @NamedQuery(name = "Constante.findByPickup", query = "SELECT c FROM Constante c WHERE c.pickup = :pickup")
    , @NamedQuery(name = "Constante.findByTruckCapacity", query = "SELECT c FROM Constante c WHERE c.truckCapacity = :truckCapacity")
    , @NamedQuery(name = "Constante.findByTruckCostKm", query = "SELECT c FROM Constante c WHERE c.truckCostKm = :truckCostKm")
    , @NamedQuery(name = "Constante.findByTruckCostH", query = "SELECT c FROM Constante c WHERE c.truckCostH = :truckCostH")
    , @NamedQuery(name = "Constante.findByTruckCostUsage", query = "SELECT c FROM Constante c WHERE c.truckCostUsage = :truckCostUsage")
    , @NamedQuery(name = "Constante.findByTruckOperatingTime", query = "SELECT c FROM Constante c WHERE c.truckOperatingTime = :truckOperatingTime")
    , @NamedQuery(name = "Constante.findBySemiTrailerCapacity", query = "SELECT c FROM Constante c WHERE c.semiTrailerCapacity = :semiTrailerCapacity")
    , @NamedQuery(name = "Constante.findBySemiTrailerCostKm", query = "SELECT c FROM Constante c WHERE c.semiTrailerCostKm = :semiTrailerCostKm")
    , @NamedQuery(name = "Constante.findBySemiTrailerCostH", query = "SELECT c FROM Constante c WHERE c.semiTrailerCostH = :semiTrailerCostH")
    , @NamedQuery(name = "Constante.findBySemiTrailerCostUsage", query = "SELECT c FROM Constante c WHERE c.semiTrailerCostUsage = :semiTrailerCostUsage")
    , @NamedQuery(name = "Constante.findBySemiTrailerOperatingTime", query = "SELECT c FROM Constante c WHERE c.semiTrailerOperatingTime = :semiTrailerOperatingTime")
    , @NamedQuery(name = "Constante.findBySwapBodyCapacity", query = "SELECT c FROM Constante c WHERE c.swapBodyCapacity = :swapBodyCapacity")
    , @NamedQuery(name = "Constante.findBySwapBodyCostKm", query = "SELECT c FROM Constante c WHERE c.swapBodyCostKm = :swapBodyCostKm")
    , @NamedQuery(name = "Constante.findBySwapBodyCostH", query = "SELECT c FROM Constante c WHERE c.swapBodyCostH = :swapBodyCostH")
    , @NamedQuery(name = "Constante.findBySwapBodyCostUsage", query = "SELECT c FROM Constante c WHERE c.swapBodyCostUsage = :swapBodyCostUsage")
    , @NamedQuery(name = "Constante.findBySwapBodyOperatingTime", query = "SELECT c FROM Constante c WHERE c.swapBodyOperatingTime = :swapBodyOperatingTime")})
public class Constante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCONSTANTE")
    private Integer idconstante;
    @Column(name = "PARK")
    private Integer park;
    @Column(name = "SWAP")
    private Integer swap;
    @Column(name = "EXCHANGE")
    private Integer exchange;
    @Column(name = "PICKUP")
    private Integer pickup;
    @Column(name = "TRUCK_CAPACITY")
    private Integer truckCapacity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TRUCK_COST_KM")
    private Double truckCostKm;
    @Column(name = "TRUCK_COST_H")
    private Double truckCostH;
    @Column(name = "TRUCK_COST_USAGE")
    private Double truckCostUsage;
    @Column(name = "TRUCK_OPERATING_TIME")
    private Integer truckOperatingTime;
    @Column(name = "SEMI_TRAILER_CAPACITY")
    private Integer semiTrailerCapacity;
    @Column(name = "SEMI_TRAILER_COST_KM")
    private Double semiTrailerCostKm;
    @Column(name = "SEMI_TRAILER_COST_H")
    private Double semiTrailerCostH;
    @Column(name = "SEMI_TRAILER_COST_USAGE")
    private Double semiTrailerCostUsage;
    @Column(name = "SEMI_TRAILER_OPERATING_TIME")
    private Integer semiTrailerOperatingTime;
    @Column(name = "SWAP_BODY_CAPACITY")
    private Integer swapBodyCapacity;
    @Column(name = "SWAP_BODY_COST_KM")
    private Double swapBodyCostKm;
    @Column(name = "SWAP_BODY_COST_H")
    private Double swapBodyCostH;
    @Column(name = "SWAP_BODY_COST_USAGE")
    private Double swapBodyCostUsage;
    @Column(name = "SWAP_BODY_OPERATING_TIME")
    private Integer swapBodyOperatingTime;

    public static int PARK;
    public static int SWAP;
    public static int EXCHANGE;
    public static int PICKUP;
    
    public static int TRUCK_CAPACITY;
    public static double TRUCK_COST_KM;
    public static double TRUCK_COST_H;
    public static double TRUCK_COST_USAGE;
    public static int TRUCK_OPERATING_TIME;
    
    public static int SEMI_TRAILER_CAPACITY;
    public static double SEMI_TRAILER_COST_KM;
    public static double SEMI_TRAILER_COST_H;
    public static double SEMI_TRAILER_COST_USAGE;
    public static int SEMI_TRAILER_OPERATING_TIME;
    
    public static int SWAP_BODY_CAPACITY;
    public static double SWAP_BODY_COST_KM;
    public static double SWAP_BODY_COST_H;
    public static double SWAP_BODY_COST_USAGE;
    public static int SWAP_BODY_OPERATING_TIME;
    
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

    public Integer getPark() {
        return park;
    }

    public void setPark(Integer park) {
        this.park = park;
        Constante.PARK = park;
    }

    public Integer getSwap() {
        return swap;
    }

    public void setSwap(Integer swap) {
        this.swap = swap;
        Constante.SWAP = swap;
    }

    public Integer getExchange() {
        return exchange;
    }

    public void setExchange(Integer exchange) {
        this.exchange = exchange;
        Constante.EXCHANGE = exchange;
    }

    public Integer getPickup() {
        return pickup;
    }

    public void setPickup(Integer pickup) {
        this.pickup = pickup;
        Constante.PICKUP = pickup;
    }

    public Integer getTruckCapacity() {
        return truckCapacity;
    }

    public void setTruckCapacity(Integer truckCapacity) {
        this.truckCapacity = truckCapacity;
        Constante.TRUCK_CAPACITY = truckCapacity;
    }

    public Double getTruckCostKm() {
        return truckCostKm;
    }

    public void setTruckCostKm(Double truckCostKm) {
        this.truckCostKm = truckCostKm;
        Constante.TRUCK_COST_KM = truckCostKm;
    }

    public Double getTruckCostH() {
        return truckCostH;
    }

    public void setTruckCostH(Double truckCostH) {
        this.truckCostH = truckCostH;
        Constante.TRUCK_COST_H = truckCostH;
    }

    public Double getTruckCostUsage() {
        return truckCostUsage;
    }

    public void setTruckCostUsage(Double truckCostUsage) {
        this.truckCostUsage = truckCostUsage;
        Constante.TRUCK_COST_USAGE = truckCostUsage;
    }

    public Integer getTruckOperatingTime() {
        return truckOperatingTime;
    }

    public void setTruckOperatingTime(Integer truckOperatingTime) {
        this.truckOperatingTime = truckOperatingTime;
        Constante.TRUCK_OPERATING_TIME = truckOperatingTime;
    }

    public Integer getSemiTrailerCapacity() {
        return semiTrailerCapacity;
    }

    public void setSemiTrailerCapacity(Integer semiTrailerCapacity) {
        this.semiTrailerCapacity = semiTrailerCapacity;
        Constante.SEMI_TRAILER_CAPACITY = semiTrailerCapacity;
    }

    public Double getSemiTrailerCostKm() {
        return semiTrailerCostKm;
    }

    public void setSemiTrailerCostKm(Double semiTrailerCostKm) {
        this.semiTrailerCostKm = semiTrailerCostKm;
        Constante.SEMI_TRAILER_COST_KM = semiTrailerCostKm;
    }

    public Double getSemiTrailerCostH() {
        return semiTrailerCostH;
    }

    public void setSemiTrailerCostH(Double semiTrailerCostH) {
        this.semiTrailerCostH = semiTrailerCostH;
        Constante.SEMI_TRAILER_COST_H = semiTrailerCostH;
    }

    public Double getSemiTrailerCostUsage() {
        return semiTrailerCostUsage;
    }

    public void setSemiTrailerCostUsage(Double semiTrailerCostUsage) {
        this.semiTrailerCostUsage = semiTrailerCostUsage;
        Constante.SEMI_TRAILER_COST_USAGE = semiTrailerCostUsage;
    }

    public Integer getSemiTrailerOperatingTime() {
        return semiTrailerOperatingTime;
    }

    public void setSemiTrailerOperatingTime(Integer semiTrailerOperatingTime) {
        this.semiTrailerOperatingTime = semiTrailerOperatingTime;
        Constante.SEMI_TRAILER_OPERATING_TIME = semiTrailerOperatingTime;
    }

    public Integer getSwapBodyCapacity() {
        return swapBodyCapacity;
    }

    public void setSwapBodyCapacity(Integer swapBodyCapacity) {
        this.swapBodyCapacity = swapBodyCapacity;
        Constante.SWAP_BODY_CAPACITY = swapBodyCapacity;
    }

    public Double getSwapBodyCostKm() {
        return swapBodyCostKm;
    }

    public void setSwapBodyCostKm(Double swapBodyCostKm) {
        this.swapBodyCostKm = swapBodyCostKm;
        Constante.SWAP_BODY_COST_KM = swapBodyCostKm;
    }

    public Double getSwapBodyCostH() {
        return swapBodyCostH;
    }

    public void setSwapBodyCostH(Double swapBodyCostH) {
        this.swapBodyCostH = swapBodyCostH;
        Constante.SWAP_BODY_COST_H = swapBodyCostH;
    }

    public Double getSwapBodyCostUsage() {
        return swapBodyCostUsage;
    }

    public void setSwapBodyCostUsage(Double swapBodyCostUsage) {
        this.swapBodyCostUsage = swapBodyCostUsage;
        Constante.SWAP_BODY_COST_USAGE = swapBodyCostUsage;
    }

    public Integer getSwapBodyOperatingTime() {
        return swapBodyOperatingTime;
    }

    public void setSwapBodyOperatingTime(Integer swapBodyOperatingTime) {
        this.swapBodyOperatingTime = swapBodyOperatingTime;
        Constante.SWAP_BODY_OPERATING_TIME = swapBodyOperatingTime;
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
    
}
