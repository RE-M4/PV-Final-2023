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
	
	@Override
	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return usuario;
	}

	@Override
	public List<Usuario> getListaUsuarios() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.save(usuario);
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.save(usuario);
	}

	@Override
	public Usuario buscarUsuario(long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).get();
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.delete(usuario);
	}

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
