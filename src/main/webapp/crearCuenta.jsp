<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="mipk.beanDB" import="winedb.newuser"

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Crear Cuenta</title>
<link rel="stylesheet" href="css/estilosIniciarSesion.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/a4fb0845ec.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="scripts/scripts.js"></script>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark colorNav"> <a
		class="navbar-brand" href="index.jsp"><i
		class="fa-solid fa-wine-glass colorVino"></i><span class="colorVino">ProyectoBodegas</span></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link"
				href="miPerfil.jsp"><span class="colorVinoClaro">Mi Perfil</span></a></li>
				<li class="nav-item"><a class="nav-link"
				href="iniciarSesion.jsp"><span class="colorVinoClaro">Iniciar Sesion</span></a></li>
				<li class="nav-item"><a class="nav-link"
				href="crearCuenta.jsp"><span class="colorVinoClaro">Crear Cuenta</span></a></li>
		</ul>

		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" style="background-color: #d9d9d9" type="search"
				placeholder="Marquez de Cáceres" aria-label="Search">
			<button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Buscar</button>
		</form>

	</div>
	</nav>
	<% if (session.getAttribute("iniciado")!=("1")){%>
	<h1>Crear Cuenta</h1>
	<form action="./newuser" method="post" name="crearsesion" />
	<table style="text-align: left; border: none;">
		<tr>
			<td><input type="hidden" name="varoculta" value="secreto" />
				Usuario:</td>
			<td><input type="text" name="usuario" maxlength="15"
				onkeypress="return compruebaalfan(this,event);" value=""
				class="inputgris" /></td>
		</tr>
		<tr>
			<td>Contraseña:</td>
			<td><input type="password" name="pass" maxlength="20"
				onkeypress="return compruebaalfan(this,event);" value=""
				class="inputgris" /></td>
		</tr>
		<tr>
			<td></td>
			<td style="text-align: right;"><input type="button" name="send"
				value="Enviar" onclick="compruebayenviacreardb();" /></td>
		</tr>
	</table>
	</form><%} else { %>
	<h1>Ya tienes una cuenta creada</h1>
	<a href="miPerfil.jsp">Ver Perfil</a>
	<br>
	<a href="index.jsp">Inicio</a>
	<%} %>
	
	
	
	
	
	
	

</body>
</html>