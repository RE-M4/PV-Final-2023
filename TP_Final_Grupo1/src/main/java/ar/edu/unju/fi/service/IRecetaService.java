package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Receta;

public interface IRecetaService{
	public Receta getReceta();
	public List<Receta> getListaRecetas();
	public void guardarReceta(Receta receta);
	public void modificarReceta(Receta receta);
	public void eliminarReceta(Long id);
	public Receta getById(Long id);
	public List<Receta> getListaRecetasByCategoria(String categoria);
}