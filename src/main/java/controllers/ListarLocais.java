package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListarLocais")
public class ListarLocais extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarLocais() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*LocalDAO dao = new LocalDAO();
	
		ArrayList<Local> locais = dao.listarLocais();
		 
		request.setAttribute("locais", locais);
		RequestDispatcher rd = request.getRequestDispatcher("TabelaLocais.jsp");
		rd.forward(request, response);*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String nome = request.getParameter("nomeLugar");
		
		LocalDAO dao = new LocalDAO();
		
		ArrayList<Local> locais = dao.listarLocaisComFiltro(nome);
		 
		request.setAttribute("locais", locais);
		RequestDispatcher rd = request.getRequestDispatcher("TabelaLocais.jsp");
		rd.forward(request, response);*/
	}

}