package apiAlquilerVideoJuegos.servicios;

import java.util.Date;
import java.util.List;
import apiAlquilerVideoJuegos.modelos.AlquilerB;
import apiAlquilerVideoJuegos.modelos.Alquiler;

public interface AlquilerServicio {

	public List<Alquiler> obtener();
	
	public List<AlquilerB> buscar(Date desde, Date hasta);
	public List<AlquilerB> buscar(String dato, int tipo);

	public Alquiler obtenerAlquiler(Long id);

	public boolean guardar(Alquiler alquiler);

	public boolean eliminar(Long id);

}
