package py.cursoweb.mvcmodificado;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


/**
 * Servlet implementation class ClienteABM
 */
public class ClienteABM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteABM() {
        super();
    }

	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	protected void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion = request.getParameter("operacion");
		ClienteManager mgr = new ClienteManager();
		PrintWriter pw = response.getWriter();
		
		
		if("guardar".equals(operacion)){
			String c = request.getParameter( "cedula");
			Integer cedula = Integer.parseInt( c );
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			
			Cliente cliente = new Cliente();
			
			cliente.setCedula(cedula);
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			
			try {
				mgr.saveCliente(cliente);
				
				pw.println("CLIENTE GUARDADO EXITOSAMENTE!");
			}catch(Exception ex) {
				pw.println("OCURRIO EL ERROR: " + ex.getClass().getName() + 
						   " - " + ex.getMessage());
			}

		}
		else if("eliminar".equals(operacion)) 
		{
			String c = request.getParameter("cedula");
			Integer cedula = Integer.parseInt(c);
			Cliente cliente = new Cliente();
			cliente = mgr.getCliente(cedula);
			
			try {
				pw  = response.getWriter();
				mgr.eliminarCliente(cliente);
				pw.println("Eliminado con exito! WIN");
			}
			catch (Exception e) {
				System.err.println("Ocurrio un error: " + e.getMessage());
				pw.println("Ocurrio un error: " + e.getMessage());
			}
		}
		else if("modificar".equals(operacion)) 
		{
			try {
				String c = request.getParameter("cedula");
				Integer cedula = Integer.parseInt(c);
				Cliente cliente = new Cliente();
				cliente = mgr.getCliente(cedula);
				String nombre = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				//cliente.setTelefono(telefono);
				//cliente.setRuc(ruc);
				
				mgr.saveCliente(cliente);
				//pw = response.getWriter();
				pw.println("Modificado con exito! WIN");	
			}
			catch(Exception e){
				System.err.println("Ocurrio un error: " + e.getMessage());
				//printer.println("Ocurrio un error: " + e.getMessage());
			}
		}
		else if("actualizar".equals(operacion)) {
			String c = request.getParameter("cedula");
			Integer cedula = Integer.parseInt(c);
			Cliente cliente =  mgr.getCliente(cedula);
					
			try {
				pw = response.getWriter();
				pw.println(formatearDatos(cliente));					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		else if("listar".equals(operacion)) 
				{
					try {
						
						request.setAttribute("listaClientes", mgr.getClientes());
					}
					catch (Exception e) {
						System.err.println("Ocurrio un error: " + e.getMessage());
					}
					
					try {
						llamarPagina(request, response , "/listaClientes.jsp");
					}
					catch(Exception e) {
						System.err.println("Ocurrio un error: " + e.getMessage());
					}
		}
		else{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/formulario.jsp");
			dispatcher.forward(request, response );
		}
				
		
		
	}
	public String formatearDatos(Cliente cliente)
	{
		String result="";
		try
		{
			String NOM = cliente.getNombre();
			String APE = cliente.getApellido();
			//String TEL = cliente.getTelefono();
			//String RUC = cliente.getRuc();
			result = "<form name='form_modif' action='javascript:modificarCliente()'>" +
			"<table>" + 
	    	"<tr> <th> Modificar Cliente </th></tr>"+
	    	"<tr> <td> Nombre </td><td>	<input type='text' id='nombre' name='nombre' value='" 		+NOM+"'></input></td></tr>"+
			"<tr> <td> Apellido </td><td><input type='text' id='apellido' name='apellido' value='"+APE+"'></input></td></tr>"+
			"<tr>"+ 
			"<td> <input type='submit' name='Guardar' value='Guardar'> </input> </td>"+
			"<td> <a href='./indexClientes.jsp'> Regresar </a> </td>"+
			"</tr>"+
			"</table>"+
			"</form>";		
		}
		catch(Exception e)
		{
			result = "ID No Encontrado";
		}
		return result;		
	}
	protected void llamarPagina(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request,response);
	}
}
