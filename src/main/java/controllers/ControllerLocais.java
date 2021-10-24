package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entitys.Local;
import model.services.LocalService;


@WebServlet(urlPatterns = { "/ControllerLocais", "/locais","/locais/delete","/locais/insert",
		"/locais/select","/locais/update" })
public class ControllerLocais extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LocalService localService = new LocalService();
	
    public ControllerLocais() {
        super();
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		if (action.equals("/locais")) {
			locais(request, response);
		}else if (action.equals("/locais/insert")) {
			novoLocal(request, response);
		}else if(action.equals("/locais/update")) {
			editarLocal(request, response);
		}else if(action.equals("/locais/delete")) {
			removerLocal(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void locais(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/ListarLocais");
		rd.forward(request, response);

	}
	
	protected void novoLocal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Local local = new Local();
		
		String nome =  request.getParameter("nome");
		int capacidade = Integer.parseInt(request.getParameter("capacidade"));
		
		local.setNome(nome);
		local.setCapacidade(capacidade);

		if (request.getParameterValues("List_ShowsIDs") == null ) {
			localService.salvar(local);
						
		}else {
			String[] checkboxIdsList = request.getParameterValues("List_ShowsIDs");
			int size = checkboxIdsList.length;
						
			int[] idsList = new int[size];
			
			for (int i = 0; i < size; i++) {
			    idsList[i] = Integer.parseInt(checkboxIdsList[i]);
			}
			localService.salvar(local, idsList);
		}
		
		response.sendRedirect("/HibernateCrud/locais");
	}
	
	protected void editarLocal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idLocal = Long.parseLong(request.getParameter("idLocal"));
		Local local = localService.procurarLocal(idLocal);
		
		String nome =  request.getParameter("nome");
		int capacidade = Integer.parseInt(request.getParameter("capacidade"));

		local.setNome(nome);
		local.setCapacidade(capacidade);
		
		if (request.getParameterValues("List_ShowsIDs") == null ) {
			localService.alterarLocal(local);
						
		}else {
			String[] checkboxIdsList = request.getParameterValues("List_ShowsIDs");
			int size = checkboxIdsList.length;
						
			int[] idsList = new int[size];
			
			for (int i = 0; i < size; i++) {
			    idsList[i] = Integer.parseInt(checkboxIdsList[i]);
			}
			localService.alterarLocal(local, idsList);
		}
		
		response.sendRedirect("/HibernateCrud/locais");
	}
	
	protected void removerLocal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idLocal = Long.parseLong(request.getParameter("idLocal"));
		
		localService.removerLocal(idLocal);
		
		response.sendRedirect("/HibernateCrud/locais");

	}
 
}
