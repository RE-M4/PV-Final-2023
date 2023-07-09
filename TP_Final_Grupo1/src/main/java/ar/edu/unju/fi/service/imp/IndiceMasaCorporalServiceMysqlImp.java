package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
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
		altura=altura/100;
		double imc =  (peso)/(altura*altura);
			if(imc<=18.5) {
				resultado = "Su IMC es "+ (Math.round(imc)*100.0)/100.0 + " – Está por debajo de su peso ideal.";
			}else {
				if(imc>=18.5 && imc<=25) {
					resultado = "Su IMC es "+ (Math.round(imc)*100.0)/100.0 + " – Está en su peso normal";
				}else {
					if(imc>25) {
						resultado="Su IMC es "+ (Math.round(imc)*100.0)/100.0 + " – Tiene sobrepeso.";
					}
				}
			}
		return resultado;
	}
	
	
	@Override
	public double calcularPesoIdeal(Usuario usuario) {
		

		int añoActual = LocalDate.now().getYear();

		// Obtén la fecha de nacimiento del usuario
		String fechaNacimientoStr = usuario.getFechaNacimiento();

		// Define el formato esperado de la fecha
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// Convierte la fecha de nacimiento a un objeto LocalDate utilizando el formato especificado
		LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatoFecha);

		// Calcula la edad del usuario
		int edad = añoActual - fechaNacimiento.getYear();

		// Calcula la estatura ajustada
		double pesoIdeal = usuario.getEstatura() - 100 + ((edad / 10) * 0.9);

		return pesoIdeal;

	}
	

}
