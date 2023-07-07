package ar.edu.unju.fi.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usu_id")
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private String codigo;
	private String nombre;
	private String apellido;
	private String email;
	private Date fechaNacimiento;
	private Integer telefono;
	private Boolean sexo;
	private Double estatura;
	
	@OneToMany(mappedBy ="usuario", cascade =  CascadeType.ALL,fetch = FetchType.EAGER)
	private List<IndiceMasaCorporal> registrosIMC;
	

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Testimonio> testimonios;

	
	//constructores
	public Usuario() {}

	public Usuario(String nombre, String apellido, String email, Date fechaNacimiento, Integer telefono, Boolean sexo,
			Double estatura) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.sexo = sexo;
		this.estatura = estatura;
	}

	//Getter and Setter
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Boolean getSexo() {
		return sexo;
	}

	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}
	
	public List<Testimonio> getTestimonios() {
		return testimonios;
	}

	public void setTestimonios(List<Testimonio> testimonios) {
		this.testimonios = testimonios;
	}

	public List<IndiceMasaCorporal> getRegistrosIMC() {
		return registrosIMC;
	}

	public void setRegistrosIMC(List<IndiceMasaCorporal> registrosIMC) {
		this.registrosIMC = registrosIMC;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", fechaNacimiento="
				+ fechaNacimiento + ", telefono=" + telefono + ", sexo=" + sexo + ", estatura=" + estatura + "]";
	}
	
	

}
