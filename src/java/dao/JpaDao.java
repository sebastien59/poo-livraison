/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author sebastien
 */
public abstract class JpaDao<T> implements Dao<T>{
    final EntityManagerFactory emf;
    final EntityManager em;

    public JpaDao() {
        this.emf = Persistence.createEntityManagerFactory("ProjetPooPU");
        this.em = emf.createEntityManager();
    }

    @Override
    public boolean create(Object obj){
        final EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(obj);
            et.commit();
            return true;
        }catch (Exception ex) {
            et.rollback();
        }

        return false;
    }

    @Override
    public boolean update (T obj){
        final EntityTransaction et = em.getTransaction();

        try{
            et.begin();
            em.merge(obj);
            et.commit();
            return true;
        }catch (Exception ex) {
            et.rollback();
        }

        return false;
    }

    @Override
    public boolean delete (T obj){
        final EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.remove(obj);
            et.commit();
            return true;
        }catch (Exception ex) {
            et.rollback();
        }
        return false;
    }

    @Override
    public void close(){
        if(em != null && em.isOpen()){
            em.close();
        }
        if(emf != null && emf.isOpen()){
            emf.close();
        }
    }
}
