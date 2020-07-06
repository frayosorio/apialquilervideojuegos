package apiAlquilerVideoJuegos.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiAlquilerVideoJuegos.basedatos.CiudadBD;
import apiAlquilerVideoJuegos.modelos.Ciudad;

@Service
@Transactional
public class CiudadServicioImp implements CiudadServicio {

		// Implementing Constructor based DI
		private CiudadBD ciudadBD;
		
		public CiudadServicioImp() {
			
		}
		
		@Autowired
		public CiudadServicioImp(CiudadBD ciudadBD) {
			super();
			this.ciudadBD = ciudadBD;
		}
		
	@Override
	public List<Ciudad> obtener() {
		List<Ciudad> lista = new ArrayList<Ciudad>();
		ciudadBD.findAll().forEach(e -> lista.add(e));
		return lista;
	}

	@Override
	public Ciudad obtenerCiudad(Long id) {
		Ciudad Ciudad = ciudadBD.findById(id).get();
		return Ciudad;
	}

	@Override
	public boolean guardar(Ciudad Ciudad) {
		try {
			ciudadBD.save(Ciudad);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean eliminar(Long id) {
		try {
			ciudadBD.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
		
	}

}
