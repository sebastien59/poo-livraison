/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Point;

/**
 *
 * @author sebastien
 */
public class JpaPointDao extends JpaDao<Point> implements PointDao {
    private static JpaPointDao instance = new JpaPointDao();

    private JpaPointDao() {
    }

    protected static JpaPointDao getInstance(){
        if(instance == null){
            instance = new JpaPointDao();
        }
        return instance;
    }

    @Override
    public Point find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Point> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
