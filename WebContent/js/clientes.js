var accion='guardar';
function actualizar_datos()
{
    var idx = document.form_cli.cedula.value;
    var nombrex = document_form_cli.nombre.value;
    var apellidox = document.form_cli.apellido.value;
    //var rucx = document.form_cli.ruc.value;
    //var telefonox = document.form_cli.telefono.value;

    var parametros = 'operacion=' + accion ;
    if (accion == 'guardar')
    {
        parametros = parametros + '&cedula=' + idx;
        parametros = parametros + '&nombre=' + nombrex;
        parametros = parametros + '&apellido=' + apellidox;
        //parametros = parametros + '&telefono=' + telefonox;
        //parametros = parametros + '&ruc=' + rucx;
    }
    if (accion == 'modificar')
    {
        parametros = parametros + '&cedula=' + idx;
        parametros = parametros + '&nombre=' + nombrex;
        parametros = parametros + '&apellido=' + apellidox;
        //parametros = parametros + '&telefono=' + telefonox;
        //parametros = parametros + '&ruc=' + rucx;
    }
    if (accion == 'eliminar')
    {
        parametros = parametros + '&cedula=' + idx;
    }
    window.alert(parametros);
    new Ajax.Request('http://localhost:8080/orm/ClienteABM', {
        method: 'post',
        postBody: parametros,
        onSuccess: mostrarResultado }
    );
    //limpiar_campos();

}
function mostrarResultado(transport)
{

    document.getElementById('tabla_cli').innerHTML=transport.responseText;
	

}

function optionHandlerGUARDAR()
{
    document.getElementById('cedula').disabled=true;
    document.getElementById('aceptar').value='guardar';
    document.getElementById('cedula').value='';
    document.getElementById('nombre').value='';
    document.getElementById('apellido').value='';
    //document.getElementById('telefono').value='';
   // document.getElementById('ruc').value='';
    accion='guardar';
}

function optionHandlerMODIFICAR()
{
    document.getElementById('cedula').disabled=false;
    document.getElementById('aceptar').value='modificar';
    document.getElementById('cedula').value='';
    document.getElementById('nombre').value='';
    document.getElementById('apellido').value='';
    //document.getElementById('telefono').value='';
    //document.getElementById('ruc').value='';
    accion='modificar';
}

function optionHandlerELIMINAR()
{
    document.getElementById('cedula').disabled=false;
    document.getElementById('aceptar').value='eliminar';
    document.getElementById('cedula').value='';
    document.getElementById('nombre').value='';
    document.getElementById('apellido').value='';
   // document.getElementById('telefono').value='';
    //document.getElementById('ruc').value='';
    accion='eliminar';
}

function cargar_campos()
{
    var idx = document.form_cli.cedula.value;
    var parametros = 'operacion=actualizar&cedula='+idx;
    new Ajax.Request('http://localhost:8080/orm/ClienteABM', {
        method: 'post',
        postBody: parametros, 
        onSuccess:mostrar_campos}
    );
}

function limpiar_campos()
{
    document.getElementById('cedula').value='';
    document.getElementById('nombre').value='';
    document.getElementById('apellido').value='';
    //document.getElementById('telefono').value='';
    //document.getElementById('ruc').value='';
    
}
function mostrar_campos(respuesta)
{
    //respuesta.responseText.evalScripts();
	var c = respuesta.responseText.evalJSON();
	document.getElementById('cedula').value = c.cedula;
	document.getElementById('nombre').value = c.nombre;
	document.getElementById('apellido').value = c.apellido;
	//document.getElementById('telefono').value = c.telefono;
	//document.getElementById('ruc').value = c.ruc;
}

