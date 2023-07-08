package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;

import ar.edu.unju.fi.repository.IIndiceMasaCorporalRepository;

import ar.edu.unju.fi.service.IIndiceMasaCorporalService;

@Service("IndiceMasaCorporalServiceMysqlImp")
public class IndiceMasaCorporalServiceMysqlImp implements IIndiceMasaCorporalService{
	
	@Autowired
    private IIndiceMasaCorporalRepository indiceMasaCorporalRepository;
	
	@Autowired
	private IndiceMasaCorporal indiceMasaCorporal;

	@Override
	public IndiceMasaCorporal getImc() {
		// TODO Auto-generated method stub
		return indiceMasaCorporal;
	}

	@Override
	public List<IndiceMasaCorporal> getListaImc() {
		// TODO Auto-generated method stub
		return (List<IndiceMasaCorporal>) indiceMasaCorporalRepository.findAll();
	}

	@Override
	public void guardarImc(IndiceMasaCorporal indiceMasaCorporal) {
		// TODO Auto-generated method stub
		indiceMasaCorporalRepository.save(indiceMasaCorporal);
		
	}

	@Override
	public void modificarImc(IndiceMasaCorporal indiceMasaCorporal) {
		// TODO Auto-generated method stub
		indiceMasaCorporalRepository.save(indiceMasaCorporal);
		
	}

	@Override
	public IndiceMasaCorporal buscarImc(long id) {
		// TODO Auto-generated method stub
		return indiceMasaCorporalRepository.findById(id).get();
	}

	@Override
	public void eliminarImc(IndiceMasaCorporal indiceMasaCorporal) {
		// TODO Auto-generated method stub
		indiceMasaCorporalRepository.delete(indiceMasaCorporal);
		
	}

	@Override
	public String calcularIMC(double peso, double altura) {
		String resultado="";
		double imc =  (peso)/(altura*altura);
			if(imc<=18.5) {
				resultado = "Está por debajo de su peso ideal";
			}else {
				if(imc>=18.5 && imc<=25) {
					resultado = "Está en su peso normal";
				}else {
					if(imc>25) {
						resultado="Tiene sobrepeso";
					}
				}
			}
		return resultado;
	}
	
	

}
