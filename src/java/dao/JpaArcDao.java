/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Arc;

/**
 *
 * @author sebastien
 */
public class JpaArcDao extends JpaDao<Arc> implements ArcDao {
    private static JpaArcDao instance = new JpaArcDao();

    private JpaArcDao() {
    }

    protected static JpaArcDao getInstance(){
        if(instance == null){
            instance = new JpaArcDao();
        }
        return instance;
    }

    @Override
    public Arc find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Arc> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
