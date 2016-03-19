<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.Vector" %>
<%@ page import="es.ufv.dis.Jugador.bean.Jugador" %>
<%@ page import="es.ufv.dis.Jugadores.motor.Motor" %>
<%@ page import="es.ufv.dis.Jugadores.dao.Dao" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

Motor motor = new Motor();
motor.guardar();

%>

XML guardado

<p><a href="inicio.jsp">Volver</a>
</body>
</html>