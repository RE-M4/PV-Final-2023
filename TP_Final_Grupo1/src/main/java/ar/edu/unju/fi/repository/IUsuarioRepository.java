package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Usuario;

@Repository
public interface IUsuarioRepository  extends CrudRepository<Usuario, Long>{
	public  Usuario findByCodigo(String codigo);

}
