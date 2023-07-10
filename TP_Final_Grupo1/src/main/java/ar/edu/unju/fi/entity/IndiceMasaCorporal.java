package ar.edu.unju.fi.entity;//es un PAQUETE  de organizacion de java.agrupa clases que contiene objetos para representar entidades.

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
@Component
@Entity
@Table(name="Indice_Masa_Corporal")
public class IndiceMasaCorporal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Esta etiqueta hace que se generen ids automáticamente al momento de crear la tabla en MySQL
	@Column(name="imc_id")
	private Long id;
	
	@Column(name="imc_fecha")
	private Date fechaImc;
	
	@ManyToOne(cascade =  CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "usu_id")
	private Usuario usuario;
	
	
	@Column(name="imc_estado")
	private boolean estado;
	
	@Min(value = 20,message = "el peso debe ser mayor a 20")
	@NotNull(message=("Este campo no puede estar vacío"))
	@Column(name="imc_peso")
	private Double peso;
	
	@Column(name="imc_corporal")
	private String estadoCorporal;
	
	// --- GETTERS Y SETTERS ---
	// Un getter es un método público que se utiliza para obtener el valor de una propiedad de la clase.
	//Un setter es un método público que se utiliza para establecer o modificar el valor de una propiedad de la clase.
	
	public Long getId() {
		return id;
	}
	public Date getFechaImc() {
		return fechaImc;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setId(Long id) {
		this.id=id;
	}
	public void setFechaImc(Date fechaImc) {
		this.fechaImc=fechaImc;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario=usuario;
	}
	public void setEstado(boolean estado) {
		this.estado=estado;
	}
	public String getEstadoCorporal() {
		return estadoCorporal;
	}
	public void setEstadoCorporal(String estadoCorporal) {
		this.estadoCorporal = estadoCorporal;
	}
public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
		
	// --- CONSTRUCTOR ---
	

	//Constructor con parámetros que tiene cuatro argumentos: Id - Fecha imc - Usuario - Estado.Estos se utilizan para inicializar los campos de la clase
	public IndiceMasaCorporal(Long id, Usuario usuario, Boolean estado) {
		super();//se refiere a la llamada al constructor de la clase base (si existe).
		this.id = id;
		this.fechaImc = new Date();
		/*this.usuario = usuario;*/
		this.estado = true;
		//en este se asignan los valores a los campos anteriores. ESTE CREA UN OBJETO "IndiceMasaCorporal" y establece los valores de sus campos.
	}
	public IndiceMasaCorporal(){
		this.estado=true;
		this.fechaImc = new Date();
	/*Este es un constructor sin parámetros. En este caso, se establece el campo estado en true. Este constructor puede ser útil 
	 * cuando se desea crear un objeto IndiceMasaCorporal sin proporcionar valores específicos para sus campos en ese momento.*/	
	}
	@Override
	public String toString() {
		return "IndiceMasaCorporal [id=" + id + ", fechaImc=" + fechaImc + ", usuario=" + usuario + ", estado=" + estado
				+ ", peso=" + peso + "]";
	}

	
	
}