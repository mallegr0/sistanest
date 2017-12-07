<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SISTANEST - Gestión de Anestesias</title>

<!-- AGREGO TODOS LOS ESTILOS QUE USE -->
<jsp:include page="EXTRAS/estilos.jsp"></jsp:include>
</head>

<!-- Mediante Angular ingreso los metodos de JS que voy a estar usando para darles funcionalidad al HTML del JSP -->
<body ng-app="loginApp">
	<header>
		<nav class="navbar navbar-inverse">
	  		<div class="container-fluid">
				<H1 style="color:#fff" align="center">SISTANEST - Gestión de Anestesias</H1>
	 		</div>
		</nav>
	</header>
	<br>
	<p class="text-danger">FALTA LAS VALIDACIONES HECHAS EN JS Y CAMBIAR LOS COLORES DE LOS ELEMENTOS QUE NO SE INSERTARON</p><BR>
	<p class="text-danger">MOSTRAR EL MENSAJE DE ERROR EN UN MODAL</p><BR>
	<p class="text-danger">CREAR UN META JSP CON TODOS LOS LINK - ver js</p>
	
	
	
	<!-- 
		FORMULARIO DE LOGIN DEL SISTEMA
	 -->
	
	<div class="container-fluid" align="center">
		<br>
		<div class="col-md-4 col-md-offset-3 col-sm-6 col-sm-offset-2" align="center">       
           <form id="LoginUsr" class="form-horizontal" role="form" action="LoginUsr" method="post">     
           		<div style="margin-bottom: 15px" class="input-group">
                	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="username" type="text" class="form-control" name="usuario" placeholder="Usuario">                                        
                </div>
                <div style="margin-bottom: 25px" class="input-group">
                	<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" class="form-control" name="password" placeholder="Password">
                </div>
                <div style="margin-top:10px" class="form-group" align="center">
                	<div class="col-sm-6 col-md-4 col-sm-offset-4">
                     	<input  type="submit" id="login" class="btn btn-info" name="login" value="Ingresar">
                     </div>
                     <div style="margin-top: 10px" class="col-sm-6 col-md-4 col-sm-offset-4">	
                        <a href="AltaUsrForm.html" style="color:#772953">Registrarse</a>
                    </div>
                </div>
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