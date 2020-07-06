package apiAlquilerVideoJuegos.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiAlquilerVideoJuegos.basedatos.TituloBD;
import apiAlquilerVideoJuegos.modelos.Titulo;

@Service
@Transactional
public class TituloServicioImp implements TituloServicio {

		// Implementing Constructor based DI
		private TituloBD tituloBD;
		
		public TituloServicioImp() {
			
		}
		
		@Autowired
		public TituloServicioImp(TituloBD tituloBD) {
			super();
			this.tituloBD = tituloBD;
		}
		
	@Override
	public List<Titulo> obtener() {
		List<Titulo> lista = new ArrayList<Titulo>();
		tituloBD.findAll().forEach(e -> lista.add(e));
		return lista;
	}

	@Override
	public Titulo obtenerTitulo(Long id) {
		Titulo Titulo = tituloBD.findById(id).get();
		return Titulo;
	}

	@Override
	public boolean guardar(Titulo Titulo) {
		try {
			tituloBD.save(Titulo);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean eliminar(Long id) {
		try {
			tituloBD.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
		
	}

}
