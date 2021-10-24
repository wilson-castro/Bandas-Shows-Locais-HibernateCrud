package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entitys.Show;
import model.services.ShowService;

@WebServlet("/ListarShows")
public class ListarShows extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ShowService showService = new ShowService();
	
	  public ListarShows() {
	      super();
	  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Show> shows = showService.listarShows();
		
		request.setAttribute("shows", shows);
		RequestDispatcher rd = request.getRequestDispatcher("tabelaShows.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nomeLugar");
				
		List<Show> shows = showService.listarShowsPorNomeDoLocal(nome);
		
		request.setAttribute("shows", shows);
		RequestDispatcher rd = request.getRequestDispatcher("tabelaShows.jsp");
		rd.forward(request, response);
		
	}

}

