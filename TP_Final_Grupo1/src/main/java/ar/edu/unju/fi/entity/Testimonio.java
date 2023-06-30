package ar.edu.unju.fi.entity;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.entity.Usuario;
import java.util.Date;
@Component
@Entity
@Table(name = "testimonios")
public class Testimonio {


//	private Usuario usuarioTestimonio;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="test_id")
	@Id
	private Long id;
	@Column(name="test_fecha")
	private Date fecha;
	@Column(name="test_comentario")
	private String comentario;
	@JoinColumn(name = "usu_id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Usuario usuario;
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Testimonio() {
	}
//	public Testimonio(Long id, Date fecha, Usuario usuarioTestimonio, String comentario) {
		public Testimonio(Long id, Date fecha, String comentario, Usuario usuario) {
		this.id = id;
		this.fecha = fecha;
		this.comentario = comentario;
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
