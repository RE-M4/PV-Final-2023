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

	
	/**
	 * Retorna el objeto IndiceMasaCorporal utilizado en el servicio.
	 *
	 * @return el objeto IndiceMasaCorporal utilizado en el servicio.
	 */
	@Override
	public IndiceMasaCorporal getImc() {
		// TODO Auto-generated method stub
		return indiceMasaCorporal;
	}

	
	/**
	 * Retorna una lista de todos los registros de IndiceMasaCorporal.
	 *
	 * @return una lista de todos los registros de IndiceMasaCorporal.
	 */
	@Override
	public List<IndiceMasaCorporal> getListaImc() {
		// TODO Auto-generated method stub
		return (List<IndiceMasaCorporal>) indiceMasaCorporalRepository.findAll();
	}

	
	/**
	 * Guarda un registro de IndiceMasaCorporal en el repositorio.
	 *
	 * @param indiceMasaCorporal el objeto IndiceMasaCorporal a guardar
	 */
	@Override
	public void guardarImc(IndiceMasaCorporal indiceMasaCorporal) {
		// TODO Auto-generated method stub
		indiceMasaCorporalRepository.save(indiceMasaCorporal);
		
	}

	
	/**
	 * Modifica un registro de IndiceMasaCorporal en el repositorio.
	 *
	 * @param indiceMasaCorporal el objeto IndiceMasaCorporal a modificar
	 */
	@Override
	public void modificarImc(IndiceMasaCorporal indiceMasaCorporal) {
		// TODO Auto-generated method stub
		indiceMasaCorporalRepository.save(indiceMasaCorporal);
		
	}

	
	/**
	 * Busca un registro de IndiceMasaCorporal por su ID.
	 *
	 * @param id el ID del registro a buscar
	 * @return el objeto IndiceMasaCorporal correspondiente al ID buscado
	 */
	@Override
	public IndiceMasaCorporal buscarImc(long id) {
		// TODO Auto-generated method stub
		return indiceMasaCorporalRepository.findById(id).get();
	}

	
	/**
	 * Elimina un registro de IndiceMasaCorporal del repositorio.
	 *
	 * @param indiceMasaCorporal el objeto IndiceMasaCorporal a eliminar
	 */
	@Override
	public void eliminarImc(IndiceMasaCorporal indiceMasaCorporal) {
		// TODO Auto-generated method stub
		indiceMasaCorporalRepository.delete(indiceMasaCorporal);
		
	}

	
	/**
	 * Calcula el índice de masa corporal (IMC) para un peso y altura dados.
	 * Retorna un mensaje con el resultado del cálculo.
	 *
	 * @param peso el peso en kilogramos
	 * @param altura la altura en centímetros
	 * @return un mensaje con el resultado del cálculo del IMC
	 */
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
	
	/**
	 * Calcula el peso ideal para un usuario en base a su estatura y fecha de nacimiento.
	 *
	 * @param usuario el objeto Usuario para calcular el peso ideal
	 * @return el peso ideal calculado
	 */
	@Override
	public double calcularPesoIdeal(Usuario usuario) {
		

		int añoActual = LocalDate.now().getYear();

		
		String fechaNacimientoStr = usuario.getFechaNacimiento();

	
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatoFecha);

		int edad = añoActual - fechaNacimiento.getYear();

		double pesoIdeal = usuario.getEstatura() - 100 + ((edad / 10) * 0.9);

		return pesoIdeal;

	}
	

}
