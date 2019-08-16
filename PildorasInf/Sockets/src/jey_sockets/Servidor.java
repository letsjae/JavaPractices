package jey_sockets;

import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	
	public MarcoServidor(){
		
		setTitle("Servidor");
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
		Thread hilo=new Thread(this);
		
		hilo.start();
		
		}
	
	@Override
	public void run() {
		
		try {
		
			ServerSocket servidor=new ServerSocket(9999);
			
			String nick, ip, mensaje;
			
			PaqueteEnvio paqueteRecibido = null;
		
			ArrayList<String> listaIp = new ArrayList<String>();
			
			while(true) {
					
				Socket socket=servidor.accept();
				
				ObjectInputStream paqueteDatos=new ObjectInputStream(socket.getInputStream());
				
				try {
					paqueteRecibido=(PaqueteEnvio) paqueteDatos.readObject();
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				nick = paqueteRecibido.getNick();
				
				ip = paqueteRecibido.getIp();
				
				mensaje = paqueteRecibido.getMensaje();
				
				
				if (!mensaje.equals(" ONLINE")) {
					
					areatexto.append("\n"+nick+": "+mensaje+" para: "+ip);
					
					Socket enviarADestinatario=new Socket(ip,9090);
					
					ObjectOutputStream paqueteReenvio=new ObjectOutputStream(enviarADestinatario.getOutputStream());
					
					paqueteReenvio.writeObject(paqueteRecibido);
					
					paqueteReenvio.close();
					
					enviarADestinatario.close();
					
					socket.close();
				
				} else {
				
					// - - - - - Detecta nuevos usuarios
					
					InetAddress localizacion=socket.getInetAddress();
					
					String ipRemota=localizacion.getHostAddress();
					
					System.out.println("Online: " + ipRemota);
					
					listaIp.add(ipRemota);
					
					paqueteRecibido.setIps(listaIp);
					
					for (String i : listaIp) {
						
						// i se corresponde con cada dirección ip del arraylist
						Socket enviarADestinatario=new Socket(i,9090);
						
						ObjectOutputStream paqueteReenvio=new ObjectOutputStream(enviarADestinatario.getOutputStream());
						
						paqueteReenvio.writeObject(paqueteRecibido);
						
						paqueteReenvio.close();
						
						enviarADestinatario.close();
						
						socket.close();
					}
					
					// - - - - - Detecta nuevos usuarios
				
				}
				
//				DataInputStream flujoEntrada=new DataInputStream(socket.getInputStream());
				
//				String mensajeTexto=flujoEntrada.readUTF();
				
//				areatexto.append("\n" + mensajeTexto);
				
			}
		
		} catch (IOException e) {
		
			e.printStackTrace();
		
		}
	}
	
	private	JTextArea areatexto;
	
	
}
