/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metierDao;
import dao.DaoFactory;
import dao.PersistenceType;
import static dao.PersistenceType.JPA;
import dao.SolutionDao;
import models.*;
/**
 *
 * @author Loïc
 */
public class Tests {
    public static void main(String[] args) {
        PersistenceType type = JPA;
        
        SolutionDao SolutionManager = DaoFactory.getDaoFactory(type).getSolutionDao();
    }
}
