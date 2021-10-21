package model.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class DaoFactory {
	
	private DaoFactory() {}
	
	//// ENTITY MANAGER FACTORY ////
	
	private static final String  PERSISTENCE_UNIT_NAME = "projeto_JPA";
	
	private static EntityManagerFactory entityManagerFactoryInstance;
	
	public static EntityManagerFactory entityManagerFactoryInstance() {
		if (entityManagerFactoryInstance == null) {
			entityManagerFactoryInstance = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		
		return entityManagerFactoryInstance;
	}
}
