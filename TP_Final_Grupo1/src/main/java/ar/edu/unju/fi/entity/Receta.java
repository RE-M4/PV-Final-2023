package ar.edu.unju.fi.entity;

import jakarta.persistence.*;

@Entity
@Table(name="recetas")
public class Receta {
	/*Atributos*/
	@Id
	private Long id;
	private String nombre;
	private String categoria;
	private Ingrediente ingredientes;
	private String preparacion;
	private String imagen;
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
	public Ingrediente getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Ingrediente ingredientes) {
		this.ingredientes = ingredientes;
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
	/*Constructores*/
	public Receta(Long id, String nombre, String categoria, Ingrediente ingredientes, String preparacion,
			String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.ingredientes = ingredientes;
		this.preparacion = preparacion;
		this.imagen = imagen;
	}
	public Receta() {
		
	}
}
