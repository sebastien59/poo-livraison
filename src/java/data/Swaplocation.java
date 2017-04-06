package data;


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
public class Swaplocation extends Point{
    
    private int idSwapLocation;
    private String name;
    private Collection <Swapbody> swapbodys;
    private float tempsAction;

    public Swaplocation(int idSwapLocation, Collection<Swapbody> swapbodys, float tempsAction, int id, String nom, float x, float y) {
        super(id, nom, x, y);
        this.idSwapLocation = idSwapLocation;
        this.swapbodys = swapbodys;
        this.tempsAction = tempsAction;
    }

    public int getIdSwapLocation() {
        return idSwapLocation;
    }

    public void setIdSwapLocation(int idSwapLocation) {
        this.idSwapLocation = idSwapLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Swapbody> getSwapbodys() {
        return swapbodys;
    }

    public void setSwapbodys(Collection<Swapbody> swapbodys) {
        this.swapbodys = swapbodys;
    }

    public float getTempsAction() {
        return tempsAction;
    }

    public void setTempsAction(float tempsAction) {
        this.tempsAction = tempsAction;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idSwapLocation;
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
        final Swaplocation other = (Swaplocation) obj;
        if (this.idSwapLocation != other.idSwapLocation) {
            return false;
        }
        return true;
    }  
    
    @Override
    public String toString() {
        return "Swaplocation{" + "idSwapLocation=" + idSwapLocation + ", name=" + name + ", swapbodys=" + swapbodys + ", tempsAction=" + tempsAction + '}';
    }

    
    
    
    
    
}
