package model.services;

import java.util.List;

import model.daos.DaoFactory;
import model.daos.LocalDao;
import model.entitys.Local;

public class LocalService {
private LocalDao dao;
	
	public LocalService() {
		this.dao = DaoFactory.LocalDaoInstance();
	}
	
	public void salvar(Local local) {
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
	
	public void alterarLocal(Local local) {
		dao.update(local);
		
	}
	
	public Local procurarLocal(Long idLocal) {
		
		return dao.findById(idLocal);
	}
}
