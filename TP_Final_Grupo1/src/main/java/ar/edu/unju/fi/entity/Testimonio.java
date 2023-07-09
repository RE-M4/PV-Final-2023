package ar.edu.unju.fi.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
@Component
@Entity
@Table(name = "testimonios")
public class Testimonio {
	/**
	 * Id único del testimonio.
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="test_id")
	@Id
	private Long id;
	/**
	 * Fecha en que se realizó el testimonio.
	 */
	@Column(name = "test_fecha")
	private LocalDate fecha;
	/**
	 * Comentario del testimonio.
	 */
	@NotEmpty(message = "El comentario es requerido")
	@Column(name="test_comentario")
	private String comentario;
	/**
	 * Usuario que realizó el testimonio.
	 */
	@JoinColumn(name = "usu_id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Usuario usuario;
	/**
	 * Estado del testimonio.
	 */
	@Column(name="test_estado")
	private boolean estado;
	/**
	 * Devuelve el estado del testimonio.
	 *
	 * @return true si el testimonio está activo, false si está inactivo.
	 */
	public boolean isEstado() {
		return estado;
	}
	/**
	 * Establece el estado del testimonio.
	 *
	 * @param estado - estado del testimonio.
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	/**
	 * Devuelve el usuario que realizó el testimonio.
	 *
	 * @return usuario que realizó el testimonio.
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * Establece el usuario que realizó el testimonio.
	 *
	 * @param usuario - usuario que realizó el testimonio.
	 */

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * Crea una nueva instancia de la clase Testimonio.
	 * La fecha se establece como la fecha actual y el estado se establece como activo.
	 */
	public Testimonio() {
		this.fecha = LocalDate.now();
		this.estado = true;
	}

	/**
	 * Crea una nueva instancia de la clase Testimonio con los valores especificados.
	 *
	 * @param id         el identificador del testimonio.
	 * @param fecha      la fecha del testimonio.
	 * @param comentario el comentario del testimonio.
	 * @param usuario    el usuario que realizó el testimonio.
	 * @param estado     el estado del testimonio.
	 */
	public Testimonio(Long id, LocalDate fecha, String comentario, Usuario usuario, boolean estado) {
		this.id = id;
		this.fecha = fecha;
		this.comentario = comentario;
		this.usuario = usuario;
		this.estado = estado;
	}
	/**
	 * Devuelve el identificador del testimonio.
	 *
	 * @return el identificador del testimonio.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Establece el identificador del testimonio.
	 *
	 * @param id - el identificador del testimonio.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Devuelve la fecha del testimonio.
	 *
	 * @return la fecha del testimonio.
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	/**
	 * Establece la fecha del testimonio.
	 *
	 * @param fecha - la fecha del testimonio.
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	/**
	 * Devuelve el comentario del testimonio.
	 *
	 * @return el comentario del testimonio.
	 */

	public String getComentario() {
		return comentario;
	}
	/**
	 * Establece el comentario del testimonio.
	 *
	 * @param comentario - el comentario del testimonio.
	 */

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	/**
	 * Devuelve una cadena de caracteres que representa al testimonio.
	 *
	 * @return una cadena de caracteres que representa al testimonio.
	 */
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
