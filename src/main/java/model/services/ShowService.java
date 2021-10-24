package model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.daos.DaoFactory;
import model.daos.ShowDao;
import model.entitys.Show;

public class ShowService {
	private ShowDao dao;
	
	public ShowService() {
		this.dao = DaoFactory.ShowDaoInstance();
	}
	
	public void salvar(Show show) {
		dao.save(show);
	}
	
	public void salvarShowComDataString(Show show, String data_show) throws ParseException {
		Calendar dataConvertida = null;	
		
		try {
            Date date = new SimpleDateFormat("yyyy-MM-dd")
                  .parse(data_show);
            dataConvertida = Calendar.getInstance();
            dataConvertida.setTime(date);
            
            show.setData(dataConvertida);
            salvar(show);
            
        } catch (ParseException e) {
            System.out.println("Erro de conversão da data");
            throw e;

		}
		
	}
	
	public List<Show> listarShows(){
		List<Show> shows = dao.findAll();
		
		return shows;
	}
	
	public List<Show> listarShowsPorNomeDoLocal(String nomeLocal){
		List<Show> shows = dao.findAll();
		List<Show> showsFiltrados = new ArrayList<Show>();
		
		for (Show show : shows) {
			if (show.getLocal_do_show().getNome().contains(nomeLocal)) {
				showsFiltrados.add(show);
			}
		}
		
		return showsFiltrados;
	}
	
	public void removerShow(Long idLocal) {
		Show show  =procurarShow(idLocal);
		
		dao.delete(show);
		
	}
	
	public Show procurarShow(Long idShow) {
		
		return dao.findById(idShow);
	}
}
