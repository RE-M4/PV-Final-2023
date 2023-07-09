package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;


/*
 * Archivo de la capa service que sirve para ser inyectada dentro de ServicioDePaseoController.
 * Este archivo es un intermediario entre el controller (que solicita los métodos) y la implementación
 * que es el archivo que contiene la lógica de negocio (los métodos) => (ServicioDePaseosImp.java).
 */
public interface IIndiceMasaCorporalService {
	public IndiceMasaCorporal getImc();
	
	public List<IndiceMasaCorporal> getListaImc();
	
	public void guardarImc(IndiceMasaCorporal indiceMasaCorporal);
	
	public void modificarImc(IndiceMasaCorporal indiceMasaCorporal);
	
	public IndiceMasaCorporal buscarImc(long id);
	
	public void eliminarImc(IndiceMasaCorporal indiceMasaCorporal);
	
	public String calcularIMC(double peso,double altura );
	
	public double calcularPesoIdeal(Usuario usuario);

}
