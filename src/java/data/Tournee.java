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
public class Tournee {
    
    private int idTournee;
    private Collection<Arc> arcs;
    private double coutTotal;
    private float tempsTotal;
    private float quantiteTotal;
    private int type = 0;
    private static int lastID = 0;
    private int max_semi_tr_at = 0;
    private int max_swap_body_tr = 0;
    private int max_swap_body_sm = 0;
    private boolean modeSL = false;
    
    public Tournee(int idTournee,Collection<Arc> arcs, float coutTotal, float tempsTotal, float quantiteTotal) {
        this.idTournee = idTournee;
        this.arcs = arcs;
        this.coutTotal = coutTotal;
        this.tempsTotal = tempsTotal;
        this.quantiteTotal = quantiteTotal;
    }
    
    public Tournee(int idTournee) {
        this(idTournee, null, 0, 0, 0);
    }
    
    public Tournee(Tournee T) {
        idTournee = T.idTournee;
        arcs = T.arcs;
        coutTotal = T.coutTotal;
        tempsTotal = T.tempsTotal;
        quantiteTotal = T.quantiteTotal;
        type = T.type;
        max_semi_tr_at = T.max_semi_tr_at;
        max_swap_body_tr = T.max_swap_body_tr;
        max_swap_body_sm = T.max_swap_body_sm;
        modeSL = T.modeSL;
    }
    
    public Tournee() {
        this(Tournee.lastID++);
    }

    public int getIdTournee() {
        return idTournee;
    }

    public void setIdTournee(int idTournee) {
        this.idTournee = idTournee;
    }
    

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
            if(max_swap_body_sm < (int) (a.isRem()?Math.ceil(((Client)a.getP2()).getQuantiteCommandee()/Constante.SWAP_BODY_CAPACITY ):0))
                max_swap_body_sm = (int) (a.isRem()?Math.ceil(((Client)a.getP2()).getQuantiteCommandee()/Constante.SWAP_BODY_CAPACITY ):0);
        }
        
        // TODO: Faire le test pour savoir quand le wap body truck vaut 1
        max_swap_body_tr = 1; 
        
        this.arcs.add(a);
        this.coutTotal+= a.getCost();
        this.tempsTotal+= a.getTps();
        this.quantiteTotal+= a.getQuantite();
        if (a.getP2() instanceof Client) {
            ((Client)a.getP2()).setQuantiteCommandee(this.quantiteTotal);
        }
    }

    public int getMax_semi_tr_at() {
        return max_semi_tr_at;
    }

    public int getMax_swap_body_tr() {
        return max_swap_body_tr;
    }

    public int getMax_swap_body_sm() {
        return max_swap_body_sm;
    }

    
    
    public double getCoutTotal() {
        return coutTotal;
    }

    public void setCoutTotal(double coutTotal) {
        this.coutTotal = coutTotal;
    }

    public float getTempsTotal() {
        return tempsTotal;
    }

    public void setTempsTotal(float tempsTotal) {
        this.tempsTotal = tempsTotal;
    }

    public float getQuantiteTotal() {
        return quantiteTotal;
    }

    public void setQuantiteTotal(float quantiteTotal) {
        this.quantiteTotal = quantiteTotal;
    }  
    
    public Collection<Point> getPoints() {
        Collection<Point> points = new ArrayList<>();
        for (Arc a : this.arcs) {
            points.add(a.getP1());
        }
        return points;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idTournee;
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
        final Tournee other = (Tournee) obj;
        if (this.idTournee != other.idTournee) {
            return false;
        }
        return true;
    }
    
    public Arc getRetour() {
        return (Arc) this.arcs.toArray()[this.arcs.size() - 1];
    }

    @Override
    public String toString() {
        return "Tournee{" + "idTournee=" + idTournee + ", points=" + arcs + ", coutTotal=" + coutTotal + ", tempsTotal=" + tempsTotal + ", quantiteTotal=" + quantiteTotal + '}';
    }

    int getType() {
        return this.type;
    }
    
    public boolean removeArc(Arc a) {
        this.arcs.remove(a);
        this.coutTotal -= a.getCost();
        this.tempsTotal -= a.getTps();
        return true;
    }
    
    public boolean addPoint(Point p, int rem) {

        if (this.modeSL) {
            for (Arc a : this.arcs) {
                if (a.getP2() instanceof Swaplocation) {
                    this.removeArc(a);
                    this.addArc(new Arc(a.getP1(), p, rem, null, ((Client) p).getQuantiteCommandee()));
                    this.addArc(new Arc(p, a.getP2(), (rem == 1 ? new Train() : new Camion())));
                }
            }
        } else {
            for (Arc a : this.arcs) {
                if (a.getP2() instanceof Depot) {
                    //System.out.println("//////////////////////////////");
                    //System.out.println(a.getCost());
                    //System.out.println(a.getTps());
                    this.removeArc(a);
                    //System.out.println(this.getCoutTotal());
                    this.addArc(new Arc(a.getP1(), p, rem, (rem == 1 ? new Train() : new Camion()), ((Client) p).getQuantiteCommandee() ));
                    //System.out.println(this.getCoutTotal());
                    this.addArc(new Arc(p, a.getP2(), (rem == 1 ? new Train() : new Camion())));
                    //System.out.println(this.getCoutTotal());
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean changeVehicule(Vehicule v) {
        for (Arc a : this.arcs) {
            a.setVehicule(v);
        }
        return true;
    }

    public float getQuantiteCommandee() {
        return this.quantiteTotal;
    }

    public void addSL() {
        this.modeSL = false;
    }
    
    public void addSL(Point SL, Point P) {
        if (this.modeSL) {
            this.modeSL = false;
        } else {
            this.addPoint(SL, 1);
            for (Arc a : this.arcs) {
                if (a.getP2() instanceof Depot) {
                    this.removeArc(a);
                    this.addArc(new Arc(SL, P, 0, null, ((Client)P).getQuantiteCommandee()));
                    this.addArc(new Arc(P, SL, 0,null, ((Client)SL).getQuantiteCommandee()));
                    this.addArc(new Arc(SL, a.getP2(), 1, null, ((Client)a.getP2()).getQuantiteCommandee()));
                }
            }
            //this.addPoint(P1, 1);
            this.modeSL = true;
        }
    }
}
