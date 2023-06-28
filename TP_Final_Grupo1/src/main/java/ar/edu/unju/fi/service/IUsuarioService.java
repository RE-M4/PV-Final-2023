package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Usuario;

public interface IUsuarioService {

	public Usuario getUsuario();
	
	public List<Usuario> getListaUsuarios();
	
	public void guardarUsuario(Usuario usuario);
	
	public void modificarUsuario(Usuario usuario);
	
	public Usuario buscarUsuario(long id);
	
	public void eliminarUsuario(Usuario usuario);
}
