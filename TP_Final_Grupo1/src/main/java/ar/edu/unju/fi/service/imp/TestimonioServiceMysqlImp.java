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

	@Override
	public Testimonio getTestimonio() {
		// TODO Auto-generated method stub
		return testimonio;
	}
	@Override
	public List<Testimonio> getListaTestimonios() {
		// TODO Auto-generated method stub
		return (List<Testimonio>) testimonioRepository.findAll();
	}
	@Override
	public void guardarTestimonio(Testimonio testimonio) {
		// TODO Auto-generated method stub
		testimonioRepository.save(testimonio);
	}
	@Override
	public void modificarTestimonio(Testimonio testimonio) {
		// TODO Auto-generated method stub
		testimonioRepository.save(testimonio);
	}
	@Override
	public Testimonio buscarTestimonio(long id) {
		// TODO Auto-generated method stub
		return testimonioRepository.findById(id).get();
	}
	@Override
	public void eliminarTestimonio(Testimonio testimonio) {
		// TODO Auto-generated method stub
		testimonioRepository.delete(testimonio);
	}

}
