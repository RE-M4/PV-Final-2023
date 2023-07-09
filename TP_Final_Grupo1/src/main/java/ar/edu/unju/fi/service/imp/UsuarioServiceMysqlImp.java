package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IUsuarioService;

@Service("UsuarioServiceMysqlImp")
public class UsuarioServiceMysqlImp implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private Usuario usuario;
	
	
	
	/**
	 * Retorna el objeto Usuario utilizado en el servicio.
	 *
	 * @return el objeto Usuario utilizado en el servicio.
	 */
	@Override
	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return usuario;
	}

	
	/**
	 * Retorna una lista de todos los usuarios registrados.
	 *
	 * @return una lista de todos los usuarios registrados.
	 */
	@Override
	public List<Usuario> getListaUsuarios() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioRepository.findAll();
	}

	
	/**
	 * Guarda un usuario en el repositorio.
	 *
	 * @param usuario el objeto Usuario a guardar
	 */
	@Override
	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.save(usuario);
	}

	
	/**
	 * Modifica un usuario en el repositorio.
	 *
	 * @param usuario el objeto Usuario a modificar
	 */
	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.save(usuario);
	}

	
	/**
	 * Busca un usuario por su ID.
	 *
	 * @param id el ID del usuario a buscar
	 * @return el objeto Usuario correspondiente al ID buscado
	 */
	@Override
	public Usuario buscarUsuario(long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).get();
	}

	
	/**
	 * Elimina un usuario del repositorio.
	 *
	 * @param usuario el objeto Usuario a eliminar
	 */
	@Override
	public void eliminarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.delete(usuario);
	}

	
	/**
	 * Genera un código de 6 dígitos para un usuario.
	 *
	 * @return el código generado
	 */
	@Override
	public String generarCodigo() {
		 
	    int longitudCodigo = 6; 
 
	    Random random = new Random();

	    StringBuilder codigo = new StringBuilder();
	    for (int i = 0; i < longitudCodigo; i++) {
	        int digito = random.nextInt(10); 
	        codigo.append(digito);
	    }
	    
	    return codigo.toString();
	}

}
