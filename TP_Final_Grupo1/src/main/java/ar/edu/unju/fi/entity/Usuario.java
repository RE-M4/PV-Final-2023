package ar.edu.unju.fi.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
	@Column(name="usu_codigo")
	private String codigo;
	
	
	@NotBlank(message=("Este campo no puede estar vacío"))
	@Size(min=5, message="Este campo tiene que tener al menos 5 caracteres")
	@Column(name="usu_nombre")
	private String nombre;
	
	@NotBlank(message=("Este campo no puede estar vacío"))
	@Size(min=5, message="Este campo tiene que tener al menos 5 caracteres")
	@Column(name="usu_apellido")
	private String apellido;
	
	@Email(message = "Debe ingresar un email válido")
	@NotBlank(message=("Este campo no puede estar vacío"))
	@Column(name="usu_email")
	private String email;
	
	@NotBlank(message=("Este campo no puede estar vacío"))
	@Column(name="usu_fecha_nacimiento")
	private String fechaNacimiento;
	
	@Digits(integer = 10, message = "Debe ingresar un telefono  válido", fraction = 0)
	@NotBlank(message=("Este campo no puede estar vacío"))
	@Column(name="usu_telefono")
	private String telefono;
	
	@NotBlank(message=("Este campo no puede estar vacío"))
	@Column(name="usu_sexo")
	private String sexo;
	
	@Digits(integer = 3, message = "Debe ingresar su estatura expresada en centimetros", fraction = 0)
	@NotNull(message=("Este campo no puede estar vacío"))
	@Column(name="usu_estatura")
	private Double estatura;
	
	
	@Column(name="usu_tipo_usuario")
	private Boolean tipoUsuario;
	
	@OneToMany(mappedBy ="usuario", cascade =  CascadeType.ALL,fetch = FetchType.EAGER)
	private List<IndiceMasaCorporal> registrosIMC;
	

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Testimonio> testimonios;

	
	//constructores
	public Usuario() {}

	public Usuario(String nombre, String apellido, String email, String fechaNacimiento, String telefono, String sexo,
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

	public boolean isTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(boolean tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
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
