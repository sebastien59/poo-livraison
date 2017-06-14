/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Swaplocation;

/**
 *
 * @author sebastien
 */
public class JpaSwaplocationDao extends JpaDao<Swaplocation> implements SwaplocationDao {
    private static JpaSwaplocationDao instance = new JpaSwaplocationDao();

    private JpaSwaplocationDao() {
    }

    protected static JpaSwaplocationDao getInstance(){
        if(instance == null){
            instance = new JpaSwaplocationDao();
        }
        return instance;
    }

    @Override
    public Swaplocation find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Swaplocation> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
