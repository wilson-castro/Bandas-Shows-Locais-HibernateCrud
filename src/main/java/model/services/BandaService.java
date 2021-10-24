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
	
	public void salvar(Banda banda, int[] showsIds) {

		List<Show> shows = new ArrayList<Show>();

		for (int i = 0; i < showsIds.length; i++) {
			ShowService showService = new ShowService();
			Show show = showService.procurarShow((long) showsIds[i]);

			shows.add(show);
		}

		banda.setShows(shows);

		salvar(banda);

	}
	
	public List<Banda> listarBandas(){
		List<Banda> bandas = dao.findAll();
		
		return bandas;
	}
	
	public List<Banda> listarBandaPorNomeEGenero(String nome, ArrayList<Genero> generos){
		List<Banda> bandas = dao.findBandaByNameAndKind(nome, generos);
		
		return bandas;
	}
	
	public void removerBanda(Long idBanda) {
		Banda banda = procurarBanda(idBanda);
		
		dao.delete(banda);
	}
	
	
	public void alterarBanda(Banda banda) {		
		dao.update(banda);
	}
	
	public void alterarBanda(Banda banda , int[] showsIds) {

		List<Show> shows = new ArrayList<Show>();

		for (int i = 0; i < showsIds.length; i++) {
			ShowService showService = new ShowService();
			Show show = showService.procurarShow((long) showsIds[i]);

			shows.add(show);
		}

		banda.setShows(shows);

		alterarBanda(banda);

	}
	
	public Banda procurarBanda(Long idBanda) {
		
		return dao.findById(idBanda);
	}
}
