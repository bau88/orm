package py.cursoweb.mvcmodificado;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Clase encargada de manipular datos relacionados a Clientes
 * @author jtalavera
 *
 */
public class ClienteManager {

	//Datos de prueba .... aun no conecta a base de datos
	private static ArrayList<Cliente> clientes = null;
	
	public ClienteManager() {
		if (clientes == null) {
			clientes = new ArrayList<Cliente>();
			
			clientes.add(new Cliente(1,"Juan","Perez"));
			clientes.add(new Cliente(2,"Maria","Gonzalez"));
			clientes.add(new Cliente(3,"Lorena","Benitez"));
			clientes.add(new Cliente(4,"Jose","Lopez"));
			clientes.add(new Cliente(5,"Fernando","Martinez"));
		}
	}
	
	public List<Cliente> getClientes() throws Exception {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		List<Cliente> clientes;
		
		try {			
			clientes = session.createQuery("select * from cliente").list();
			trans.commit(); 
		}catch(Exception ex) {
			ex.printStackTrace();
			trans.rollback();
			
			throw ex;
		}			 
		//for(Cliente cliente : clientes) {
			//this.clientes.add(cliente);
		//}
		//return clientes;
		List<Cliente> cualquiera = this.clientes;
		return cualquiera;
	}
	
	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public Cliente getCliente(Integer cedula) {
		Cliente c; 
		Session session = getSession();
		session.beginTransaction();
		
		c = (Cliente)session.load(Cliente.class, cedula);
		
		return c;
	}
	
	//Se da de baja un cliente
	public void eliminarCliente (Cliente cliente) throws Exception {
			Session session = getSession();
			Transaction trans = session.beginTransaction();
			
			try{
				session.delete(cliente);
				trans.commit();
			}catch(Exception ex){
				ex.printStackTrace();
				trans.rollback();
				
				throw ex;
			}
	}
	
	
	//acceso a base de datos
	public void saveCliente(Cliente cliente) throws Exception {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		
		try {			
			session.saveOrUpdate(cliente);
			trans.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			trans.rollback();
			
			throw ex;
		}			
	}
	
	
	
	public Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
