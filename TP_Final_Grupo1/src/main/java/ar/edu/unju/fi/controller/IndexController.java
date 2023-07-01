package ar.edu.unju.fi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String getIndex(Model model) {
		model.addAttribute("mensaje",null);
		return "index";
	}

}