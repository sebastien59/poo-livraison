/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import javax.persistence.Query;
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
        Query q = em.createNamedQuery("Solution.findByIdsolution");
        q.setParameter("idSolution", id);
        q.setMaxResults(1);
        return (Solution) q.getSingleResult();
    }

    @Override
    public Collection<Solution> findAll() {
        Query q = em.createNamedQuery("Solution.findAll");
        return q.getResultList();
    }
    
    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
