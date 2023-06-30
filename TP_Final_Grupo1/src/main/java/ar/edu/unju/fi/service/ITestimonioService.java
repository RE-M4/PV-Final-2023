package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Testimonio;

import java.util.List;

public interface ITestimonioService {
	public Testimonio getTestimonio();
	public List<Testimonio> getListaTestimonios();
	public void guardarTestimonio(Testimonio testimonio);
	public void modificarTestimonio(Testimonio testimonio);
	public Testimonio buscarTestimonio(long id);
	public void eliminarTestimonio(Testimonio testimonio);

}
