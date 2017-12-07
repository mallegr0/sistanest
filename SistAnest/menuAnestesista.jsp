<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<jsp:include page="EXTRAS/estilos.jsp"></jsp:include>
		<title>SistAnest - Menu Usuario</title>
	</head>
	<body>
		<c:set var="usuario" value="${user}" scope="session"></c:set>
		<c:set var="i" value="1"></c:set>
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
						</ul>
				      	<ul class="nav navbar-nav navbar-right">
				      		<li><a href="#" class="glyphicon glyphicon-user fa-5x btn-medium"></a></li>
				      		<li><p>&nbsp&nbsp&nbsp</p></li>
				        	<li><a href="../sistanest/index.jsp" type="button" class="glyphicon glyphicon-log-out btn-medium btn btn-success"></a></li>
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
				<li><p class="text-danger">Se tiene que hacer una pagina que modifique los datos personales y el password</p></li>
				<li><p class="text-danger">Agrandar el boton de usuario</p></li>
				<li><p class="text-danger">Si es posible agregarle el nombre de usuario, sino se ve en el servlet que le paso para el jsp del los datos personales</p></li>
				<li><p class="text-danger">Hacer JS de las selecciones.</p></li>
				<li><p class="text-danger">Ordenar por los campos de la tabla</p></li>
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
						<th>Usuario</th>
					</tr>
					<c:forEach items="${anestesias}" var="anestesia">
						<tr>
							<td>${i}</td>
							<td><fmt:formatDate type="date" value = "${anestesia.fecPrestacion}" /></td>
							<td><c:out value="${anestesia.fecARA}" default="---"></c:out></td>
							<td><c:out value="${anestesia.fecRendicion}" default="---"></c:out></td>
							<td><c:out value="${anestesia.afiliado}"></c:out></td>
							<td><c:out value="${anestesia.nroAfiliado}"></c:out></td>
							<td><c:out value="${anestesia.osocial}"></c:out></td>
							<td><c:if test="${anestesia.nocturno==true}"><c:out value="SI" default="NO"></c:out></c:if></td>
							<td><c:if test="${anestesia.feriado==true}"><c:out value="SI" default="NO"></c:out></c:if></td>
							<td><c:if test="${anestesia.fds==true}"><c:out value="SI" default="NO"></c:out></c:if></td>
							<td><c:out value="${anestesia.nroVias}"></c:out></td>
							<td><c:out value="${anestesia.edad}"></c:out></td>
							<td><c:out value="${anestesia.nroTalon}" default="---"></c:out></td>
							<td><c:out value="${anestesia.medico}"></c:out></td>
							<td><c:out value="${anestesia.sanatorio}"></c:out></td>
							<td><c:out value="${anestesia.tpoAnestesia}"></c:out></td>
							<td><c:out value="${anestesia.usuario}"></c:out></td>
						</tr>
						<c:set var="i" value="${i+1}"></c:set>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<!-- INCLUDE que agrega la pagina con el pie de pagina estandarizado  -->
		<jsp:include page="footer.html"></jsp:include>

		<jsp:include page="EXTRAS/scripts.jsp"></jsp:include>
	</body>
</html>