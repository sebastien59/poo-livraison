/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author sebastien
 */
public abstract class DaoFactory {
    	public abstract JpaArcDao getArcDao();
		public abstract JpaCamionDao getCamionDao();
		public abstract JpaClientDao getClientDao();
		public abstract JpaConstanteDao getConstanteDao();
		public abstract JpaDepotDao getDepotDao();
		public abstract JpaPointDao getPointDao();
		public abstract JpaSolutionDao getSolutionDao();
		public abstract JpaSwapbodyDao getSwapbodyDao();
		public abstract JpaSwaplocationDao getSwaplocationDao();
		public abstract JpaTourneeDao getTourneeDao();
		public abstract JpaTrainDao getTrainDao();
		public abstract JpaVehiculeDao getVehiculeDao();
	

    public static DaoFactory getDaoFactory (PersistenceType type){
        switch(type){
            case JPA:
            default:
                return new DaoFactoryJpa();
        }
    }
}
