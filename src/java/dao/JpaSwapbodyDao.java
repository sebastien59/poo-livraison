/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Swapbody;

/**
 *
 * @author sebastien
 */
public class JpaSwapbodyDao extends JpaDao<Swapbody> implements SwapbodyDao {
    private static JpaSwapbodyDao instance = new JpaSwapbodyDao();

    private JpaSwapbodyDao() {
    }

    protected static JpaSwapbodyDao getInstance(){
        if(instance == null){
            instance = new JpaSwapbodyDao();
        }
        return instance;
    }

    @Override
    public Swapbody find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Swapbody> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
