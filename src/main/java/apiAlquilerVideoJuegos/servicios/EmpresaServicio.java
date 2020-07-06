package apiAlquilerVideoJuegos.servicios;

import java.util.List;
import apiAlquilerVideoJuegos.modelos.Empresa;

public interface EmpresaServicio {

	public List obtener();
	public Empresa obtenerEmpresa(Long id);
	public boolean guardar(Empresa empresa);
	public boolean eliminar(Long id);

}