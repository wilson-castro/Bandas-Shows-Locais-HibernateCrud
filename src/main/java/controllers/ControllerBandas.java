package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.daos.BandaDao;
import model.services.BandaService;

@WebServlet(urlPatterns = { "/ControllerBandas", "/bandas", "/bandas/insert", "/bandas/select", "/bandas/update",
		"/bandas/delete" })
public class ControllerBandas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BandaService service = new BandaService();
	
	public ControllerBandas() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		if (action.equals("/bandas")) {
			bandas(request, response);
		} else if (action.equals("/bandas/insert")) {
			novaBanda(request, response);
		} else if (action.equals("/bandas/update")) {
			editarBanda(request, response);
		} else if (action.equals("/bandas/delete")) {
			removerBanda(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void bandas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/ListarBandas");
		rd.forward(request, response);

	}

	protected void editarBanda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*Banda banda = new Banda();

		int idBanda = Integer.parseInt(request.getParameter("idBanda"));
		String nome = request.getParameter("nome");
		String generoString = request.getParameter("selectGeneros");
		Genero genero = Genero.valueOf(generoString);

		banda.setIdBanda(idBanda);
		banda.setGenero(genero);
		banda.setNome(nome);*/

		if (request.getParameterValues("List_ShowsIDs") == null) {
		//	dao.alterarBanda(banda, null);

		} else {
			/*String[] checkboxIdsList = request.getParameterValues("List_ShowsIDs");
			int size = checkboxIdsList.length;

			int[] idsList = new int[size];

			for (int i = 0; i < size; i++) {
				idsList[i] = Integer.parseInt(checkboxIdsList[i]);
			}
			dao.alterarBanda(banda, idsList);*/
		}

		response.sendRedirect("/HibernateCrud/bandas");
	}

	protected void novaBanda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	Banda banda = new Banda();

		String nome = request.getParameter("nome");
		String generoString = request.getParameter("selectGeneros");
		Genero genero = Genero.valueOf(generoString);

		banda.setGenero(genero);
		banda.setNome(nome);*/

		if (request.getParameterValues("List_ShowsIDs") == null) {
		//	dao.adicionarBanda(banda, null);

		} else {
		/*	String[] checkboxIdsList = request.getParameterValues("List_ShowsIDs");
			int size = checkboxIdsList.length;

			int[] idsList = new int[size];

			for (int i = 0; i < size; i++) {
				idsList[i] = Integer.parseInt(checkboxIdsList[i]);
			}
			dao.adicionarBanda(banda, idsList);*/
		}

		response.sendRedirect("/HibernateCrud/bandas");
	}

	protected void removerBanda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idBanda = Long.parseLong(request.getParameter("idBanda"));

		service.removerBanda(idBanda);
		
		response.sendRedirect("/HibernateCrud/bandas");

	}

}
