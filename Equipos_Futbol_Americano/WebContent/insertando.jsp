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
<title>Insertando Jugadores</title>
</head>
<body>
<%
String nombre = request.getParameter("nombre");
String apellidos = request.getParameter("apellidos");
String equipo = request.getParameter("equipo");
String posicion = request.getParameter("posicion");
String dorsal = request.getParameter("dorsal");
String salario = request.getParameter("salario");
Motor motor = new Motor();
motor.insertar(nombre,apellidos,equipo,posicion,dorsal,salario);


Vector<Jugador> jugadores = motor.getJugadores();
%>

<ul>
<%
for (int i=0; i< jugadores.size(); i++)
{
	Jugador jugador = jugadores.elementAt(i);
	
	%>
	<li><%=jugador.getNombre() %> - <%=jugador.getApellidos() %> - <%=jugador.getEquipo() %> - <%=jugador.getPosicion() %> - <%=jugador.getDorsal() %> - <%=jugador.getSalario() %></li>
	<%
	
}
%>


</ul>
<p><a href="inicio.jsp">Volver</a>
</body>
</html>