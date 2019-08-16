package controlador;

import java.awt.event.*;

import modelo.*;
import vista.*;

// Manejará el evento al abrir...
public class ControladorCargaMenus extends WindowAdapter{
	
	public ControladorCargaMenus(Marco_Aplicacion_II marco) {
		
		this.marco=marco;
		
	}
	
	public void windowOpened(WindowEvent e) {
		
		obj.ejecutaConsultas();
		
		try {
			
			while(obj.rs.next()) {
				
				marco.secciones.addItem(obj.rs.getString(1));
				
			}
			
			while(obj.rs2.next()) {
				
				marco.paises.addItem(obj.rs2.getString(1));
				
			}
			
		} catch (Exception e2) {

			e2.printStackTrace();
			
		}
		
	}
	
	CargaMenus obj=new CargaMenus();
	
	private Marco_Aplicacion_II marco;
	
}
