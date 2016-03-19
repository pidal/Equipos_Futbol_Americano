<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserta Jugadores</title>
</head>
<body>
<h1>Listado de jugadores</h1>

<form action="insertando.jsp">

Nombre: <input type="text" name="nombre"><br/>
Apellidos: <input type="text" name="apellidos"><br/>
Equipo: <input type="text" name="equipo"><br/>
Posición: <input type="text" name="posicion"><br/>
Dorsal: <input type="text" name="dorsal"><br/>
Salario: <input type="text" name="salario"><br/>

<input type="submit" value="Enviar">

</form>

</body>
</html>