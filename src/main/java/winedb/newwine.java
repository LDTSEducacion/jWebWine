package winedb;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mipk.beanDB;


/**
 * Servlet implementation class newwine
 */
@WebServlet("/newwine")
public class newwine extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public newwine() {
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
		String admin = ""+session.getAttribute("tipocuenta");
		String url ="admin.jsp";
		String resultado ="No se a podido añadir la botella";
		if (admin.equals("1")){
			//Declaro cosas
			beanDB basedatos = new beanDB();
			String[][] resultadoquery = null;
			//Capturo datos
			String nombrebotella=request.getParameter("nombrebotella");
			String tipobotella=request.getParameter("tipobotella");
			String origenbotella=request.getParameter("origenbotella");
			String edadbotella=request.getParameter("edadbotella");
			String descripcionbotella=request.getParameter("descripcionbotella");
			String urlbotella=request.getParameter("urlbotella");
			if (nombrebotella == null) {
				resultado="Rellena los campos obligatorios";
			}else {
			if (tipobotella == null) tipobotella="";
			if (origenbotella == null) origenbotella="";
			if (edadbotella == null) edadbotella="";
			if (descripcionbotella == null) descripcionbotella="";
			if (urlbotella == null) urlbotella="";
			
			String query ="select idBotella from botellas where nombre = '"+nombrebotella+"'";
			
			try {
				resultadoquery=basedatos.resConsultaSelectA3(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(resultadoquery!=null) {
				resultado="La botella ya existe";
			}
			else {
				basedatos.insert("INSERT INTO botellas (nombre,tipo,origen,envejecimiento,descripcion,imagen) VALUES ('"+nombrebotella+"','"+tipobotella+"','"+origenbotella+"','"+edadbotella+"','"+descripcionbotella+"','img/"+urlbotella+"')");
				resultado="Correcto!!!";
			}
			
			}
			response.sendRedirect(url+"?msg="+resultado);
			
			
			
		}
		
		
	}

}
