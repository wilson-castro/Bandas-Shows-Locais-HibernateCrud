package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FormControlShows")
public class FormControllShows extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	  
    public FormControllShows() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		
		if(operation.equals("novo")) {
			
		/*	LocalDAO localDao = new LocalDAO();
			BandaDAO bandaDao = new BandaDAO();
			
			ArrayList<Local> listaLocais = new ArrayList<Local>();
			listaLocais = localDao.listarLocais();
			
			ArrayList<Banda> listaBandas = new ArrayList<Banda>();
			listaBandas = bandaDao.listarBandas();
			
			request.setAttribute("titulo", "Criar");
			request.setAttribute("selected", "-selecione-");
			request.setAttribute("dataDefault", "2020-10-13");
			request.setAttribute("txtBotao", "Adicionar");
			request.setAttribute("locais", listaLocais);
			request.setAttribute("bandas", listaBandas);
			request.setAttribute("actionForm", "shows/insert");*/

			RequestDispatcher rd = request.getRequestDispatcher("FormularioShows.jsp");
			rd.forward(request, response);
		}else if(operation.equals("editar")){
			/*Show show = new Show();
			ShowBanda sb = new ShowBanda();

			LocalDAO localDao = new LocalDAO();
			BandaDAO bandaDao = new BandaDAO();
			ShowDAO showDao = new ShowDAO();
			ShowsBandaDAO showbandaDao = new ShowsBandaDAO();
			
			int idShow = Integer.parseInt(request.getParameter("idShow"));
			
			show.setIdShow(idShow);
			showDao.selecionarShow(show);
			
			sb.setId_show(idShow);
			
			ArrayList<Local> listaLocais = new ArrayList<Local>();
			listaLocais = localDao.listarLocais();
			
			ArrayList<Banda> listaBandas = new ArrayList<Banda>();
			listaBandas = bandaDao.listarBandas();
			
        	ArrayList<ShowBanda> listaBandaShow = showbandaDao.selecionarShowsPorBanda(sb);
					
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
			String dataFormat = formatDate.format(show.getData().getTime());
			
			request.setAttribute("titulo", "Editar");
			request.setAttribute("selected", show.getIdLocal());
			request.setAttribute("dataDefault", dataFormat);
			request.setAttribute("txtBotao", "Alterar");
			request.setAttribute("locais", listaLocais);
			request.setAttribute("bandas", listaBandas);
			request.setAttribute("show", show);
			request.setAttribute("ShowsDaBanda", listaBandaShow);

			request.setAttribute("actionForm", "shows/update");*/
			
			
			RequestDispatcher rd = request.getRequestDispatcher("FormularioShows.jsp");
			rd.forward(request, response);
			
			
		} else {
			response.sendRedirect("ListarBandas");
		}
		
	}

}
