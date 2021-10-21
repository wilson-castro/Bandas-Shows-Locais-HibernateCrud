package model.daos;

import java.util.List;

import model.entitys.Banda;
import model.enums.Genero;
import utils.GenericDao;

public class BandaDao extends GenericDao<Banda, Long> {
	
	@SuppressWarnings("unchecked")
	public List<Banda> findBandaByNameAndKind(String bandaNome, Genero[] generos){
		String query = "SELECT b FROM Banda b WHERE b.nome= ?0";
		
		List<Banda> bandas = (List<Banda>) this.executeQuery(query, bandaNome);
		
		return bandas;
	}
}
