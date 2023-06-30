package ar.edu.unju.fi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ingredientes")
public class Ingrediente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ing_id")
	private Long id;
	private String nombre;
	@ManyToMany(mappedBy = "listaIngredientes")
	private List<Receta> listaRecetas;

	public Ingrediente() {
	}
	public Ingrediente(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
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

}
