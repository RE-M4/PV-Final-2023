package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IIngredienteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingrediente")
public class IngredienteController {
	
	@Autowired
	IIngredienteService ingredienteService;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@GetMapping("/nuevo_ingrediente")
	public ModelAndView getNuevoIngrediente(@RequestParam(value="codigo") String codigo) {
		ModelAndView modelAndView = new ModelAndView("nuevo_ingrediente");
		
		if(usuarioRepository.findByCodigo(codigo) == null) {
			modelAndView.addObject("mensaje","Error al ingresar el codigo");
			
			modelAndView.setViewName("index");
			return modelAndView;
		}
		
		
		modelAndView.addObject("Ingrediente", ingredienteService.getIngrediente());
		modelAndView.addObject("listaIngredientes",ingredienteService.getListaIngredientesByEstado());
		return modelAndView;
	}
	
	@PostMapping("/guardar_ingrediente")
	public ModelAndView setGuardarIngrediente(@Valid @ModelAttribute("Ingrediente") Ingrediente ingrediente, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("redirect:/ingrediente/nuevo_ingrediente");
		if(result.hasErrors()) {
			modelAndView.setViewName("nuevo_ingrediente");
			modelAndView.addObject(ingrediente);
			modelAndView.addObject("listaIngredientes",ingredienteService.getListaIngredientesByEstado());
			return modelAndView;
		}
		ingredienteService.guardarIngrediente(ingrediente);
		modelAndView.addObject("Ingrediente", ingredienteService.getIngrediente());
		modelAndView.addObject("listaIngredientes",ingredienteService.getListaIngredientesByEstado());
		return modelAndView;
	}
	
	
	/*@GetMapping("/modificar_ingrediente/{id}")
	public ModelAndView modificarIngrediente(@PathVariable(value="id")Long id) {
		ModelAndView modelAndView = new ModelAndView("nuevo_ingrediente");
		Ingrediente ingredienteEncontrado = ingredienteService.buscarIngrediente(id);
		boolean edicion = true;
		modelAndView.addObject("Ingrediente", ingredienteEncontrado);
		modelAndView.addObject("edicion", edicion);
		return modelAndView;
	}
	
	@PostMapping("/modificar_ingrediente")
	public ModelAndView modificarIngrediente(@ModelAttribute("Ingrediente") Ingrediente ingrediente) {
		ModelAndView modelAndView = new ModelAndView("redirect:/ingrediente/nuevo_ingrediente");
		ingredienteService.modificarIngrediente(ingrediente);
		modelAndView.addObject("Ingrediente", ingredienteService.getIngrediente());
		modelAndView.addObject("listaIngredientes",ingredienteService.getListaIngredientes());	
		return modelAndView;
	}*/
	
	@GetMapping("/eliminar_ingrediente/{id}")
	public ModelAndView eliminarIngrediente(@PathVariable(value="id")Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/ingrediente/nuevo_ingrediente");
		ingredienteService.eliminarIngrediente(ingredienteService.buscarIngrediente(id));
		return modelAndView;
	}
}
