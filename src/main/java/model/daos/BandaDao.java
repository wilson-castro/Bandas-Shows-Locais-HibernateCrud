package model.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.entitys.Banda;
import model.enums.Genero;
import utils.GenericDao;

public class BandaDao extends GenericDao<Banda, Long> {

	
	@SuppressWarnings("unchecked")
	public List<Banda> findBandaByName(String bandaNome){
		String query = "SELECT b FROM Banda b WHERE nome LIKE ?0 ";
		
		Query createdQuery = this.getEntityManager().createQuery(query);
		
		createdQuery.setParameter(0, "%"+bandaNome+"%");
				
		List<Banda> bandas = (List<Banda>) createdQuery.getResultList();
		
		return bandas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Banda> findBanaByNameInKinds(String bandaNome, ArrayList<Genero> generos){
		String query = "SELECT b FROM Banda b WHERE nome LIKE ?0 AND genero IN (?1)";
		
		Query createdQuery = this.getEntityManager().createQuery(query);
		createdQuery.setParameter(0, "%"+bandaNome+"%");
		createdQuery.setParameter(1, generos);
		
		List<Banda> bandas = (List<Banda>) createdQuery.getResultList();
		
		return bandas;
	}
}
