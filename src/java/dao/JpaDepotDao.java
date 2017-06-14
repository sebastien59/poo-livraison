/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Depot;

/**
 *
 * @author sebastien
 */
public class JpaDepotDao extends JpaDao<Depot> implements DepotDao {
    private static JpaDepotDao instance = new JpaDepotDao();

    private JpaDepotDao() {
    }

    protected static JpaDepotDao getInstance(){
        if(instance == null){
            instance = new JpaDepotDao();
        }
        return instance;
    }

    @Override
    public Depot find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Depot> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
