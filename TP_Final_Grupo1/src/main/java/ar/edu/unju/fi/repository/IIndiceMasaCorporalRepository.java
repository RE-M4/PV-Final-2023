package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;

/*Este archivo es una nueva interfaz que utiliza métodos CRUD para BD*/
/*Los parámetros de CrudRepository corresponden a identificar la clave única que la tabla debe considerar*/
/*La etiqueta "Repository" identifica a esta interfaz como la válida para que la BD busque los métodos*/
@Repository
public interface IIndiceMasaCorporalRepository extends CrudRepository<IndiceMasaCorporal, Long> {
	public List<IndiceMasaCorporal> findByEstado(boolean estado);
	
}
