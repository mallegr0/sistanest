<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<!-- Contenidos META -->
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
			<meta name="viewport" content="width=device-widht, initial-scale=1">
			
			<title>SISTANEST - Gestión de Anestesias</title>
			
			<!-- Estilos que uso -->
			<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
			<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-purple.css">
			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
			<link rel="stylesheet" type="text/css" href="CSS/sistanest.css">
			

			<!-- AGREGO TODOS LOS ESTILOS QUE USE -->
			<!--<jsp:include page="EXTRAS/estilos.jsp"></jsp:include>-->
		</head>

		<!-- Mediante Angular ingreso los metodos de JS que voy a estar usando para darles funcionalidad al HTML del JSP -->
		<body ng-app="loginApp">
			<header>
				<div class="w3-top">
					<div class="w3-bar w3-theme-d3 w3-center">
						<h1>SISTANEST - Gestión de Anestesias</h1>
					</div>
				</div>
			</header>
			
			<!-- FALTANTES --- Borrar -->
			<div class="w3-container w3-padding-32">
				<br>
				<p class="w3-red">FALTA LAS VALIDACIONES HECHAS EN JS Y CAMBIAR LOS COLORES DE LOS ELEMENTOS QUE NO SE INSERTARON</p>
				<p class="w3-red">MOSTRAR EL MENSAJE DE ERROR EN UN MODAL</p>
				<p class="w3-red">CREAR UN META JSP CON TODOS LOS LINK - ver js</p>
			</div>
			
			
			<!-- LOGIN DEL SISTEMA -->
			<div class="w3-container w3-center">
				<form id="LoginUsr" class="form-horizontal" role="form" action="LoginUsr" method="post" novalidate>
					<h2 class="w3-center">LOGIN	</h2>
						<div class="w3-row w3-section">
							<div class="w3-col" style="width:50px">
								<i class="w3-xxlarge fa fa-user"></i>
								<div class="w3-rest">
									<input type="text" name="usuario" class="w3-input w3-border" placeholder="Usuario">
								</div>
							</div>
						</div>
						<div class="w3-row w3-section">
							<div class="w3-col" style="width:50px">
								<i class="w3-xxlarge fa fa-key"></i>
								<div class="w3-rest">
									<input type="password" name="password" class="w3-input w3-border" placeholder="Contraseña">
								</div>
							</div>
						</div>
						<p class="w3-center">
							<button class="w3-button w3-section w3-purple w3-ripple">
								Ingresar
							</button>
						</p>

					</form>
				</div>
				<!-- VENTANA MODAL QUE ME MUESTRA EL ERROR DEL LOGIN -->
				
				<c:if test="${not empty error }">
					<script>
						$('#modal').modal('show');
					</script>
				</c:if>
			</div>

		  	<div class="modal" id="modal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-body">
		        <div class="alert alert-dismissible alert-danger">
		 				<button type="button" class="close" data-dismiss="alert">&times;</button>
		  				<strong>"${error}"</strong>
					</div>
		      </div>
		    </div>
		  </div>
		</div>
		  
		  
			<!-- INCLUDE QUE AGREGA EL FOOTER -->	 
			<jsp:include page="footer.html" ></jsp:include>
			
			<!-- AGREGO TODAS LAS LIBRERIAS DE SCRIPTS QUE VOY A USAR -->
			<!--<jsp:include page="EXTRAS/scripts.jsp"></jsp:include>-->
		</body>
</html>