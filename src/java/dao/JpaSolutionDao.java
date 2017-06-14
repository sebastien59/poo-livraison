/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Solution;

/**
 *
 * @author sebastien
 */
public class JpaSolutionDao extends JpaDao<Solution> implements SolutionDao {
    private static JpaSolutionDao instance = new JpaSolutionDao();

    private JpaSolutionDao() {
    }

    protected static JpaSolutionDao getInstance(){
        if(instance == null){
            instance = new JpaSolutionDao();
        }
        return instance;
    }

    @Override
    public Solution find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Solution> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
