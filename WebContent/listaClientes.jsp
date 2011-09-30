<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de alumnos</title>
</head>
<body>
	<h1 class="titulo">Lista de alumnos inscriptos</h1>
	<table class="listado">
	 <tr><th>C�dula</th><th>Nombre</th><th>Apellido</th></tr>

	  <c:forEach var="alumno" items="${requestScope['listaClientes']}">

	  	<tr>  
	  		<td><c:out value="${alumno.cedula}"/></td>
		    <td><c:out value="${alumno.nombre}"/></td>
		    <td><c:out value="${alumno.apellido}"/></td>
		</tr>

	  </c:forEach>

	</table>
</body>
</html>
