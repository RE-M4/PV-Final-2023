package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ingrediente")
public class IngredienteController {
	
	@GetMapping("/nuevo_ingrediente")
	public ModelAndView getNuevoIngrediente() {
		ModelAndView modeAndView = new ModelAndView("nuevo_ingrediente");
		
		return modeAndView;
	}
}
