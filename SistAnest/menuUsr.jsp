<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entidades.Usuario" %>
<%@ page import="entidades.Sanatorio" %>
<%@ page import="controlador.CtrlUsuario" %>

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
		<%Usuario u = ((Usuario)session.getAttribute("u")); %>
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
				      		<li>
				      			<div class ="input-prepend">
						          	<select class="form-control" id="select">
							        	<option>Maternidad Oroño</option>
							          	<option>Fertya</option>
							          	<option>Sanatorio Los Alerces</option>
							        </select>
						        </div>
					        </li>
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
				      		<li><a href="#"><strong><%=u.getUser()%></strong></a></li>
				        	<li><a href="../sistanest/index.html" type="button" class="btn btn-success">Salir</a></li>
				    	</ul>
					</div>
				</div>
			</nav>
		</header>
		<div class="container">
			<p> ESTA ES LA PANTALLA PRINCIPAL DE ANAESTESISTAS <BR>
				LA IDEA ES QUE SIEMPRE SE MANEJE CON LA MISMA PAGINA</p>
				
				<br><br>
				<h3>LISTA DE PENDIENTES EN ESTE APARTADO..</h3>
				<ul>
					<li><p>Se tiene que hacer un servlet que elimine todos los datos y que no permita volver para atras</p></li>
					<li><p>Se tiene que hacer un servlet para cambiar contraseña</p></li>
					<li><p>Se tiene que hacer una pagina que modifique los datos personales</p></li>
					<li><p>Se tiene que hacer un menu que cambie el nombre segun el valor elegido</p></li>
					<li><p>Se tiene que hacer un metodo que devuelva los valores requeridos para el combo</p></li>
				</ul>
		
		
		
		
		</div>
		
		<footer class="navbar navbar-fixed-bottom">
			<p align="center" class="lead"><a href="datosPersonales.html" >Matias Allegranza</a></p>
		</footer>

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