package es.jey.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/secundario")
public class TirarControlador {
	
	
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario() {
		
		return "HolaMundoFormulario";
		
	}
	
	@RequestMapping("procesaFormularioII")
//	public String otroProcesoFormulario(HttpServletRequest request, Model modelo) {
	
	public String otroProcesoFormulario(@RequestParam("nombreAlumno") String nombre, Model modelo) {
		
		/* Leer le información que viene del formulario */
		
//		String nombre=request.getParameter("nombreAlumno");
		
		nombre+=" es el peor estudiante!";
		
		String msjFinal="Quién es el peor alumno? " + nombre;
		
		/* Agregando info al modelo */
		
		modelo.addAttribute("msjResultante", msjFinal);
		
		return "HolaMundoSpring";
	}
}
