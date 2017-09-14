<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SISTANEST - Gestión de Anestesias</title>
<link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/united/bootstrap.min.css" rel="stylesheet" integrity="sha384-pVJelSCJ58Og1XDc2E95RVYHZDPb9AVyXsI8NoVpB2xmtxoZKJePbMfE4mlXw7BJ" crossorigin="anonymous">
<link href="CSS/sistanest.css" rel="stylesheet">
<!-- Script que agrega el jquery para usarlo en la página -->
<script src="http://code.jquery.com/jquery-3.2.1.min.js"
		integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
		crossorigin="anonymous"></script>
<!-- Script que agrega el JScript de bootstrap para usarlo en la página -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
		crossorigin="anonymous"></script>
<script type="text/javascript" src="JS/sistanest_login.js"></script>


</head>


<body onload="carga();">
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
	<p class="text-danger">CREAR UN META JSP CON TODOS LOS LINK</p>
	
	
	
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
			<div class="alert alert-dismissible alert-danger">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
</div>
		</c:if>
	</div>
	<!-- Modal -->
  	<div class="modal fade" id="myModal" role="dialog">
    	<div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
  
	<!-- INCLUDE QUE AGREGA EL FOOTER -->	 
	<jsp:include page="footer.html" ></jsp:include>

</body>
</html>