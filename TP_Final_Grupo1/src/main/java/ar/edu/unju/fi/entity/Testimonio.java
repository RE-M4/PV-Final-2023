package ar.edu.unju.fi.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
@Component
@Entity
@Table(name = "testimonios")
public class Testimonio {

//	private Usuario usuarioTestimonio;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="test_id")
	@Id
	private Long id;

	@Column(name = "test_fecha")
	private LocalDate fecha;
	@NotEmpty(message = "El comentario es requerido")
	@Column(name="test_comentario")
	private String comentario;
	@JoinColumn(name = "usu_id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Usuario usuario;
	@Column(name="test_estado")
	private boolean estado;



	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Testimonio() {
		this.fecha = LocalDate.now();
		this.estado = true;
	}
//	public Testimonio(Long id, Date fecha, Usuario usuarioTestimonio, String comentario) {

	public Testimonio(Long id, LocalDate fecha, String comentario, Usuario usuario, boolean estado) {
		this.id = id;
		this.fecha = fecha;
		this.comentario = comentario;
		this.usuario = usuario;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@Override
	public String toString() {
		return "Testimonio{" +
				"id=" + id +
				", fecha=" + fecha +
				", comentario='" + comentario + '\'' +
				", usuario=" + usuario +
				'}';
	}
}
