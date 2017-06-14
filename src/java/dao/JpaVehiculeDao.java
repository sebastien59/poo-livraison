/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Vehicule;

/**
 *
 * @author sebastien
 */
public class JpaVehiculeDao extends JpaDao<Vehicule> implements VehiculeDao {
    private static JpaVehiculeDao instance = new JpaVehiculeDao();

    private JpaVehiculeDao() {
    }

    protected static JpaVehiculeDao getInstance(){
        if(instance == null){
            instance = new JpaVehiculeDao();
        }
        return instance;
    }

    @Override
    public Vehicule find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Vehicule> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
