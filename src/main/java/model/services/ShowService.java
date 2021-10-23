package model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.daos.DaoFactory;
import model.daos.ShowDao;
import model.entitys.Show;

public class ShowService {
	private ShowDao dao;
	
	public ShowService() {
		this.dao = DaoFactory.ShowDaoInstance();
	}
	
	public void salvar(Show shwo) {
		dao.save(shwo);
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
}
