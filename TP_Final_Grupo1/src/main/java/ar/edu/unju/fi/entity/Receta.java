package ar.edu.unju.fi.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Component
@Entity
@Table(name="recetas")
public class Receta {
	/*Atributos*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rec_id")
	private Long id;
	@Column(name="rec_nombre")
	@NotEmpty(message=("Este campo no puede estar vacío"))
	@Size(min=5, message="Este campo tiene que tener al menos 5 caracteres")
	private String nombre;
	@Column(name="rec_categoria")
	@NotEmpty(message=("Este campo no puede estar vacío"))
	private String categoria;
	@Column(name="rec_preparacion")
	@NotEmpty(message=("Este campo no puede estar vacío"))
	@Size(min=10, message="Este campo tiene que tener al menos 10 caracteres")
	private String preparacion;
	@Column(name="rec_imagen")
	private String imagen;
	@Column(name="rec_estado")
	private Boolean estado;
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Ingrediente> listaIngredientes;
	/*Getters y Setters*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getPreparacion() {
		return preparacion;
	}
	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public List<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}
	public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}
	/*Constructores*/
	public Receta() {

	}
	public Receta(String nombre, String categoria, String preparacion, String imagen, Boolean estado) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.preparacion = preparacion;
		this.imagen = imagen;
		this.estado = estado;
	}
}
