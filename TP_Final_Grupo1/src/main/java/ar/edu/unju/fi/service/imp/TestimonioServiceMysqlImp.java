package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.repository.ITestimonioRepository;
import ar.edu.unju.fi.service.ITestimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("TestimonioServiceMysqlImp")
public class TestimonioServiceMysqlImp implements ITestimonioService {
	@Autowired
	private ITestimonioRepository testimonioRepository;

	@Autowired
	private Testimonio testimonio;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Testimonio getTestimonio() {
		return testimonio;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Testimonio> getListaTestimonios() {
		return (List<Testimonio>) testimonioRepository.findAll();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void guardarTestimonio(Testimonio testimonio) {
		testimonioRepository.save(testimonio);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void modificarTestimonio(Testimonio testimonio) {
		testimonioRepository.save(testimonio);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Testimonio buscarTestimonio(long id) {
		return testimonioRepository.findById(id).get();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eliminarTestimonio(Testimonio testimonio) {
		testimonioRepository.delete(testimonio);
	}

}
