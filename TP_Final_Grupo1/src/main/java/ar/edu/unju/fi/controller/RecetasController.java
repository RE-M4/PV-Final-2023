package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recetas")
public class RecetasController {
	@GetMapping("/todos")
	public String getRecetas(Model model) {
		return "recetas";
	}
}
