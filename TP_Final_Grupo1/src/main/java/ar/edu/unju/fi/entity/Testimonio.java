package ar.edu.unju.fi.entity;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class Testimonio {

	private Usuario usuario;
	private Long id;
	private Date fecha;
	private Usuario usuarioTestimonio;
	private String comentario;

	public Testimonio() {
	}
	public Testimonio(Usuario usuario, Long id, Date fecha, Usuario usuarioTestimonio, String comentario) {
		this.usuario = usuario;
		this.id = id;
		this.fecha = fecha;
		this.usuarioTestimonio = usuarioTestimonio;
		this.comentario = comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuarioTestimonio() {
		return usuarioTestimonio;
	}

	public void setUsuarioTestimonio(Usuario usuarioTestimonio) {
		this.usuarioTestimonio = usuarioTestimonio;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
