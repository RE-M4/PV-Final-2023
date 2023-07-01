package ar.edu.unju.fi.controller;


import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.service.ITestimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/testimonios")
public class TestimonioController {
	@Autowired
	private ITestimonioService testimonioServicio;
	@GetMapping("/todos")
	public String getTestimonios(Model model) {
		return "testimonios";
	}
	@GetMapping("/nuevo_testimonio")
	public String nuevaReceta(Model model) {
		model.addAttribute("Testimonio", testimonioServicio.getTestimonio());
		return "nuevo_testimonio";
	}
	@PostMapping("/guardar_testimonio")
	public String guardarReceta(@ModelAttribute("Testimonio") Testimonio testimonio, Model model) {
		testimonioServicio.guardarTestimonio(testimonio);
		return "redirect:/testimonios/todos";
	}

}
