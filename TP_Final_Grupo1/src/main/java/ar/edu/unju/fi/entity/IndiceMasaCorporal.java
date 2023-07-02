package ar.edu.unju.fi.entity;//es un PAQUETE  de organizacion de java.agrupa clases que contiene objetos para representar entidades.

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	
	/*@Column(name="imc_usuario")
	private Usuario usuario;*/
	
	@Column(name="imc_estado")
	private boolean estado;
	
	// --- GETTERS Y SETTERS ---
	// Un getter es un método público que se utiliza para obtener el valor de una propiedad de la clase.
	//Un setter es un método público que se utiliza para establecer o modificar el valor de una propiedad de la clase.
	
	public Long getId() {
		return id;
	}
	public Date getFechaImc() {
		return fechaImc;
	}
	/*public Usuario getUsuario() {
		return usuario;
	}*/
	public boolean getEstado() {
		return estado;
	}
	public void setId(Long id) {
		this.id=id;
	}
	public void setFechaImc(Date fechaImc) {
		this.fechaImc=fechaImc;
	}
	/*public void setUsuario(Usuario usuario) {
		this.usuario=usuario;
	}*/
	public void setEstado(boolean estado) {
		this.estado=estado;
	}
		
	// --- CONSTRUCTOR ---
	
//Constructor con parámetros que tiene cuatro argumentos: Id - Fecha imc - Usuario - Estado.Estos se utilizan para inicializar los campos de la clase
	public IndiceMasaCorporal(Long id, Date fechaImc, Usuario usuario, Boolean estado) {
		super();//se refiere a la llamada al constructor de la clase base (si existe).
		this.id = id;
		this.fechaImc = fechaImc;
		/*this.usuario = usuario;*/
		this.estado = true;
		//en este se asignan los valores a los campos anteriores. ESTE CREA UN OBJETO "IndiceMasaCorporal" y establece los valores de sus campos.
	}
	public IndiceMasaCorporal(){
		this.estado=true;
	/*Este es un constructor sin parámetros. En este caso, se establece el campo estado en true. Este constructor puede ser útil 
	 * cuando se desea crear un objeto IndiceMasaCorporal sin proporcionar valores específicos para sus campos en ese momento.*/	
	}

}
