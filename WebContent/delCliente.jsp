<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <title> Eliminar Cliente</title>
  <meta http-equiv="generator" content="CoffeeCup HTML Editor (www.coffeecup.com)" />
  <meta name="created" content="s�b, 04 sep 2010 08:26:15 GMT" />
  <meta http-equiv="content-type" content="text/html;charset=utf-8" />
  <meta name="description" content="" />
  <meta name="keywords" content="" />
</head>
<script type="text/javascript" src="prototype/prototype-1.6.0.3.js" ></script>
<script language="javascript1.2">

  function eliminarCliente()
  {
  	var cedula	= document.form.cedula.value;
	
  	var parametro 	= 'operacion=eliminar&cedula=' + cedula;
	
	new Ajax.Request('http://localhost:8080/orm/ClienteABM', {
        method: 'post',
        postBody: parametro, 
        onSuccess: mostrarResultado}
    );	
	document.form.cedula.value="";
  }
  
  function mostrarResultado (transport)
  {
  	//falta preparar en la respuesta del servlet
  	document.getElementById('resultado').innerHTML=transport.responseText;
  }
   
</script>
<body>
	<form name="form" action="javascript:eliminarCliente()">
		<table>
			<tr> <th> Cliente a Eliminar </th></tr>
			<tr> <td> ID Cliente </td> <td>	<input type="text" id="cedula" 	name="cedula"> 		</input></td></tr>
			<tr> 
				<td> <input type="submit" name="Eliminar" value="Eliminar"> </input> </td>
				<td> <a href="./indexClientes.jsp"> Regresar </a> </td>
			</tr>
		</table>
	</form>
	<div id="resultado"></div>
</body>
</html>
