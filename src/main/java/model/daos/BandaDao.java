package model.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.entitys.Banda;
import model.enums.Genero;
import utils.GenericDao;

public class BandaDao extends GenericDao<Banda, Long> {
	
	@SuppressWarnings("unchecked")
	public List<Banda> findBandaByNameAndKind(String bandaNome, ArrayList<Genero> generos){
		String query = "SELECT b FROM Banda b WHERE nome LIKE ?0 ";
				
		if (generos != null) {
			int size = generos.size();
			
			query+=" AND ( ";
			
			for (int i = 0; i<size ;i++) {
				query+= "genero=?"+(i+1);
				query+= generos.lastIndexOf(generos.get(i)) < size-1? " OR " : ""; 
			}
			
			query+=" )";
		}
		
		Query createdQuery = this.getEntityManager().createQuery(query);
		
		createdQuery.setParameter(0, "%"+bandaNome+"%");
				
		if (generos != null) {
			for(int i = 0;i < generos.size(); i++) {
				createdQuery.setParameter(i+1, generos.get(i));
			}
		}
		
		List<Banda> bandas = (List<Banda>) createdQuery.getResultList();
		
		return bandas;
	}
}
