package apiAlquilerVideoJuegos.servicios;

import java.util.List;
import apiAlquilerVideoJuegos.modelos.Ciudad;

public interface CiudadServicio {

	public List<Ciudad> obtener();

	public Ciudad obtenerCiudad(Long id);

	public boolean guardar(Ciudad ciudad);

	public boolean eliminar(Long id);

}