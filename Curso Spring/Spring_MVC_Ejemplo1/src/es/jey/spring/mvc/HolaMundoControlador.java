package es.jey.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/principal")
public class HolaMundoControlador {
	
	/* Proporciona el formulario
	   Debemos indicarle a Spring que este método es el 
	   encargado de pedirle al servidor vía URL éste formulario,
	   en el parámetro indicamos cuál es la URL a utilizar para que 
	   al usuario se le devuelva el formulario */
	
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario() {
		
		return "HolaMundoFormulario";
		
	}
	
	/* La segunda parte es crear el método que procese
	   la información que el usuario haya dado en el formulario,
	   URL de la respuesta: */
	
	@RequestMapping("procesaFormulario")
	public String procesaFormulario() {
		
		return "HolaMundoSpring";
		
	}
	
	/* Un método para pedirle el formulario al servidor y otro método para que
	   procese la información otorgada */
	
	@RequestMapping("procesaFormularioII")
//	public String otroProcesoFormulario(HttpServletRequest request, Model modelo) {
	
	public String otroProcesoFormulario(@RequestParam("nombreAlumno") String nombre, Model modelo) {
		
		/* Leer le información que viene del formulario */
		
//		String nombre=request.getParameter("nombreAlumno");
		
		nombre+=" es el mejor estudiante!";
		
		String msjFinal="Quién es el mejor alumno? " + nombre;
		
		/* Agregando info al modelo */
		
		modelo.addAttribute("msjResultante", msjFinal);
		
		return "HolaMundoSpring";
	}
	
}
