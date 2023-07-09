package ar.edu.unju.fi.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFile {
	/**
	 * Se crea la constante UPLOADS_FOLDER.
	 * Esta variable contendrá la ruta relativa a la carpeta "uploads" del proyecto.
	 */
	private final static String UPLOADS_FOLDER = "src/main/resources/static/uploads";
	
	/**
	 * Este método recibe como parámetro el nombre de la imagen y mediante la interfaz "Paths" devuelve la ruta absoluta de 
	 * acuerdo a la combinación de la ruta relativa que se encuentra en la constante UPLOADS_FOLDER y el nombre de la imagen.
	 * @param filename
	 * @return resource
	 */
	public Path getPath(String filename) {
		return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
	}
	
	/**
	 * Este método recibe como parámetro el nombre de la imagen y crea la ruta absoluta de la imagen llamando al método "getPath()".
	 * En caso de que la ruta no exista o no se pueda leer se atrapa el error mediante una excepción.
	 * @param filename
	 * @return resource
	 * @throws MalformedURLException
	 */
	public Resource load(String filename) throws MalformedURLException {
		Path path = getPath(filename);
		Resource resource = new UrlResource(path.toUri());
		if (!resource.exists() || !resource.isReadable()) {
			throw new RuntimeException("Error en la ruta: " + path.toString());
		}
		return resource;
	}
	/**
	 * Este método recibe como parámetro un objeto de tipo MultipartFile (clase que carga archivos en forma de formulario) y 
	 * se encarga de copiar la imagen a la carpeta que contendrá todas las imágenes.
	 * En la variable uniqueFilename guarda el nombre de la imagen anidado a una cadena generada de forma aleatoria (UUID.randomUUID()). 
	 * Vuelve a crear una ruta absoluta con el nuevo nombre de la imagen y copia la imagen obtenida en el parámetro "file".
	 * @param file
	 * @return uniqueFilename
	 * @throws IOException
	 */
	public String copy(MultipartFile file) throws IOException {
		String uniqueFilename = UUID.randomUUID().toString() + "_" + 
		file.getOriginalFilename();
		Path rootPath = getPath(uniqueFilename);
		Files.copy(file.getInputStream(), rootPath);
		return uniqueFilename;
	}
	/**
	 * Este método recibe como parámetro el nombre de la imagen, obtiene la ruta absoluta con el método "getPath()" y se 
	 * capta en la variable rootPath. Luego mediante la interfaz "File" crea un archivo con la ruta. Si el archivo existe, se elimina.
	 * @param filename
	 * @return false
	 */
	public boolean delete(String filename) {
		Path rootPath = getPath(filename);
		File file = rootPath.toFile();
		if(file.exists() && file.canRead()) {
			if(file.delete()) {
				return true;
			}
		}
		return false;
	}
}
