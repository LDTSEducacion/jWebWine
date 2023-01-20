package mipk;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class Sesionok {
	
	public static boolean isSesionok(HttpServletRequest request) {
		boolean ok = false;
		try {
			HttpSession session=request.getSession();
			String atributo = session.getAttribute("iniciada").toString();
			ok = atributo.equals("ok");
		} catch (Exception e) {
			ok = false;
		}
		return ok;
	}
	
}
