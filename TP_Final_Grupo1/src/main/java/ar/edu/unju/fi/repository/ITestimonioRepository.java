package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.entity.Testimonio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITestimonioRepository extends CrudRepository<Testimonio, Long> {
    /**
     * Metodo que permite buscar un testimonio segun su estado
     * @param estado - estado del testimonio a buscar
     * @return lista de testimonios que coinciden con el estado
     */
    List<Testimonio> findByEstado(boolean estado);
}
