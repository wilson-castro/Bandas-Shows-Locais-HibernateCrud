package model.services;

import java.util.ArrayList;
import java.util.List;

import model.daos.BandaDao;
import model.daos.DaoFactory;
import model.entitys.Banda;
import model.entitys.Show;
import model.enums.Genero;

public class BandaService {
	private BandaDao dao;
	
	public BandaService() {
		this.dao = DaoFactory.bandaDaoInstance();
	}
	
	public void salvar(Banda banda) {
		dao.save(banda);
	}
	
	public List<Banda> listarBandas(){
		List<Banda> bandas = dao.findAll();
		
		return bandas;
	}
	
	public List<Banda> listarBandaPorNomeEGenero(String nome, ArrayList<Genero> generos){
		List<Banda> bandas = new ArrayList<Banda>();
		
		if (generos==null) {
			bandas = dao.findBandaByName(nome);

		}else {
		    bandas = dao.findBanaByNameInKinds(nome, generos);
		}
		return bandas;
	}
	
	public void removerBanda(Long idBanda) {
		Banda banda = procurarBanda(idBanda);
		
		if (banda.getShows() != null) {			
			for(Show show : banda.getShows()) {				
				ShowService showService= new ShowService();
				
				show.getBandas().remove(banda);
				
				showService.alterarShow(show);
				
			}
		}
		
		dao.delete(banda);
	}
	
	public void alterarBanda(Banda banda) {		
		dao.update(banda);
	}
	
	public Banda procurarBanda(Long idBanda) {
		
		return dao.findById(idBanda);
	}
}
