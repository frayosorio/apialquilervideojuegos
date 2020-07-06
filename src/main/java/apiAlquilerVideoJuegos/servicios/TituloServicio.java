package apiAlquilerVideoJuegos.servicios;


import java.util.List;
import apiAlquilerVideoJuegos.modelos.Titulo;

public interface TituloServicio {

	public List<Titulo> obtener();
	public Titulo obtenerTitulo(Long id);
	public boolean guardar(Titulo titulo);
	public boolean eliminar(Long id);

}
