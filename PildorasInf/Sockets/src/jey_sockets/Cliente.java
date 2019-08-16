package jey_sockets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;

import java.net.*;
import java.util.ArrayList;


public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setTitle("CLIENTE");
		
		addWindowListener(new EnvioOnline());
		
		setVisible(true);
		
	}	
	
}

class EnvioOnline extends WindowAdapter {
	
	public void windowOpened(WindowEvent e) {
		
		try {
			
			Socket socket = new Socket("192.168.1.206", 9999);
			
			// Paquete donde enviaremos datos
			
			PaqueteEnvio datos=new PaqueteEnvio();
			
			datos.setMensaje(" ONLINE");
			
			ObjectOutputStream flujoOnline=new ObjectOutputStream(socket.getOutputStream());
			
			flujoOnline.writeObject(datos);
			
			socket.close();
			
		} catch (Exception ex) {
			// TODO: handle exception
		}
		
	}
	
}

class LaminaMarcoCliente extends JPanel implements Runnable{
	
	public LaminaMarcoCliente(){
		
		String nick_usuario=JOptionPane.showInputDialog("Nick:");
		
		JLabel n_nick=new JLabel("Nick:");
		
		add(n_nick);
		
		JLabel texto=new JLabel("-- Online --");
		
		nick=new JLabel();
		
		nick.setText(nick_usuario);
		
		add(nick);
		
		add(texto);
	
//		String[] activos= {"Usuario1","Usuario2","Usuario3"};
		
		ip=new JComboBox();
		
//		ip.addItem("192.168.1.45");

		add(ip);
		
		campoChat=new JTextArea(12,20);
		
		add(campoChat);
		
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
		
		EnviaTexto evento=new EnviaTexto();
		
		miboton.addActionListener(evento);
		
		add(miboton);
		
		Thread hilo=new Thread(this);
		
		hilo.start();
		
	}
	
	
	private class EnviaTexto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
//			System.out.println(campo1.getText());
			
			campoChat.append("\n"+campo1.getText());
			
			try {
				
				Socket socket=new Socket("192.168.1.206", 9999);
				
				// Empaquetemos los datos
				
				PaqueteEnvio datos=new PaqueteEnvio();
				
				datos.setNick(nick.getText());
				
				datos.setIp(ip.getSelectedItem().toString());
				
				datos.setMensaje(campo1.getText());
				
				//Enviamos el paquete por la red
				
				ObjectOutputStream paqueteDatosSalida=new ObjectOutputStream(socket.getOutputStream());
				
				paqueteDatosSalida.writeObject(datos);
				
				socket.close();
				
//				DataOutputStream flujoSalida= new DataOutputStream(socket.getOutputStream());
//				
//				flujoSalida.writeUTF(campo1.getText());
//				
//				flujoSalida.close();
				
			} catch (UnknownHostException e) {
				
				e.printStackTrace();
				
			} catch (IOException e) {
				
				System.out.println(e.getMessage());
				
			}
			 
		}
		
	}

	@Override
	public void run() {
		
		try {
			ServerSocket servidorCliente=new ServerSocket(9090);
			
			Socket cliente;
			
			PaqueteEnvio paqueteRecibido;
			
			while(true) {
				cliente=servidorCliente.accept();
				
				ObjectInputStream flujoEntrada=new ObjectInputStream(cliente.getInputStream());
				
				paqueteRecibido=(PaqueteEnvio) flujoEntrada.readObject();
				
				if (!paqueteRecibido.getMensaje().equals(" ONLINE")) {
					
					campoChat.append("\n"+paqueteRecibido.getNick()+": "+paqueteRecibido.getMensaje());	
				
				} else {		
				
					campoChat.append("\n" + paqueteRecibido.getIps());
					
					ArrayList<String> ipsMenu=new ArrayList<String>();
					
					ipsMenu=paqueteRecibido.getIps();
					
					// Borrar todo lo q pudiera haber en el combo box del anterior
					ip.removeAllItems();
					
					for (String i : ipsMenu) {
						ip.addItem(i);
					}
				
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	private JTextField campo1;
	
	private JComboBox ip;

	private JLabel nick;
	
	private JTextArea campoChat;
	
	private JButton miboton;
	
}


class PaqueteEnvio implements Serializable{
	
	private String nick, ip, mensaje;
	
	private ArrayList<String> ips;

	public ArrayList<String> getIps() {
		return ips;
	}

	public void setIps(ArrayList<String> ips) {
		this.ips = ips;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}













