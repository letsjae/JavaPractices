package es.jey.pruebaAnnotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Spring registra automaticamente este bean:
@Component("ComercialExperimentado")
// Se puede prescindir de darle un nombre al bean poniendo solamente 
// @Component -> le da el mismo nombre pero! con la primer letra en minúscula
// @Scope("prototype")
public class ComercialExperimentado implements Empleados {

	// Ejecución de código después de creación de bean
	
	@PostConstruct
	public void ejecutaDespuesCreación() {
		System.out.println("Ejecutado tras creación de bean");
	}
	
	// Ejecución de código después de apagado contenedor Spring
	
	@PreDestroy
	public void ejecutaAntesDestrucción() {
		System.out.println("Ejecutando antes de la destrucción");
	}
	
	public ComercialExperimentado() {
		// TODO Auto-generated constructor stub
	}
	
	/*@Autowired
	public ComercialExperimentado(CreacionInformeFinanciero nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}*/
	
	public void setNuevoInforme(CreacionInformeFinanciero nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}
	
	@Override
	public String getTareas() {
		return "Vender, vender y vender más";
	}

	@Override
	public String getInforme() {
//		return "Informe generado por el comercial";
		
		return nuevoInforme.getInformeFinanciero();
	}
	
	@Autowired
	@Qualifier("informeFinancieroTrim4") // bean id que debe utilizar
	private CreacionInformeFinanciero nuevoInforme;

}
