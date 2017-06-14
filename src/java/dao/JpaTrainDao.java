/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Train;

/**
 *
 * @author sebastien
 */
public class JpaTrainDao extends JpaDao<Train> implements TrainDao {
    private static JpaTrainDao instance = new JpaTrainDao();

    private JpaTrainDao() {
    }

    protected static JpaTrainDao getInstance(){
        if(instance == null){
            instance = new JpaTrainDao();
        }
        return instance;
    }

    @Override
    public Train find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Train> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
