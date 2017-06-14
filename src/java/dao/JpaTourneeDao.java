/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Tournee;

/**
 *
 * @author sebastien
 */
public class JpaTourneeDao extends JpaDao<Tournee> implements TourneeDao {
    private static JpaTourneeDao instance = new JpaTourneeDao();

    private JpaTourneeDao() {
    }

    protected static JpaTourneeDao getInstance(){
        if(instance == null){
            instance = new JpaTourneeDao();
        }
        return instance;
    }

    @Override
    public Tournee find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Tournee> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
