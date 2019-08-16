package es.jey.pruebaAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("es.jey.pruebaAnnotations")
@PropertySource("classpath:datosEmpresa.propiedades")
public class EmpleadosConfig {

	// Definir el bean para informe financiero departamento compras
	
	@Bean
	public CreacionInformeFinanciero informeFinancieroDepartamentoCompras() { // será el id del bean inyectado
		
		return new InformeFinancieroDeptoCompras();
		
	}
	
	// Definir el bean para DirectorFinanciedo e inyectar dependencias
	
	@Bean // La clave está en identificar al objeto con la annotation bean
	public Empleados directorFinanciero() {
		
		return new DirectorFinanciero(informeFinancieroDepartamentoCompras());
	
	}
	
}
