package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.entity.Ingrediente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredienteRepository extends CrudRepository<Ingrediente, Long> {
	public Ingrediente findByCodigo(String codigo);
}
