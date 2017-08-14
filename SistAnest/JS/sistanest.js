/**
 * Script que maneja lo basico de mi pagina y que suplementa el JS de bootstrap 
 */
	function carga(){
		document.body.clear();
		document.getElementById("usuario").focus();
	}
	
	function validaDatos(){
		var usuario = document.getElementById("usuario");
		var password = document.getElementById("password");
		if((usuario.value == "" || usuario.value == '' || usuario.value == null) && 
				(password.value == "" || password.value == '' || password.value == null)){
			errorUsuario();
			errorPassword();
			alert("Ingrese Usuario y contraseña!!");
			usuario.focus();
			return false;
		}
		else if(usuario.value == "" || usuario.value == '' || usuario.value == null){
			alert("Ingrese Usuario!!");
			errorUsuario();
			usuario.focus();
			return false;
		}
		else if(password.value == "" || password.value == '' || password.value == null){
			alert("Ingrese Password!!");
			errorPassword();
			password.focus();
			return false;
		}
		else {
			return true;
		}
	}
	
	function errorUsuario(){
		document.getElementsByName("divUsr").className="form-group has error";
		document.getElementById("divUsr").className="form-group has-error";
		document.getElementById("usuario").id("inputError");
	}
	
	function errorPassword(){
		document.getElementById("divPsw").className="form-group has-error";
	}
	
	function validaSesion(){
		alert();
	}
	
	function validaPassword(){
		var p1 = document.getElementById("password");
		var p2 = document.getElementById("password2");
		if(p1.value != p2.value){
			p1.clear();
			p1.focus();
			p1.id("inputError")
			p2.clear();
			p2.focus();
			p2.id("inputError")
			return false;
		}
		else{
			return true;
		}
	}
		