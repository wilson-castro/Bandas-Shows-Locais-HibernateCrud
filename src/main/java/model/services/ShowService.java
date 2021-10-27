package model.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.daos.ShowDao;
import model.entitys.Banda;
import model.entitys.Show;

public class ShowService {
	private ShowDao dao;

	public ShowService() {
		this.dao = new ShowDao();
	}

	public void salvar(Show show) {
		dao.save(show);
	}

	public void salvarShowComDataString(Show show, String data) {

		Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = new java.sql.Date( ((Date)formatter.parse(data)).getTime() );
        } catch (ParseException e) {            
            e.printStackTrace();
        }
        
		show.setData(date);
		salvar(show);

	}

	public void salvarShowComDataString(Show show, String data, int[] bandasIds) {

		Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = new java.sql.Date( ((Date)formatter.parse(data)).getTime() );
        } catch (ParseException e) {            
            e.printStackTrace();
        }
        
		show.setData(date);

		List<Banda> bandas = new ArrayList<Banda>();

		for (int i = 0; i < bandasIds.length; i++) {
			BandaService bandaService = new BandaService();
			Banda banda = bandaService.procurarBanda((long) bandasIds[i]);

			bandas.add(banda);
		}

		show.setBandas(bandas);

		salvar(show);

	}

	public List<Show> listarShows() {
		List<Show> shows = dao.findAll();

		return shows;
	}

	public List<Show> listarShowsPorNomeDoLocal(String nomeLocal) {
		List<Show> shows = dao.findAll();
		List<Show> showsFiltrados = new ArrayList<Show>();

		for (Show show : shows) {
			if (show.getLocal_do_show().getNome().contains(nomeLocal)) {
				showsFiltrados.add(show);
			}
		}

		return showsFiltrados;
	}

	public void alterarShow(Show show) {
		dao.update(show);
	}

	public void alterarShow(Show show, String data) {
		Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = new java.sql.Date( ((Date)formatter.parse(data)).getTime() );
        } catch (ParseException e) {            
            e.printStackTrace();
        }
        
		show.setData(date);
		alterarShow(show);

	}

	public void alterarShow(Show show, String data, int[] bandasIds) {
		Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = new java.sql.Date( ((Date)formatter.parse(data)).getTime() );
        } catch (ParseException e) {            
            e.printStackTrace();
        }

		show.setData(date);

		List<Banda> bandas = new ArrayList<Banda>();

		for (int i = 0; i < bandasIds.length; i++) {
			BandaService bandaService = new BandaService();
			Banda banda = bandaService.procurarBanda((long) bandasIds[i]);

			bandas.add(banda);
		}

		show.setBandas(bandas);

		alterarShow(show);

	}

	public void removerShow(Long idLocal) {
		Show show = procurarShow(idLocal);

		dao.delete(show);

	}

	public Show procurarShow(Long idShow) {

		return dao.findById(idShow);
	}
}
