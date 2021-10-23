package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entitys.Local;
import model.services.LocalService;


@WebServlet("/ListarLocais")
public class ListarLocais extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LocalService localService = new LocalService();

    public ListarLocais() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		List<Local> locais = localService.listarLocais();
		 
		request.setAttribute("locais", locais);
		RequestDispatcher rd = request.getRequestDispatcher("tabelaLocais.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nomeLugar");
				
		List<Local> locais = localService.listarLocaisPorNome(nome);
		 
		request.setAttribute("locais", locais);
		RequestDispatcher rd = request.getRequestDispatcher("tabelaLocais.jsp");
		rd.forward(request, response);
	}

}