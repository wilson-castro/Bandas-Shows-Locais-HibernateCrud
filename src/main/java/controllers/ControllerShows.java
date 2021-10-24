package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entitys.Local;
import model.entitys.Show;
import model.services.LocalService;
import model.services.ShowService;

@WebServlet(urlPatterns = { "/ControllerShows", "/shows","/shows/delete","/shows/insert",
		"/shows/select","/shows/update" })
public class ControllerShows extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ShowService showService = new ShowService();

    public ControllerShows() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		if (action.equals("/shows")) {
			shows(request, response);
		}else if (action.equals("/shows/insert")) {
			novoShow(request, response);
		}else if(action.equals("/shows/delete")) {
			removerShow(request, response);
		}else if(action.equals("/shows/update")) {
			editarShow(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
	}
	
	protected void shows(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/ListarShows");
		rd.forward(request, response);

	}
	
	protected void novoShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LocalService localService = new LocalService();
		
		String data =  request.getParameter("data");
		Long idLocal = Long.parseLong(request.getParameter("selectLocais"));
		
		Show show = new Show();
		Local local = localService.procurarLocal(idLocal);
		
		show.setLocal_do_show(local);
		
		if (request.getParameterValues("List_BandaIDs") == null ) {
				showService.salvarShowComDataString(show, data);			
		}else {
			String[] checkboxIdsList = request.getParameterValues("List_BandaIDs");
			int size = checkboxIdsList.length;
						
			int[] idsList = new int[size];
			
			for (int i = 0; i < size; i++) {
			    idsList[i] = Integer.parseInt(checkboxIdsList[i]);
			}
			
			showService.salvarShowComDataString(show,data, idsList);
		}
		
		response.sendRedirect("/HibernateCrud/shows");
	}
	protected void editarShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idShow = Long.parseLong(request.getParameter("idShow"));
		LocalService localService = new LocalService();
		
		Show show = showService.procurarShow(idShow);
				
		String data =  request.getParameter("data");
		Long idLocal = Long.parseLong(request.getParameter("selectLocais"));
		
		Local local = localService.procurarLocal(idLocal);
		
		show.setLocal_do_show(local);

		if (request.getParameterValues("List_BandaIDs") == null ) {
			showService.salvarShowComDataString(show, data);
						
		}else {
			String[] checkboxIdsList = request.getParameterValues("List_BandaIDs");
			int size = checkboxIdsList.length;
						
			int[] idsList = new int[size];
			
			for (int i = 0; i < size; i++) {
			    idsList[i] = Integer.parseInt(checkboxIdsList[i]);
			}
			showService.salvarShowComDataString(show, data, idsList);
		}
		
		response.sendRedirect("/HibernateCrud/shows");
	}
	
	protected void removerShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idShow = Long.parseLong(request.getParameter("idShow"));		
	
		showService.removerShow(idShow);
			
		response.sendRedirect("/HibernateCrud/shows");

	}

}
