package ar.edu.unju.fi.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}
}