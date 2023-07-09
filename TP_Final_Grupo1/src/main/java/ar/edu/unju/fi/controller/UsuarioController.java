package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	@Qualifier("UsuarioServiceMysqlImp")
	private IUsuarioService usuarioservice;
	
	
	
	@GetMapping("/nuevo_usuario")
	public String Usuario(Model model) {
		Usuario usu = usuarioservice.getUsuario();
		usu.setCodigo(usuarioservice.generarCodigo());
		model.addAttribute("Usuario", usu);
		return "nuevo_usuario";
	}
	
	@PostMapping("/guardar_usuario")
    public String guardar(@ModelAttribute("Usuario") Usuario usuario,Model model) {
        System.out.println(usuario);
       
        usuario.setCodigo(usuarioservice.generarCodigo());
        usuario.setTipoUsuario(false);
        model.addAttribute("mensajeCodigo","         Su codigo es: "+usuario.getCodigo()+"  ¡¡¡¡Por favor guardelo !!!!");
		usuarioservice.guardarUsuario(usuario);
   
    return "index";
    } 
	
	@GetMapping("/eliminarUsuario/{Id}")
    public String eliminarUsuario(Model model, @PathVariable(value="id")String Id) {
	for (Usuario usuario  : usuarioservice.getListaUsuarios()) {
		if (usuario.getId().equals(Id)) {
			usuarioservice.eliminarUsuario(usuario);
			break;
		}
	}
	return "redirect:/usuario/ListaUsuario";
	}	
	
	@PostMapping("/modificarUsuario")
	public String postModificarUsuario(@ModelAttribute("Usuario")Usuario usuario, Model model) {
		usuarioservice.modificarUsuario(usuario);
		return "/modificarUsuario";
	}
	
}