/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastien
 */
public class Swapbody {
    private float quantite;

    public Swapbody(float quantite) {
        this.quantite = quantite;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Float.floatToIntBits(this.quantite);
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
        final Swapbody other = (Swapbody) obj;
        if (Float.floatToIntBits(this.quantite) != Float.floatToIntBits(other.quantite)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Swapbody{" + "quantite=" + quantite + '}';
    }
    
    
}
