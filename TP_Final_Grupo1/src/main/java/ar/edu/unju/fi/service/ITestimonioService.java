package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Testimonio;

import java.util.List;

public interface ITestimonioService {
	/**
	 * Retorna un testimonio
	 * @return nueva instancia de testimonio
	 */
	public Testimonio getTestimonio();
	/**
	 * Retorna una lista de testimonios
	 * @return lista de testimonios
	 */
	public List<Testimonio> getListaTestimonios();
	/**
	 * Guarda un testimonio
	 * @param testimonio a guardar
	 */
	public void guardarTestimonio(Testimonio testimonio);
	/**
	 * Modifica un testimonio
	 * @param testimonio a modificar
	 */
	public void modificarTestimonio(Testimonio testimonio);
	/**
	 * Busca y retorna un testimonio por su id
	 * @param id de la testimonio a buscar
	 * @return la testimonio encontrada
	 */
	public Testimonio buscarTestimonio(long id);
	/**
	 * Elimina un testimonio
	 * @param testimonio a eliminar
	 */
	public void eliminarTestimonio(Testimonio testimonio);

}
