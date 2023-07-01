package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private IIndiceMasaCorporalService indiceMasaCorporalService;

	@Autowired
	IndiceMasaCorporal nuevoIMC;

	@GetMapping("/imc")
	public ModelAndView getCalculaIMC(@RequestParam(value="codigo") String codigo,RedirectAttributes redirectAttrs) {
		System.out.println(codigo);
		ModelAndView modelAndView = new ModelAndView("calcular_IMC");
		if(usuarioRepository.findByCodigo(codigo) == null) {
			modelAndView.addObject("mensaje","Error al ingresar el codigo");
			
			modelAndView.setViewName("index");
			return modelAndView;
		}
		

		nuevoIMC.setUsuario(usuarioRepository.findByCodigo(codigo));
		System.out.println(nuevoIMC.toString());

		modelAndView.addObject("imc",  nuevoIMC);
		modelAndView.addObject("listaRegistros", usuarioRepository.findByCodigo(codigo).getRegistrosIMC());
		System.out.println(usuarioRepository.findByCodigo(codigo).getRegistrosIMC());
		
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

	@PostMapping("/calcular_imc")
	public ModelAndView calcularIMC(@ModelAttribute("imc") IndiceMasaCorporal imc) {

		imc.setEstadoCorporal(indiceMasaCorporalService.calcularIMC(imc.getPeso(), imc.getUsuario().getEstatura()));
		indiceMasaCorporalService.guardarImc(imc);


		ModelAndView modelAndView = new ModelAndView("redirect:/servicio/imc?codigo="+imc.getUsuario().getCodigo());
		modelAndView.addObject("listaRegistros",usuarioRepository.findByCodigo(imc.getUsuario().getCodigo()).getRegistrosIMC());


		return modelAndView;
	}

}
