package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IIngredienteService;
import ar.edu.unju.fi.service.IRecetaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/recetas")
public class RecetaController {
	/**
	 * Esta variable manipula la función del formulario (define si guarda o modifica un objeto).
	 */
	private Boolean edicion = false;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	@Autowired
	private IRecetaService recetaServicio;
	@Autowired
	private IIngredienteService ingredienteServicio;
	
	/**
	 * GetMapping que redirige a la página "recetas.html".
	 * @param model
	 * @return recetas.html
	 */
	@GetMapping("/todos")
	public String getPaginaRecetas(Model model) {
		return "recetas";
	}
	/**
	 * GetMapping que redirige a la página que muestra recetas por categoría.
	 * @param categoria
	 * @param model
	 * @return mostrar_recetas.html
	 */
	@GetMapping("/ver_recetas/{categoria}")
	public String getVerRecetas(@PathVariable(value="categoria")String categoria, Model model) {
		model.addAttribute("Recetas",recetaServicio.getListaRecetasByCategoria(categoria));
		return "mostrar_recetas";
	}
	/**
	 * GetMapping que redirige al formulario de recetas en modo "guardar nuevo objeto".
	 * Antes de entrar a la página, pide un código de acceso. Si no es correcto, "devuelve a index.html".
	 * @param codigo
	 * @param model
	 * @return nueva_receta.html
	 */
	@GetMapping("/nueva_receta")
	public String getNuevaReceta(@RequestParam(value="codigo") String codigo,Model model) {
		if(usuarioRepository.findByCodigo(codigo) == null) {
			model.addAttribute("mensaje","Error al ingresar el codigo");
			return "index";
		}else {
			if(usuarioRepository.findByCodigo(codigo).isTipoUsuario() == true) {
				edicion = false;
				model.addAttribute("Receta",recetaServicio.getReceta());
				model.addAttribute("Ingredientes",ingredienteServicio.getListaIngredientes());
				model.addAttribute("edicion",edicion);
				return "nueva_receta";
			}else {
				model.addAttribute("mensaje","Solo los usuario tipo Gestor pueden ingresar a gestion datos !");
				return "index";
			}
		}
	}
	/**
	 * PostMapping que guarda un nuevo objeto.
	 * Contiene validaciones: Si las validaciones se activan, redigire al formulario mostrando los errores.
	 * Si el objeto se crea con éxito, redirige a "recetas.html".
	 * @param receta
	 * @param result
	 * @param model
	 * @return recetas.html
	 */
	@PostMapping("/guardar_receta")
	public String postGuardarReceta(@Valid @ModelAttribute("Receta")Receta receta, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("Receta",receta);
			model.addAttribute("Ingredientes",ingredienteServicio.getListaIngredientes());
			return "nueva_receta";
		}
		recetaServicio.guardarReceta(receta);
		return "redirect:/recetas/todos";
	}
	/**
	 * GetMapping que redigire al formulario de recetas en modo "modificar un objeto ya existente".
	 * @param id
	 * @param model
	 * @return nueva_receta.html
	 */
	@GetMapping("/modificar_receta/{id}")
	public String getModificarReceta(@PathVariable(value="id")Long id, Model model) {
		edicion = true;
		model.addAttribute("Receta",recetaServicio.getById(id));
		model.addAttribute("Ingredientes",ingredienteServicio.getListaIngredientes());
		model.addAttribute("edicion",edicion);
		return "nueva_receta";
	}
	/**
	 * PostMapping que guarda un objeto con modificaciones.
	 * Contiene validaciones: Si las validaciones se activan, redigire al formulario mostrando los errores.
	 * Si el objeto se modifica con éxito, redirige a "recetas.html".
	 * @param receta
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/modificar_receta")
	public String postModificarReceta(@Valid @ModelAttribute("Receta")Receta receta, BindingResult result, Model model) {
		if(result.hasErrors()) {
			edicion = true;
			model.addAttribute("Receta",receta);
			model.addAttribute("Ingredientes",ingredienteServicio.getListaIngredientes());
			return "nueva_receta";
		}
		recetaServicio.modificarReceta(receta);
		return "redirect:/recetas/todos";
	}
	/**
	 * GetMapping que elimina un objeto.
	 * Este método recibe un "id" como parámetro, pero maneja un objeto.
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/eliminar_receta/{id}")
	public String getEliminarReceta(@PathVariable(value="id")Long id, Model model) {
		recetaServicio.eliminarReceta(recetaServicio.getById(id));
		return "redirect:/recetas/todos";
	}
}
