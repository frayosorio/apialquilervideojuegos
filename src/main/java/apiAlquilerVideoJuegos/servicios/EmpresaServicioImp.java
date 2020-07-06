package apiAlquilerVideoJuegos.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiAlquilerVideoJuegos.basedatos.EmpresaBD;
import apiAlquilerVideoJuegos.modelos.Empresa;

@Service
@Transactional
public class EmpresaServicioImp implements EmpresaServicio {

		// Implementing Constructor based DI
		private EmpresaBD empresaBD;
		
		public EmpresaServicioImp() {
			
		}
		
		@Autowired
		public EmpresaServicioImp(EmpresaBD empresaBD) {
			super();
			this.empresaBD = empresaBD;
		}
		
	@Override
	public List obtener() {
		List lista = new ArrayList();
		empresaBD.findAll().forEach(e -> lista.add(e));
		return lista;
	}

	@Override
	public Empresa obtenerEmpresa(Long id) {
		Empresa Empresa = empresaBD.findById(id).get();
		return Empresa;
	}

	@Override
	public boolean guardar(Empresa Empresa) {
		try {
			empresaBD.save(Empresa);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean eliminar(Long id) {
		try {
			empresaBD.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
		
	}

}
