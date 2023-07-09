package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.ITestimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.time.LocalDate;

@Controller
@RequestMapping("/testimonios")
public class TestimonioController {
	@Autowired
	private ITestimonioService testimonioServicio;

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Autowired
	private Usuario usuario;

	@Autowired
	private Testimonio testimonio;

	@GetMapping("/todos")
	public String getTestimonios(Model model) {
		model.addAttribute("testimonios", testimonioServicio.getListaTestimonios());
		return "testimonios";
	}

	@GetMapping("/ingreso_testimonio")
	public ModelAndView ingresoTestimonio(@RequestParam(value = "codigo") String codigo, RedirectAttributes redirectAttributes) {
		ModelAndView modelView = new ModelAndView();

		if (usuarioRepository.findByCodigo(codigo) == null) {
			redirectAttributes.addFlashAttribute("mensaje", "No se encontró el usuario");
			modelView.setViewName("redirect:/testimonios/todos");
		} else {
			usuario = usuarioRepository.findByCodigo(codigo);
			modelView.setViewName("nuevo_testimonio");
			modelView.addObject("codigo", codigo);
			testimonio.setUsuario(usuario);
			modelView.addObject("testimonio", testimonio);
		}
		return modelView;
	}

	@GetMapping("/nuevo_testimonio")
	public String getNuevoTestimonio(Model model) {
		model.addAttribute("testimonio", testimonioServicio.getTestimonio());
		return "nuevo_testimonio";
	}

	@PostMapping("/guardar_testimonio")
	public String guardarTestimonio(@ModelAttribute("testimonio") Testimonio testimonio, Model model) {
		testimonio.setFecha(LocalDate.now());
		testimonioServicio.guardarTestimonio(testimonio);
		System.out.println(testimonio.toString());
		return "redirect:/testimonios/todos";
	}
}
