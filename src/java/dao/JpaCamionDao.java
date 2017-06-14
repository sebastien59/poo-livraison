/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Camion;

/**
 *
 * @author sebastien
 */
public class JpaCamionDao extends JpaDao<Camion> implements CamionDao {
    private static JpaCamionDao instance = new JpaCamionDao();

    private JpaCamionDao() {
    }

    protected static JpaCamionDao getInstance(){
        if(instance == null){
            instance = new JpaCamionDao();
        }
        return instance;
    }

    @Override
    public Camion find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Camion> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
