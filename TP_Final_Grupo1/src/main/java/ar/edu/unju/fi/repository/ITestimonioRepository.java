package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.entity.Testimonio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITestimonioRepository extends CrudRepository<Testimonio, Long> {
    List<Testimonio> findByEstado(boolean estado);
}
