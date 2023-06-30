package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.service.IIngredienteService;
import ar.edu.unju.fi.service.IRecetaService;

@Controller
@RequestMapping("/recetas")
public class RecetasController {
	
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
		return null;
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
	public String postGuardarReceta(@ModelAttribute("Receta")Receta receta,Model model) {
		recetaServicio.guardarReceta(receta);
		//model.addAttribute("")
		return "redirect:/recetas/todos";
	}
	@GetMapping("/modificar_receta/{id}")
	public String getModificarReceta(@PathVariable(value="id")Long id, Model model) {
		edicion = true;
		model.addAttribute("Receta",recetaServicio.getById(id));
		return null;
	}
}
