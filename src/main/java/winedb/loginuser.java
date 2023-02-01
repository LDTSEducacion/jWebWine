package winedb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mipk.beanDB;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class loginuser
 */
@WebServlet("/loginuser")
public class loginuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginuser() {
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
		String resultado = "No se pudo iniciar sesion el usuario";
		String url ="iniciarSesion.jsp";
		
		if (session.getAttribute("iniciado")!=("1")){
		String redirect = "../iniciarSesion.jsp";
		String usuario=request.getParameter("usuario");
		String pass=request.getParameter("pass");
		if (usuario == null) usuario="";
		if (pass == null) pass="";
		boolean sesioniniciada=false;
		try {
			String aux=session.getAttribute("usuario").toString();
			sesioniniciada=true;
		} catch (Exception e){
			sesioniniciada=false;
		}
		boolean usuok=false;
		beanDB basedatos = new beanDB();
		String query ="select idUsuario from usuarios where usuario=lower('" + usuario + "') and passwd=AES_ENCRYPT('"+ pass +"','Cl4V3sUpErS3gUr412$?')";
		String[][] resultadoquery = null;
		try {
			resultadoquery=basedatos.resConsultaSelectA3(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (resultadoquery!=null){
			usuok=true;
			basedatos.update("update usuarios set ultimoacceso =DATE_ADD(now(),INTERVAL 1 HOUR) where idUsuario="+resultadoquery[0][0]);
		}

		if (!sesioniniciada){
			if (usuok){
				session.setAttribute("idusuario",resultadoquery[0][0]);
				session.setAttribute("usuario",usuario);
				session.setAttribute("iniciado","1");
				sesioniniciada=true;
				resultado = "Haz iniciado sesion correctamente";
				url="miPerfil.jsp";
				query ="select tipocuenta from usuarios where usuario='"+usuario+"'";
				resultadoquery=null;
				try {
					resultadoquery=basedatos.resConsultaSelectA3(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(resultadoquery[0][0]);
				session.setAttribute("tipocuenta",resultadoquery[0][0]);
				
			}
		}
	}else {
		resultado = "Ya tiene una sesion activa";
		url="miPerfil.jsp";
	}
		
		
		response.sendRedirect(url+"?msg="+resultado);
}}
