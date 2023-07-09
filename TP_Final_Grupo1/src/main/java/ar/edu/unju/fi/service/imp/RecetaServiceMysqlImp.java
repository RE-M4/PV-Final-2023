package ar.edu.unju.fi.service.imp;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.IRecetaRepository;
import ar.edu.unju.fi.service.IRecetaService;

@Service
public class RecetaServiceMysqlImp implements IRecetaService{
	@Autowired
	private IRecetaRepository recetaRepository;
	@Autowired
	private Receta receta;
	
	/**
	 * Método que devuelve un objeto vacío (con el atributo "estado" inicializado en "true").
	 */
	@Override
	public Receta getReceta() {
		// TODO Auto-generated method stub
		return receta;
	}
	/**
	 * Método que devuelve todos los objetos existentes.
	 */
	@Override
	public List<Receta> getListaRecetas() {
		// TODO Auto-generated method stub
		return (List<Receta>) recetaRepository.findAll();
	}
	/**
	 * Método que guarda un nuevo objeto.
	 */
	@Override
	public void guardarReceta(Receta receta) {
		// TODO Auto-generated method stub
		recetaRepository.save(receta);
	}
	/**
	 * Método que guarda un objeto con cambios.
	 */
	@Override
	public void modificarReceta(Receta receta) {
		// TODO Auto-generated method stub
		recetaRepository.save(receta);
	}
	/**
	 * Método que elimina de forma lógica un objeto.
	 */
	@Override
	public void eliminarReceta(Receta receta) {
		// TODO Auto-generated method stub
		receta.setEstado(false);
		recetaRepository.save(receta);
	}
	/**
	 * Método que devuelve un objeto en particular buscando por el atributo "id".
	 */
	@Override
	public Receta getById(Long id) {
		// TODO Auto-generated method stub
		return recetaRepository.findById(id).get();
	}
	/**
	 * Método que devuelve una lista de objetos teniendo en cuenta que el atributo "estado" = "true" y la categoría 
	 * sea igual a la que llega como parámetro.
	 */
	@Override
	public List<Receta> getListaRecetasByCategoria(String categoria) {
		// TODO Auto-generated method stub
		List<Receta> listaCategorizada = recetaRepository.findByCategoria(categoria);
		List<Receta> listaResultado = new ArrayList<>();
		for (int i = 0; i < listaCategorizada.size(); i++) {
			if(listaCategorizada.get(i).getEstado() == true) {
				listaResultado.add(listaCategorizada.get(i));
			}
		}
		return listaResultado;
	}
}