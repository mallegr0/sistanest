<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entidades.Usuario" %>
<%@ page import="controlador.CtrlAnestesia" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Anestesia" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/united/bootstrap.min.css" rel="stylesheet" 
			  integrity="sha384-pVJelSCJ58Og1XDc2E95RVYHZDPb9AVyXsI8NoVpB2xmtxoZKJePbMfE4mlXw7BJ"
		 	  crossorigin="anonymous">
		<title>SistAnest - Menu Usuario</title>
	</head>
	<body>
		<%
			Usuario u = ((Usuario)session.getAttribute("u"));
			CtrlAnestesia ca = new CtrlAnestesia();
			ArrayList<Anestesia> listado = new ArrayList();
			
		%>
		<header>
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
				    	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
					        <span class="sr-only">Toggle navigation</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					   	</button>
				    </div>
				    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
				      	<ul class="nav navbar-nav">
					    	<li class="dropdown">
					          	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Anestesias<span class="caret"></span></a>
					          	<ul class="dropdown-menu" role="menu">
						      		<li><a href="#">Listar por Fecha</a></li>
						        	<li><a href="#">Listar por Obra Social</a></li>
						        	<li><a href="#">Buscar Paciente</a></li>
					        	</ul>
					        </li>
					        <li class="dropdown">
					        	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Pagos<span class="caret"></span></a>
					          	<ul class="dropdown-menu" role="menu">
					            	<li><a href="#">Pagos</a></li>
					        	</ul>
					    	</li>
					    	<li><a href="#" type="button">Cambiar Contraseña</a></li>
						</ul>
				      	<ul class="nav navbar-nav navbar-right">
				      		<li><a href="#" class="glyphicon glyphicon-user btn-medium">&nbsp<strong><%=u.getUser()%></strong></a></li>
				        	<li><a href="../sistanest/index.html" type="button" class="glyphicon glyphicon-log-out btn-medium btn btn-success btn-lg"></a></li>
				    	</ul>
					</div>
				</div>
			</nav>
		</header>
		<div class="container">
			<br>
			<h3>LISTA DE PENDIENTES EN ESTE APARTADO..</h3>
			<ul>
				<li><p class="text-danger">Se tiene que hacer un servlet que elimine todos los datos y que no permita volver para atras</p></li>
				<li><p class="text-danger">Se tiene que hacer un servlet para cambiar contraseña</p></li>
				<li><p class="text-danger">Se tiene que hacer una pagina que modifique los datos personales</p></li>
			</ul>
			<br>
			<div class="table-responsive">
				<table class="table table-striped table-condensed">
					<tr>
						<th>#</th>
						<th>Fec. Anestesia</th>
						<th>Fec. ARA</th>
						<th>Fec. Rendición</th>
						<th>Paciente</th>
						<th>Nro Afiliado</th>
						<th>Obra Social</th>
						<th>Nocturno</th>
						<th>Feriado</th>
						<th>Fin de Semana</th>
						<th>Nro Vias</th>
						<th>Edad</th>
						<th>Nro Talon</th>
						<th>Nombre Medico</th>
						<th>Sanatorio</th>
						<th>Tpo de Anestesia</th>
					</tr>
				</table>
			</div>
		</div>
		
		<!-- <footer class="navbar navbar-fixed-bottom">
			<p align="center" class="lead"><a href="datosPersonales.html" style="color:#772953">Matias Allegranza</a></p>
		</footer>-->
		<jsp:include page="footer.html"></jsp:include>

		<!-- Script que agrega el jquery para usarlo en la página -->
		<script src="http://code.jquery.com/jquery-3.2.1.min.js"
				integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
				crossorigin="anonymous"></script>
		<!-- Script que agrega el JScript de bootstrap para usarlo en la página -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
				integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
				crossorigin="anonymous"></script>
		<!-- Script mio -->
		<script src="JS/sistanest.js"></script>
	</body>
</html>