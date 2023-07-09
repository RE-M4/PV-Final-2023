package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.ITestimonioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

	/**
	 * Método que devuelve la vista de la lista de testimonios.
	 * @param model Modelo pasa los datos a la vista.
	 * @return Devuelve la vista de la lista de testimonios.
	 */
	@GetMapping("/todos")
	public String getTestimonios(Model model) {
		model.addAttribute("testimonios", testimonioServicio.getListaTestimonios());
		return "testimonios";
	}

	/**
	 * Muestra la vista de la página para ingresar el codigo del usuario.
	 * @param codigo Código del usuario.
	 * @param redirectAttributes Permite agregar un mensaje para mostrar en la vista.
	 * @return Devuelve la vista de la página de nuevo testimonio.
	 */
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

	/**
	 * Metodo que permite crear un nuevo testimonio.
	 * @return Vista "nuevo_testimonio" para crear un nuevo testimonio.
	 */
	@GetMapping("/nuevo_testimonio")
	public String getNuevoTestimonio(Model model) {
		model.addAttribute("testimonio", testimonioServicio.getTestimonio());
		return "nuevo_testimonio";
	}

	/**
	 * Metodo que permite guardar un nuevo testimonio.
	 * @param testimonio - testimonio a guardar
	 * @param resultadoValidacion - resultado de la validacion del testimonio
	 * @param model - modelo para pasar datos a la vista
	 * @return vista "nuevo_testimonio" si el resultado de la validacion tiene errores,
	 */
	@PostMapping("/guardar_testimonio")
	public String guardarTestimonio(@Valid @ModelAttribute("testimonio") Testimonio testimonio, BindingResult resultadoValidacion, Model model) {
		if (resultadoValidacion.hasErrors()) {
			model.addAttribute("testimonio", testimonio);
			return "nuevo_testimonio";
		}
		testimonio.setFecha(LocalDate.now());
		testimonioServicio.guardarTestimonio(testimonio);
		return "redirect:/testimonios/todos";
	}
}
