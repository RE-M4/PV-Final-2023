package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.repository.IUsuarioRepository;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@GetMapping("/imc")
	public ModelAndView getCalculaIMC(@RequestParam(value="codigo") String codigo) {
		System.out.println(codigo);
		ModelAndView modelAndView = new ModelAndView("calcular_IMC");
		if(usuarioRepository.findByCodigo(codigo) == null) {
			modelAndView.setViewName("redirect:/#");
		}
		
		
		return modelAndView;
	}

}
