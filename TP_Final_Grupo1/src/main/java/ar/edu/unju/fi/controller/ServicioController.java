package ar.edu.unju.fi.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private IIndiceMasaCorporalService indiceMasaCorporalService;

	@Autowired
	IndiceMasaCorporal nuevoIMC;

	/**
	 * Maneja la solicitud GET para /servicio/imc y muestra la vista "calcular_IMC".
	 * Calcula el índice de masa corporal (IMC) para un usuario específico y muestra la lista de registros IMC.
	 *
	 * @param codigo el código del usuario para calcular el IMC
	 * @return el objeto ModelAndView que representa la vista "calcular_IMC" con el IMC y la lista de registros IMC.
	 */
	@GetMapping("/imc")
	public ModelAndView getCalculaIMC(@RequestParam(value="codigo") String codigo) {
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
		List<IndiceMasaCorporal> registros = usuarioRepository.findByCodigo(codigo).getRegistrosIMC();
		Collections.reverse(registros);
		modelAndView.addObject("listaRegistros", registros);
		System.out.println(usuarioRepository.findByCodigo(codigo).getRegistrosIMC());
		
		return modelAndView;
	}
	
	
	/**
	 * Maneja la solicitud GET para /servicio/peso_ideal y muestra la vista "calcular_peso".
	 * Calcula el peso ideal para un usuario específico y lo muestra en la vista.
	 *
	 * @param codigo el código del usuario para calcular el peso ideal
	 * @return el objeto ModelAndView que representa la vista "calcular_peso" con el usuario y el peso ideal.
	 */
	@GetMapping("/peso_ideal")
	public ModelAndView getPesoIdeal(@RequestParam(value="codigo") String codigo) {
		System.out.println(codigo);

		ModelAndView modelAndView = new ModelAndView("calcular_peso");
		if(usuarioRepository.findByCodigo(codigo) == null) {
			modelAndView.addObject("mensaje","Error al ingresar el codigo");
			modelAndView.setViewName("index");
			return modelAndView;
		}
		Usuario usuario = usuarioRepository.findByCodigo(codigo);
		double pesoIdeal =indiceMasaCorporalService.calcularPesoIdeal(usuario);
		modelAndView.addObject("usuario",usuario);
		modelAndView.addObject("pesoIdeal", pesoIdeal);
		
		return modelAndView;
	}

	/**
	 * Maneja la solicitud POST para /servicio/calcular_imc y calcula el IMC para un usuario.
	 * Calcula el IMC utilizando los datos proporcionados en el objeto IndiceMasaCorporal y lo guarda en el servicio.
	 * Redirige a la vista "calcular_IMC" para mostrar el resultado actualizado y la lista de registros IMC.
	 *
	 * @param imc el objeto IndiceMasaCorporal con los datos del IMC a calcular y el usuario asociado
	 * @return el objeto ModelAndView que representa la redirección a la vista "calcular_IMC".
	 */
	@PostMapping("/calcular_imc")
	public ModelAndView calcularIMC(@Valid @ModelAttribute("imc") IndiceMasaCorporal imc,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("redirect:/servicio/imc?codigo="+imc.getUsuario().getCodigo());
		if(result.hasErrors()) {
			modelAndView.addObject("imc", imc);
			List<IndiceMasaCorporal> registros =imc.getUsuario().getRegistrosIMC();
			Collections.reverse(registros);
			
			modelAndView.addObject("listaRegistros",registros);
			modelAndView.setViewName("calcular_IMC");
			return modelAndView;
		}
		
		imc.setEstadoCorporal(indiceMasaCorporalService.calcularIMC(imc.getPeso(), imc.getUsuario().getEstatura()));
		indiceMasaCorporalService.guardarImc(imc);

		modelAndView.addObject("listaRegistros",usuarioRepository.findByCodigo(imc.getUsuario().getCodigo()).getRegistrosIMC());

		

		return modelAndView;
	}

}
