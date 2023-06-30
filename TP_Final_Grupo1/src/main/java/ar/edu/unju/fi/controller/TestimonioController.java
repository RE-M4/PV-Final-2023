package ar.edu.unju.fi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/testimonios")
public class TestimonioController {
	@GetMapping("/todos")
	public String getRecetas(Model model) {
		return "testimonios";
	}

}
