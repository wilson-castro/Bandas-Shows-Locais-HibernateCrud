package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entitys.Banda;
import model.entitys.Show;
import model.services.BandaService;
import model.services.ShowService;


@WebServlet("/FormControlBandas")
public class FormControllBandas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BandaService bandaService = new BandaService();
    
   
    public FormControllBandas() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		ShowService showService  =new ShowService();
		
		List<Show> shows = showService.listarShows();
		
		if(operation.equals("novo")) {
						
			request.setAttribute("titulo", "Criar");
			request.setAttribute("defaultInput", "Digite um nome...");
			request.setAttribute("selected", "-selecione-");
			request.setAttribute("txtBotao", "Adicionar");
			request.setAttribute("textoInputNome", "");
			request.setAttribute("actionForm", "bandas/insert");
			request.setAttribute("shows", shows);
			
			RequestDispatcher rd = request.getRequestDispatcher("formularioBandas.jsp");
			rd.forward(request, response);
		}else if(operation.equals("editar")){
			Long idBanda = Long.parseLong(request.getParameter("idBanda"));
			
			Banda banda = bandaService.procurarBanda(idBanda);
        	
			request.setAttribute("titulo", "Editar");
			request.setAttribute("defaultInput", "");
			request.setAttribute("selected", banda.getGenero().toString());
			request.setAttribute("txtBotao", "Alterar");
			request.setAttribute("textoInputNome", banda.getNome());
			request.setAttribute("shows", shows);
			request.setAttribute("Banda", banda);			
			request.setAttribute("actionForm", "bandas/update");
			
			RequestDispatcher rd = request.getRequestDispatcher("formularioBandas.jsp");
			rd.forward(request, response);
			
		}else {
			response.sendRedirect("ListarBandas");
		}
		
	}


}
