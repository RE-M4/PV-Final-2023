package ar.edu.unju.fi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String getIndex(Model model) {
		model.addAttribute("mensaje",null);
		return "index";
	}
	@GetMapping("/contacto")
	public String getContacto(Model model) {
		return "contacto";
	}

}