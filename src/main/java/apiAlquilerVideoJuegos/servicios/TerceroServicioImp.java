package apiAlquilerVideoJuegos.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiAlquilerVideoJuegos.basedatos.TerceroBD;
import apiAlquilerVideoJuegos.modelos.Tercero;

@Service
@Transactional
public class TerceroServicioImp implements TerceroServicio {

		// Implementing Constructor based DI
		private TerceroBD terceroBD;
		
		public TerceroServicioImp() {
			
		}
		
		@Autowired
		public TerceroServicioImp(TerceroBD terceroBD) {
			super();
			this.terceroBD = terceroBD;
		}
		
	@Override
	public List<Tercero> obtener() {
		List<Tercero> lista = new ArrayList<Tercero>();
		terceroBD.findAll().forEach(e -> lista.add(e));
		return lista;
	}

	@Override
	public Tercero obtenerTercero(Long id) {
		Tercero Tercero = terceroBD.findById(id).get();
		return Tercero;
	}

	@Override
	public boolean guardar(Tercero Tercero) {
		try {
			terceroBD.save(Tercero);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean eliminar(Long id) {
		try {
			terceroBD.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
		
	}

}
