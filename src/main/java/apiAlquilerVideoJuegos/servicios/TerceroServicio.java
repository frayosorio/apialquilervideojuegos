package apiAlquilerVideoJuegos.servicios;

import java.util.List;

import apiAlquilerVideoJuegos.modelos.Tercero;

public interface TerceroServicio {
	
	public List<Tercero> obtener();
	public Tercero obtenerTercero(Long id);
	public boolean guardar(Tercero tercero);
	public boolean eliminar(Long id);
	
}
