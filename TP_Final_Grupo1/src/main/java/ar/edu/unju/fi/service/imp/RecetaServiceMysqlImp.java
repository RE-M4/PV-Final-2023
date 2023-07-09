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

	@Override
	public Receta getReceta() {
		// TODO Auto-generated method stub
		return receta;
	}

	@Override
	public List<Receta> getListaRecetas() {
		// TODO Auto-generated method stub
		return (List<Receta>) recetaRepository.findAll();
	}

	@Override
	public void guardarReceta(Receta receta) {
		// TODO Auto-generated method stub
		recetaRepository.save(receta);
	}

	@Override
	public void modificarReceta(Receta receta) {
		// TODO Auto-generated method stub
		recetaRepository.save(receta);
	}

	@Override
	public void eliminarReceta(Receta receta) {
		// TODO Auto-generated method stub
		receta.setEstado(false);
		recetaRepository.save(receta);
	}

	@Override
	public Receta getById(Long id) {
		// TODO Auto-generated method stub
		return recetaRepository.findById(id).get();
	}
	
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