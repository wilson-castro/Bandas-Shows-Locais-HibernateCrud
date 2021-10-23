package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entitys.Banda;
import model.enums.Genero;
import model.services.BandaService;

@WebServlet("/ListarBandas")
public class ListarBandas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BandaService bandaService = new BandaService();
	
    public ListarBandas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Banda> bandas = bandaService.listarBandas();

		request.setAttribute("bandas", bandas);
		RequestDispatcher rd = request.getRequestDispatcher("tabelaBandas.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		
		if (request.getParameterValues("listGeneros") == null ) {
			
			List<Banda> bandas = bandaService.listarBandaPorNomeEGenero(nome, null);
			
			request.setAttribute("bandas", bandas);
			RequestDispatcher rd = request.getRequestDispatcher("tabelaBandas.jsp");
			rd.forward(request, response);
			
		}else {
			String[] checkboxlistGeneros = request.getParameterValues("listGeneros");
			int qtdGeneros = checkboxlistGeneros.length;
			
			ArrayList<Genero> generos = new ArrayList<Genero>();
						
			for (int i = 0; i < qtdGeneros; i++) {
			generos.add(Genero.valueOf(checkboxlistGeneros[i]));
			}
			
			List<Banda> bandas = bandaService.listarBandaPorNomeEGenero(nome, generos);
			
			request.setAttribute("bandas", bandas);
			RequestDispatcher rd = request.getRequestDispatcher("tabelaBandas.jsp");
			rd.forward(request, response);
		}
		
	}


}
