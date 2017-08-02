<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entidades.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SistAnest - Menu Usuario</title>
</head>
<body>
<%Usuario j = ((Usuario)session.getAttribute("u")); %>
<p>Menu usuario</p>
<p>Apellido del usuario</p>
<%=j.getApellidoUsuario() %>
<p>ID Rol</p>
<%=j.getIdRol() %>

</body>
</html>