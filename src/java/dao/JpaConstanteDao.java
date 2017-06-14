/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Constante;

/**
 *
 * @author sebastien
 */
public class JpaConstanteDao extends JpaDao<Constante> implements ConstanteDao {
    private static JpaConstanteDao instance = new JpaConstanteDao();

    private JpaConstanteDao() {
    }

    protected static JpaConstanteDao getInstance(){
        if(instance == null){
            instance = new JpaConstanteDao();
        }
        return instance;
    }

    @Override
    public Constante find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Constante> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
