package model.services;

import java.util.ArrayList;
import java.util.List;

import model.daos.DaoFactory;
import model.daos.LocalDao;
import model.entitys.Local;
import model.entitys.Show;

public class LocalService {
private LocalDao dao;
	
	public LocalService() {
		this.dao = DaoFactory.LocalDaoInstance();
	}
	
	public void salvar(Local local) {
		dao.save(local);
	}
	
	public void salvar(Local local,int[] listShowsIds) {
		List<Show> shows = new ArrayList<Show>();
		ShowService showService = new ShowService();
		
		for(int i=0; i<listShowsIds.length; i++) {
			Show show = showService.procurarShow((long) listShowsIds[i]);
			shows.add(show);
		}
		
		local.setShows(shows);
		
		dao.save(local);
	}
	
	public List<Local> listarLocais(){
		List<Local> locais = dao.findAll();
		
		return locais;
	}
	
	public List<Local> listarLocaisPorNome(String nome){
		List<Local> locais = dao.findLocalByName(nome);
		
		return locais;
	}
	
	public void removerLocal(Long idLocal) {
		Local local = procurarLocal(idLocal);
		
		dao.delete(local);

	}
	
	public Local procurarLocal(Long idLocal) {
		
		return dao.findById(idLocal);
	}
}
