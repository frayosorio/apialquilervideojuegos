package apiAlquilerVideoJuegos.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiAlquilerVideoJuegos.basedatos.TipodocumentoBD;
import apiAlquilerVideoJuegos.modelos.Tipodocumento;

@Service
@Transactional
public class TipodocumentoServicioImp implements TipodocumentoServicio {

		// Implementing Constructor based DI
		private TipodocumentoBD tipodocumentoBD;
		
		public TipodocumentoServicioImp() {
			
		}
		
		@Autowired
		public TipodocumentoServicioImp(TipodocumentoBD tipodocumentoBD) {
			super();
			this.tipodocumentoBD = tipodocumentoBD;
		}
		
	@Override
	public List<Tipodocumento> obtener() {
		List<Tipodocumento> lista = new ArrayList<Tipodocumento>();
		tipodocumentoBD.findAll().forEach(e -> lista.add(e));
		return lista;
	}

	@Override
	public Tipodocumento obtenerTipodocumento(Long id) {
		Tipodocumento Tipodocumento = tipodocumentoBD.findById(id).get();
		return Tipodocumento;
	}

	@Override
	public boolean guardar(Tipodocumento Tipodocumento) {
		try {
			tipodocumentoBD.save(Tipodocumento);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean eliminar(Long id) {
		try {
			tipodocumentoBD.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
		
	}

}
