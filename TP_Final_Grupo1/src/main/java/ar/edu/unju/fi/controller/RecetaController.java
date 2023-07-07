package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.service.IIngredienteService;
import ar.edu.unju.fi.service.IRecetaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/recetas")
public class RecetaController {
	
	private Boolean edicion = false;
	
	@Autowired
	private IRecetaService recetaServicio;
	@Autowired
	private IIngredienteService ingredienteServicio;
	
	@GetMapping("/todos")
	public String getPaginaRecetas(Model model) {
		return "recetas";
	}
	@GetMapping("/ver_recetas/{categoria}")
	public String getVerRecetas(@PathVariable(value="categoria")String categoria, Model model) {
		model.addAttribute("Recetas",recetaServicio.getListaRecetasByCategoria(categoria));
		return "mostrar_recetas";
	}
	@GetMapping("/nueva_receta")
	public String getNuevaReceta(Model model) {
		edicion = false;
		model.addAttribute("Receta",recetaServicio.getReceta());
		model.addAttribute("Ingredientes",ingredienteServicio.getListaIngredientes());
		model.addAttribute("edicion",edicion);
		return "nueva_receta";
	}
	@PostMapping("/guardar_receta")
	public String postGuardarReceta(@Valid @ModelAttribute("Receta")Receta receta,Model model, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("Receta",receta);
			model.addAttribute("Ingredientes",ingredienteServicio.getListaIngredientes());
			return "nueva_receta";
		}
		recetaServicio.guardarReceta(receta);
		return "redirect:/recetas/todos";
	}
	@GetMapping("/modificar_receta/{id}")
	public String getModificarReceta(@PathVariable(value="id")Long id, Model model) {
		edicion = true;
		model.addAttribute("Receta",recetaServicio.getById(id));
		model.addAttribute("Ingredientes",ingredienteServicio.getListaIngredientes());
		model.addAttribute("edicion",edicion);
		return "nueva_receta";
	}
	@PostMapping("/modificar_receta")
	public String postModificarReceta(@Valid @ModelAttribute("Receta")Receta receta, Model model, BindingResult result) {
		if(result.hasErrors()) {
			edicion = true;
			model.addAttribute("Receta",receta);
			model.addAttribute("Ingredientes",ingredienteServicio.getListaIngredientes());
			return "nueva_receta";
		}
		recetaServicio.modificarReceta(receta);
		return "redirect:/recetas/todos";
	}
	@GetMapping("/eliminar_receta/{id}")
	public String getEliminarReceta(@PathVariable(value="id")Long id, Model model) {
		recetaServicio.eliminarReceta(recetaServicio.getById(id));
		return "redirect:/recetas/todos";
	}
}
