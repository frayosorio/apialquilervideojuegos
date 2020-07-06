package apiAlquilerVideoJuegos.servicios;

import java.util.List;
import apiAlquilerVideoJuegos.modelos.Tipodocumento;

public interface TipodocumentoServicio {

	public List<Tipodocumento> obtener();

	public Tipodocumento obtenerTipodocumento(Long id);

	public boolean guardar(Tipodocumento tipodocumento);

	public boolean eliminar(Long id);

}