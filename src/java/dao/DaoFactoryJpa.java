/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.DaoFactory;
/**
 *
 * @author sebastien
 */
public class DaoFactoryJpa extends DaoFactory{
  
		@Override
 		public JpaArcDao getArcDao(){
 			return JpaArcDao.getInstance();
 		}
 
		@Override
 		public JpaCamionDao getCamionDao(){
 			return JpaCamionDao.getInstance();
 		}
 
		@Override
 		public JpaClientDao getClientDao(){
 			return JpaClientDao.getInstance();
 		}
 
		@Override
 		public JpaConstanteDao getConstanteDao(){
 			return JpaConstanteDao.getInstance();
 		}
 
		@Override
 		public JpaDepotDao getDepotDao(){
 			return JpaDepotDao.getInstance();
 		}
 
		@Override
 		public JpaPointDao getPointDao(){
 			return JpaPointDao.getInstance();
 		}
 
		@Override
 		public JpaSolutionDao getSolutionDao(){
 			return JpaSolutionDao.getInstance();
 		}
 
		@Override
 		public JpaSwapbodyDao getSwapbodyDao(){
 			return JpaSwapbodyDao.getInstance();
 		}
 
		@Override
 		public JpaSwaplocationDao getSwaplocationDao(){
 			return JpaSwaplocationDao.getInstance();
 		}
 
		@Override
 		public JpaTourneeDao getTourneeDao(){
 			return JpaTourneeDao.getInstance();
 		}
 
		@Override
 		public JpaTrainDao getTrainDao(){
 			return JpaTrainDao.getInstance();
 		}
 
		@Override
 		public JpaVehiculeDao getVehiculeDao(){
 			return JpaVehiculeDao.getInstance();
 		}
 
}
