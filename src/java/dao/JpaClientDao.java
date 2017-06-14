/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import models.Client;

/**
 *
 * @author sebastien
 */
public class JpaClientDao extends JpaDao<Client> implements ClientDao {
    private static JpaClientDao instance = new JpaClientDao();

    private JpaClientDao() {
    }

    protected static JpaClientDao getInstance(){
        if(instance == null){
            instance = new JpaClientDao();
        }
        return instance;
    }

    @Override
    public Client find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Client> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
