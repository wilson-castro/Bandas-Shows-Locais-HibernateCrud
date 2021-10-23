package model.services;

import java.util.ArrayList;
import java.util.List;

import model.daos.BandaDao;
import model.daos.DaoFactory;
import model.entitys.Banda;
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
		List<Banda> bandas = dao.findBandaByNameAndKind(nome, generos);
		
		return bandas;
	}
}
