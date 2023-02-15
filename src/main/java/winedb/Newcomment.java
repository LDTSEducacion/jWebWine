package winedb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mipk.beanDB;

import java.io.IOException;

/**
 * Servlet implementation class Newcomment
 */
@WebServlet("/Newcomment")
public class Newcomment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Newcomment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id=request.getParameter("id");
		String resultado = "No se pudo crear el comentario";
		String url ="informacionBotellas.jsp?id="+id;
		String comentario=request.getParameter("comentario");
		String usu=""+session.getAttribute("idusuario");
		
		if (comentario == null) comentario="";
		beanDB basededatos = new beanDB();
		basededatos.insert("INSERT INTO comentarios (comentario,botellaId,usuarioId) VALUES ('"+comentario+"','"+id+"','"+usu+"')");
		response.sendRedirect(url);
	}

}
