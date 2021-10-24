package controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entitys.Banda;
import model.entitys.Local;
import model.entitys.Show;
import model.services.BandaService;
import model.services.LocalService;
import model.services.ShowService;


@WebServlet("/FormControlShows")
public class FormControllShows extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ShowService showService = new ShowService();
	BandaService bandaService = new BandaService();

    public FormControllShows() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		
		LocalService localserService = new LocalService();
		
		List<Local> locais = localserService.listarLocais();
		List<Banda> bandas = bandaService.listarBandas();
		
		if(operation.equals("novo")) {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = new Date();
			
			request.setAttribute("titulo", "Criar");
			request.setAttribute("selected", "-selecione-");
			request.setAttribute("dataDefault", dateFormat.format(date)+"");
			request.setAttribute("txtBotao", "Adicionar");
			request.setAttribute("locais", locais);
			request.setAttribute("bandas", bandas);
			request.setAttribute("actionForm", "shows/insert");

			RequestDispatcher rd = request.getRequestDispatcher("formularioShows.jsp");
			rd.forward(request, response);
		}else if(operation.equals("editar")){
			
			Long idShow = Long.parseLong(request.getParameter("idShow"));
		
			Show show = showService.procurarShow(idShow);
			
					
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
			String dataFormat = formatDate.format(show.getData().getTime());
			
			request.setAttribute("titulo", "Editar");
			request.setAttribute("selected", show.getLocal_do_show().getId());
			request.setAttribute("dataDefault", dataFormat);
			request.setAttribute("txtBotao", "Alterar");
			request.setAttribute("locais", locais);
			request.setAttribute("bandas", bandas);
			request.setAttribute("show", show);

			request.setAttribute("actionForm", "shows/update");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("formularioShows.jsp");
			rd.forward(request, response);
			
			
		} else {
			response.sendRedirect("ListarBandas");
		}
		
	}

}
