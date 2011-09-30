<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <title></title>
  <meta http-equiv="generator" content="CoffeeCup HTML Editor (www.coffeecup.com)" />
  <meta name="created" content="mié, 01 sep 2010 19:26:49 GMT" />
  <meta http-equiv="content-type" content="text/html;charset=utf-8" />
  <meta name="description" content="" />
  <meta name="keywords" content="" />
 <script type="text/javascript" src="prototype/prototype-1.6.0.3.js" ></script>
 <script type="text/javascript" src="js/clientes.js" ></script>

</head>
<body>
	<body>
        <h2>Clientes</h2>
        <form name=form_cli action="javascript:actualizar_datos()">
            <INPUT  ONCLICK="optionHandlerGUARDAR()" type="radio" id='opcion' name="opcion" value="guardar" checked> Guardar <BR>
            <INPUT  ONCLICK="optionHandlerMODIFICAR()" type="radio" id='opcion' name="opcion" value="modificar"> Modificar <BR>
            <INPUT  ONCLICK="optionHandlerELIMINAR()" type="radio" id='opcion' name="opcion" value="eliminar"> Eliminar <BR>
            <table>
			    <tr>
                	<td> ID : </td> <td> <input type=text onblur="cargar_campos()" id='cedula' name="cedula"></td>
                </tr>
				
                <tr>
                    <td> Nombre : </td> <td> <input type=text id='nombre' name="nombre"></td>
                </tr>
				
                <tr>
                    <td> Apellido : </td> <td> <input type=text id='apellido' name="apellido"></td>
                </tr>
			
                
                <tr>
                    <td colspan=2 align=center>
                        <input type=submit id='aceptar' name="aceptar" value="guardar">
                    </td>
                </tr>
            </table>
            <div id='tabla_cli'></div>
        </form>
    </body>
</body>
</html>

