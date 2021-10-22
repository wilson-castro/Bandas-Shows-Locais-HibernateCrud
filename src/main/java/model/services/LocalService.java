package model.services;

import model.daos.LocalDao;
import model.entitys.Local;

public class LocalService {
private LocalDao dao;
	
	public LocalService() {
		this.dao = new LocalDao();
	}
	
	public void salvar(Local local) {
		dao.save(local);
	}
}
