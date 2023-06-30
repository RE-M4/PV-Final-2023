package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.entity.Testimonio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestimonioRepository extends CrudRepository<Testimonio, Long> {
	public Testimonio findByCodigo(String codigo);

}
