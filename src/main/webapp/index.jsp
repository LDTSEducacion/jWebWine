<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="mipk.beanDB"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ProyectoBodegas</title>
<link rel="stylesheet" href="css/estilosIndex.css">
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
			<li class="nav-item"><a class="nav-link" href="miPerfil.jsp"><span
					class="colorVinoClaro">Mi Perfil</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href="iniciarSesion.jsp"><span class="colorVinoClaro">Iniciar
						Sesion</span></a></li>
			<li class="nav-item"><a class="nav-link" href="crearCuenta.jsp"><span
					class="colorVinoClaro">Crear Cuenta</span></a></li>
			<% if (session.getAttribute("tipocuenta").equals("1")){%>
			<li class="nav-item"><a class="nav-link" href="admin.jsp"><span
					class="colorVinoClaro">Administrar</span></a></li>
			<%} %>
		</ul>

		<form class="form-inline my-2 my-lg-0" action="index.jsp"
			method="post" name="buscar">
			<input name="resultadobusqueda" class="form-control mr-sm-2"
				style="background-color: #d9d9d9" type="search"
				placeholder="Marquez de Cáceres" aria-label="Search">
			<button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Buscar</button>
		</form>

	</div>
	</nav>
	<%
	String resultadobusqueda = null;
	resultadobusqueda = request.getParameter("resultadobusqueda");
	String[][] tablares;
	beanDB basededatos = new beanDB();
	if (resultadobusqueda == null) {
		String query = "select imagen,nombre,tipo,origen,descripcion from botellas";
		tablares = basededatos.resConsultaSelectA3(query);
	} else {
		String query = "select imagen,nombre,tipo,origen,descripcion from botellas where nombre=lower('" + resultadobusqueda
		+ "')";
		tablares = basededatos.resConsultaSelectA3(query);
	}
	if ((resultadobusqueda == null && tablares != null) || (resultadobusqueda != null && tablares != null)) {
	%>
	<div id="titulo">
		<h2>Informacion sobre cualquier tipo de botella</h2>
	</div>
	<div id="principal" class="container-fluid">
		<div class="row">
			<div class="col-12 ">


				<table>
					<%
					for (int i = 0; i < tablares.length; i++) {
					%><tr>
						<%
						for (int j = 0; j < tablares[i].length - 3; j++) {
						%>
						<td>
							<%
							if (j == 0) {
							%><img alt="<%=tablares[i][j]%>" src="<%=tablares[i][j]%>">
							<%
							} else if (j == 1) {
							%><h3>
								<b>Nombre: </b><%=tablares[i][j]%></h3>
							<p>
								<b>Tipo: </b><%=tablares[i][j + 1]%>
								<br> <b>Origen: </b><%=tablares[i][j + 2]%></p>
							<p>
								<b>Descripcion: </b><br><%=tablares[i][j + 3]%></p> <a
							href="informacionBotellas.jsp"> Ver Informacion</a>
						</td>
						<%
						}
						}
						%>
					
					<tr />
					<%}%>
				</table>
				<%
				} else {
				%>
				<h1>No hay resultados de busqueda</h1>
				<a href="index.jsp">Volver</a>
				<%
				}
				%>
			</div>



		</div>
	</div>





</body>
</html>