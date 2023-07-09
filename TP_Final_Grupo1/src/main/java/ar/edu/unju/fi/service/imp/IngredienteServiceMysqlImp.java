package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.repository.IIngredienteRepository;
import ar.edu.unju.fi.service.IIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IngredienteServiceMysqlImp")
public class IngredienteServiceMysqlImp implements IIngredienteService {
	@Autowired
	private IIngredienteRepository ingredienteRepository;
	@Autowired
	private Ingrediente ingrediente;
	
	@Override
	public Ingrediente getIngrediente() {
		// TODO Auto-generated method stub
		return ingrediente;
	}
	@Override
	public List<Ingrediente> getListaIngredientes() {
		// TODO Auto-generated method stub
		return (List<Ingrediente>) ingredienteRepository.findAll();
	}
	@Override
	public void guardarIngrediente(Ingrediente ingrediente) {
		// TODO Auto-generated method stub
		ingredienteRepository.save(ingrediente);
	}
	/*@Override
	public void modificarIngrediente(Ingrediente ingrediente) {
		// TODO Auto-generated method stub
		ingredienteRepository.save(ingrediente);
	}*/
	@Override
	public Ingrediente buscarIngrediente(long id) {
		// TODO Auto-generated method stub
		return ingredienteRepository.findById(id).get();
	}
	@Override
	public void eliminarIngrediente(Ingrediente ingrediente) {
		// TODO Auto-generated method stub
		ingrediente.setEstado(false);
		ingredienteRepository.save(ingrediente);
	}
	@Override
	public List<Ingrediente> getListaIngredientesByEstado() {
		// TODO Auto-generated method stub
		return ingredienteRepository.findByEstado(true);
	}
	
}
