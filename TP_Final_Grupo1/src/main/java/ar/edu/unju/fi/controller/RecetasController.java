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
	
	@Autowired
	private IRecetaService recetaServicio;
	@Autowired
	private IIngredienteService ingredienteServicio;
	
	@GetMapping("/todos")
	public String getRecetas(Model model) {
		return "recetas";
	}
	@GetMapping("/nueva_receta")
	public String nuevaReceta(Model model) {
		model.addAttribute("Receta",recetaServicio.getReceta());
		model.addAttribute("Ingredientes",ingredienteServicio.getListaIngredientes());
		return "nueva_receta";
	}
	@PostMapping("/guardar_receta")
	public String guardarReceta(@ModelAttribute("Receta")Receta receta,Model model) {
		System.out.println(receta);
		recetaServicio.guardarReceta(receta);
		return "redirect:/recetas/todos";
	}
}
