package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.repository.IUsuarioRepository;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@GetMapping("/imc")
	public ModelAndView getCalculaIMC(@RequestParam(value="codigo") String codigo,HttpServletResponse response,RedirectAttributes redirectAttrs) {
		System.out.println(codigo);
		ModelAndView modelAndView = new ModelAndView("calcular_IMC");
		if(usuarioRepository.findByCodigo(codigo) == null) {
			modelAndView.addObject("mensaje","Error al ingresar el codigo");
			
			modelAndView.setViewName("index");
		}
		
		// Configurar encabezados de caché para evitar almacenamiento en caché
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
		
		return modelAndView;
	}
	
	@GetMapping("/peso_ideal")
	public ModelAndView getPesoIdeal(@RequestParam(value="codigo") String codigo,RedirectAttributes redirectAttrs) {
		System.out.println(codigo);
		ModelAndView modelAndView = new ModelAndView("calcular_peso");
		if(usuarioRepository.findByCodigo(codigo) == null) {
			 redirectAttrs.addFlashAttribute("mensaje", "Codigo incorrecto");
			
			 modelAndView.setViewName("redirect:/index");
		}
		
		
		return modelAndView;
	}

}
