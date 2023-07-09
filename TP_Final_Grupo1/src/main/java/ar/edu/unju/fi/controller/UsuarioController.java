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
	
	
	/**
	 * Maneja la solicitud GET para /usuario/nuevo_usuario y muestra la vista "nuevo_usuario".
	 * Obtiene un objeto Usuario del servicio usuarioservice, genera un código para el usuario y lo agrega al modelo.
	 *
	 * @param model el modelo utilizado para agregar el objeto Usuario
	 * @return el nombre de la vista "nuevo_usuario" para renderizar la respuesta.
	 */
	@GetMapping("/nuevo_usuario")
	public String Usuario(Model model) {
		Usuario usu = usuarioservice.getUsuario();
		usu.setCodigo(usuarioservice.generarCodigo());
		model.addAttribute("Usuario", usu);
		return "nuevo_usuario";
	}
	
	/**
	 * Maneja la solicitud POST para /usuario/guardar_usuario y guarda un objeto Usuario.
	 * Guarda el objeto Usuario en el servicio usuarioservice, genera un código y lo agrega al modelo.
	 *
	 * @param usuario el objeto Usuario a guardar
	 * @param model el modelo utilizado para agregar el mensaje y el código generado
	 * @return el nombre de la vista "index" para renderizar la respuesta.
	 */
	@PostMapping("/guardar_usuario")
    public String guardar(@ModelAttribute("Usuario") Usuario usuario,Model model) {
        System.out.println(usuario);
       
        usuario.setCodigo(usuarioservice.generarCodigo());
        usuario.setTipoUsuario(false);
        model.addAttribute("mensajeCodigo","         Su codigo es: "+usuario.getCodigo()+"  ¡¡¡¡Por favor guardelo !!!!");
		usuarioservice.guardarUsuario(usuario);
   
    return "index";
    } 
	
	/**
	 * Maneja la solicitud GET para /usuario/eliminarUsuario/{Id} y elimina un objeto Usuario.
	 * Elimina el objeto Usuario correspondiente al ID proporcionado en el servicio usuarioservice.
	 *
	 * @param model el modelo utilizado para agregar el mensaje de éxito
	 * @param Id el ID del Usuario a eliminar
	 * @return una redirección a la ruta /usuario/ListaUsuario
	 */
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
	
	
	/**
	 * Maneja la solicitud POST para /usuario/modificarUsuario y modifica un objeto Usuario.
	 * Modifica el objeto Usuario proporcionado en el servicio usuarioservice.
	 *
	 * @param usuario el objeto Usuario a modificar
	 * @param model el modelo utilizado para agregar el mensaje de éxito
	 * @return el nombre de la vista "/modificarUsuario" para renderizar la respuesta.
	 */
	@PostMapping("/modificarUsuario")
	public String postModificarUsuario(@ModelAttribute("Usuario")Usuario usuario, Model model) {
		usuarioservice.modificarUsuario(usuario);
		return "/modificarUsuario";
	}
	
}