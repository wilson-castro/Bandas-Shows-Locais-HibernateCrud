package utils;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.daos.DaoFactory;

@SuppressWarnings("unchecked")
public abstract class GenericDao<T ,PK> {
	
	private final EntityManager entityManager;
	private final EntityManagerFactory factory;
	
	private Class<?> clazz;
	
	//////// CONSTRUCTOR //////////
	
	public GenericDao() {
		this(DaoFactory.entityManagerFactoryInstance());
	}
	
	public GenericDao(EntityManagerFactory factory) {
		this.factory = factory;
		this.entityManager = factory.createEntityManager();
		this.clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	////// CRUD METHODS ///////
	
	public Object executeQuery(String query, Object... params) {
		Query createdQuery = this.entityManager.createQuery(query);
		
		for(int i = 0;i < params.length; i++) {
			createdQuery.setParameter(i, params[i]);
		}
		
		return createdQuery.getResultList();
		
	}
	
	public List<T> findAll(){
		return this.getEntityManager().createQuery(("FROM "+ this.clazz.getName()))
				.getResultList();
	}
	
	public T findById(PK pk) {
		return (T) this.entityManager.find(this.clazz, pk);
	}
	
	public void save(T entity) {
		try {
			this.beginTransaction();
			this.entityManager.persist(entity);
			this.commit();
		}catch(Exception e) {
			this.rollBack();
			throw e;
		}
	}
	
	public void update(T entity) {
		try {
			this.beginTransaction();
			this.entityManager.merge(entity);
			this.commit();
		}catch(Exception e) {
			this.rollBack();
			throw e;
		}
	}
	
	public void delete(T entity) {
		try {
			this.beginTransaction();
			this.entityManager.remove(entity);
			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
		
	}
	
	///// TRANSACTION METHODS //////
	
	public void beginTransaction() {
		this.entityManager.getTransaction().begin();
	}
	
	public void commit() {
		this.entityManager.getTransaction().commit();
	}
	
	public void close() {
		this.entityManager.close();
		this.factory.close();
	}
	
	public void rollBack() {
		this.entityManager.getTransaction().rollback();
	}
	
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
}
