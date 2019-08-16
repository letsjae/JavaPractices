package controlador;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.*;
import vista.*;

public class ControladorBotonEjecuta implements ActionListener {

	
	public ControladorBotonEjecuta(Marco_Aplicacion_II marco) {
	
		this.marco=marco;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String seleccionSeccion=(String) marco.secciones.getSelectedItem();
		
		String seleccionPais=(String) marco.paises.getSelectedItem();
		
		resultadoConsulta=obj.filtraBBDD(seleccionSeccion, seleccionPais);
		
		try {
			
			marco.resultado.setText("");
			
			while(resultadoConsulta.next()) {
				
				marco.resultado.append(resultadoConsulta.getString(1));
				
				marco.resultado.append(", ");
				
				marco.resultado.append(resultadoConsulta.getString(2));
				
				marco.resultado.append(", ");
				
				marco.resultado.append(resultadoConsulta.getString(3));
				
				marco.resultado.append(", ");
				
				marco.resultado.append(resultadoConsulta.getString(4));
				
				marco.resultado.append("\n");
				
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private Marco_Aplicacion_II marco;
	
	EjecutaConsultas obj=new EjecutaConsultas();
	
	private ResultSet resultadoConsulta;
	
}
