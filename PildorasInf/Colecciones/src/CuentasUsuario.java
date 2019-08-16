import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentasUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cl1=new Cliente("Jey", "00001", 200000);
		
		Cliente cl2=new Cliente("Claire", "00002", 400000);
		
		Cliente cl3=new Cliente("Anuka", "00003", 600000);
		
		Cliente cl4=new Cliente("Ninfa", "00004", 800000);
		
		Cliente cl5=new Cliente("Jey", "00001", 200000);
		
		Set <Cliente> clientesBanco=new HashSet<Cliente>();
		
		clientesBanco.add(cl1);
		
		clientesBanco.add(cl2);
		
		clientesBanco.add(cl3);
		
		clientesBanco.add(cl4);
		 
		clientesBanco.add(cl5);
		
		for (Cliente cliente : clientesBanco) {
			
			System.out.println(cliente.getNombre() + " " +
			                   cliente.getN_cuenta() + " " +
					           cliente.getSaldo());
			
		}
		
		// MALA forma de hacerlo
		
		for (Cliente cliente : clientesBanco) {
			
			if (cliente.getNombre().equals("Claire")) {
				clientesBanco.remove(cliente);
			}
		}
		
		Iterator<Cliente> it=clientesBanco.iterator();
		
		while(it.hasNext()) {
			
			String nombre_cliente=it.next().getNombre();
			
			if (nombre_cliente.equals("Jey")) {
				it.remove();
			}
			
			
		}
		
		for (Cliente cliente : clientesBanco) {
			
			System.out.println(cliente.getNombre() + " " +
			                   cliente.getN_cuenta() + " " +
					           cliente.getSaldo());
			
		}
		
		
	}

}
