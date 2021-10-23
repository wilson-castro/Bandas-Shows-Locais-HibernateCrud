package model.daos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class DaoFactory {
	
	private DaoFactory() {}
	
	////// ENTITY MANAGER FACTORY //////
	
	private static final String  PERSISTENCE_UNIT_NAME = "projeto_JPA";
	
	private static EntityManagerFactory entityManagerFactoryInstance;
	
	public static EntityManagerFactory entityManagerFactoryInstance() {
		if (entityManagerFactoryInstance == null) {
			entityManagerFactoryInstance = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		
		return entityManagerFactoryInstance;
	}
	
	////// BANDA FACTORY /////
	
	private static BandaDao bandaDaoInstance;
	
	public static BandaDao bandaDaoInstance(){
		if (bandaDaoInstance == null) {
			bandaDaoInstance = new BandaDao();
		}
		
		return bandaDaoInstance;
	}
	
	////// LOCAL FACTORY /////
	
	private static LocalDao LocalDaoInstance;
	
	public static LocalDao LocalDaoInstance(){
		if (LocalDaoInstance == null) {
			LocalDaoInstance = new LocalDao();
		}
		
		return LocalDaoInstance;
	}
	
	////// SHOW FACTORY /////
	
	private static ShowDao ShowDaoInstance;
	
	public static ShowDao ShowDaoInstance(){
		if (ShowDaoInstance == null) {
			ShowDaoInstance = new ShowDao();
		}
		
		return ShowDaoInstance;
	}
}
