<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <title> Modificar Cliente</title>
  <meta http-equiv="generator" content="CoffeeCup HTML Editor (www.coffeecup.com)" />
  <meta name="created" content="sáb, 04 sep 2010 08:26:15 GMT" />
  <meta http-equiv="content-type" content="text/html;charset=utf-8" />
  <meta name="description" content="" />
  <meta name="keywords" content="" />
</head>
<script type="text/javascript" src="prototype/prototype-1.6.0.3.js" ></script>
<script language="javascript1.2">

    function traerCliente()
    {
    	var cedula	= document.form.cedula.value;
  	
    	var parametro 	= 'operacion=actualizar&cedula=' + cedula;
  	
  		new Ajax.Request('http://localhost:8080/orm/ClienteABM', {
          	method: 'post',
          	postBody: parametro, 
          	onSuccess: mostrarResultado}
      	);	
    }
  
    function mostrarResultado (transport)
    {    	
    	document.getElementById('resultado').innerHTML=transport.responseText;
    }
    function mostrarResultado2 (transport2)
    {    	
    	document.getElementById('resultado2').innerHTML=transport2.responseText;
    }


	function modificarCliente()
	{
		var cedula	= document.form.cedula.value;
		var nombre 	= document.form_modif.nombre.value;
		var apellido 	= document.form_modif.apellido.value;
		

		var parametro 	= 'operacion=modificar&cedula='+ cedula+'&nombre=' + nombre + '&apellido=' + apellido ;

		new Ajax.Request('http://localhost:8080/orm/ClienteABM', {
          	method: 'post',
          	postBody: parametro, 
          	onSuccess: mostrarResultado2}
      	);
		document.form.cedula.value="";
		document.form_modif.nombre.value="";
		document.form_modif.apellido.value="";		
	}  
  
   
</script>


<body>
	<form name="form" action="javascript:traerCliente()">
		<table>
			<tr> <th> Cliente a Modificar </th></tr>
			<tr> <td> ID Cliente </td> <td>	<input type="text" id="cedula" 	name="cedula"> 		</input></td></tr>
			<tr> 
				<td> <input type="submit" name="Modificar" value="Modificar"> </input> </td>
				<td> <a href="./indexClientes.jsp"> Regresar </a> </td>
			</tr>
		</table>
	</form>
	
	<div id="resultado"></div>
	<div id="resultado2"></div>
</body>
</html>

