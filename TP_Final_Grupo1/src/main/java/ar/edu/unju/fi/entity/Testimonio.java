package ar.edu.unju.fi.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Entity
@Table(name = "testimonios")
public class Testimonio {

//	private Usuario usuarioTestimonio;
	@Id
	private Long id;
	private Date fecha;
	private String comentario;

	public Testimonio() {
	}
//	public Testimonio(Long id, Date fecha, Usuario usuarioTestimonio, String comentario) {
		public Testimonio(Long id, Date fecha, String comentario) {
		this.id = id;
		this.fecha = fecha;
//		this.usuarioTestimonio = usuarioTestimonio;
		this.comentario = comentario;
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

//	public Usuario getUsuarioTestimonio() {
//		return usuarioTestimonio;
//	}
//
//	public void setUsuarioTestimonio(Usuario usuarioTestimonio) {
//		this.usuarioTestimonio = usuarioTestimonio;
//	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
