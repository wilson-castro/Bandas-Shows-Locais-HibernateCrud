package model.daos;

import java.util.List;

import model.entitys.Local;
import utils.GenericDao;

public class LocalDao extends GenericDao<Local, Long> {
	
	@SuppressWarnings("unchecked")
	public List<Local> findLocalByName(String name){
		String query = "SELECT l FROM Local l WHERE nome LIKE ?0";
		
		List<Local> locais = (List<Local>) this.executeQuery(query, "%"+name+"%");
		
		return locais;
	}
}
