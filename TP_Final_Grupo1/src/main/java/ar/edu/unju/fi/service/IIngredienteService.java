package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Ingrediente;

import java.util.List;

public interface IIngredienteService {
	public Ingrediente getIngrediente();
	public List<Ingrediente> getListaIngredientes();
	public void guardarIngrediente(Ingrediente ingrediente);
	public void modificarIngrediente(Ingrediente ingrediente);
	public Ingrediente buscarIngrediente(long id);
	public void eliminarIngrediente(Ingrediente ingrediente);

}
