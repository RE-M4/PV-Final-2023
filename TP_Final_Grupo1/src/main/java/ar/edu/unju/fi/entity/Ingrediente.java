package ar.edu.unju.fi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ingredientes")
public class Ingrediente {
	/*Atributos*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ing_id")
	private Long id;
	@NotEmpty(message=("Este campo no puede estar vacío"))
	@Size(min=5, max=20, message="Este campo tiene que tener al menos 5 caracteres")
	@Column(name="ing_nombre")
	private String nombre;
	private Boolean estado;
	/*Constructores*/
	public Ingrediente() {
		this.estado = true;
	}
	public Ingrediente(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	/*Getters y Setters*/
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
