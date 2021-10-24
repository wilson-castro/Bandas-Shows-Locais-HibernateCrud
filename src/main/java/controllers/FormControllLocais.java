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
import model.entitys.Show;
import model.services.LocalService;
import model.services.ShowService;


@WebServlet("/FormControlLocais")
public class FormControllLocais extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LocalService localService = new LocalService();

    public FormControllLocais() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		ShowService showService = new ShowService();
		
		List<Show> shows = showService.listarShows();

		request.setAttribute("shows", shows);
		
		if(operation.equals("novo")) {
						
			
			request.setAttribute("titulo", "Criar");
			request.setAttribute("txtBotao", "Adicionar");
			request.setAttribute("actionForm", "locais/insert");
			request.setAttribute("textoInputNome", "");
			request.setAttribute("textoInputCapacidade", "1");
			request.setAttribute("defaultInput", "Digite um nome...");
			
			RequestDispatcher rd = request.getRequestDispatcher("formularioLocais.jsp");
			rd.forward(request, response);
		}else if(operation.equals("editar")){
			Long idLocal = Long.parseLong(request.getParameter("idLocal")); 
			
			Local local = localService.procurarLocal(idLocal);			
		
			request.setAttribute("titulo", "Editar");
			request.setAttribute("txtBotao", "Alterar");
			request.setAttribute("actionForm", "locais/update");
			request.setAttribute("textoInputNome", local.getNome());
			request.setAttribute("textoInputCapacidade", local.getCapacidade());
			request.setAttribute("defaultInput", "");
			request.setAttribute("shows", shows);
			request.setAttribute("local", local);
			
			RequestDispatcher rd = request.getRequestDispatcher("formularioLocais.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("ListarLocais");
		}
	}

}
