package winedb;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mipk.beanDB;

/**
 * Servlet implementation class newuser
 */
@WebServlet("/newuser")
public class newuser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public newuser() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: asdfgklawufwakjhfkwahfksdlaf ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String resultado = "No se pudo crear el usuario";
		String url ="crearCuenta.jsp";
		if (session.getAttribute("iniciado")!=("1")){

			//Meto en una variables todos los usuarios
			beanDB basedatos = new beanDB();
			String[][] resultadoquery = null;
			String redirect = "../crearCuenta.jsp";

			//Capturo datos
			String usuario=request.getParameter("usuario");
			String pass=request.getParameter("pass");
			if (usuario == null) usuario="";
			if (pass == null) pass="";

			boolean sesionCreada=false;

			String query ="select idUsuario FROM usuarios WHERE usuario=lower('"+usuario+"')";
			try {
				resultadoquery=basedatos.resConsultaSelectA3(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(resultadoquery==null){
				basedatos.insert("INSERT INTO usuarios (usuario,passwd,fechaCreacion) VALUES ('"+usuario+"',AES_ENCRYPT('"+ pass +"','Cl4V3sUpErS3gUr412$?'),CURDATE())");
				sesionCreada=true;
				resultado = "Usuario listo para empezar.";
				url="iniciarSesion.jsp";
			}
			else {
				
				resultado = "El usuario ya existe.";
				url="crearCuenta.jsp";
				
			}
				
				
		}
		
		
		
		response.sendRedirect(url+"?msg="+resultado);
		

}}
