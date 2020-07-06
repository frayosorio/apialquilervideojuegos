package apiAlquilerVideoJuegos.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiAlquilerVideoJuegos.basedatos.AlquilerBD;
import apiAlquilerVideoJuegos.modelos.Alquiler;
import apiAlquilerVideoJuegos.modelos.AlquilerB;

@Service
@Transactional
public class AlquilerServicioImp implements AlquilerServicio {

	// Implementing Constructor based DI
	private AlquilerBD alquilerBD;

	public AlquilerServicioImp() {

	}

	@Autowired
	public AlquilerServicioImp(AlquilerBD alquilerBD) {
		super();
		this.alquilerBD = alquilerBD;
	}

	@Override
	public List<Alquiler> obtener() {
		List<Alquiler> lista = new ArrayList<Alquiler>();
		alquilerBD.findAll().forEach(e -> lista.add(e));
		return lista;
	}

	@Override
	public List<AlquilerB> buscar(Date desde, Date hasta) {
		List<AlquilerB> lista = new ArrayList<AlquilerB>();
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("spBuscarAlquilerFecha");
		query.registerStoredProcedureParameter(1, Date.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Date.class, ParameterMode.IN);
		query.setParameter(1, desde);
		query.setParameter(2, hasta);
		lista = (List<AlquilerB>) query.getResultList();
		return lista;
	}

	@PersistenceContext(unitName = "default")
	private EntityManager entityManager;

	@Override
	public List<AlquilerB> buscar(String dato, int tipo) {
		List<AlquilerB> lista = new ArrayList<AlquilerB>();
		StoredProcedureQuery query;
		switch (tipo) {
		case 1:
			// buscar por título
			query = entityManager.createStoredProcedureQuery("spBuscarAlquilerTitulo");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, "%" + dato + "%");
			lista = (List<AlquilerB>) query.getResultList();
			break;
		case 2:
			// buscar por cliente
			query = entityManager.createStoredProcedureQuery("spBuscarAlquilerCliente");
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.setParameter(1, "%" + dato + "%");
			lista = (List<AlquilerB>) query.getResultList();
			break;
		}
		return lista;
	}

	@Override
	public Alquiler obtenerAlquiler(Long id) {
		Alquiler Alquiler = alquilerBD.findById(id).get();
		return Alquiler;
	}

	@Override
	public boolean guardar(Alquiler Alquiler) {
		try {
			alquilerBD.save(Alquiler);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean eliminar(Long id) {
		try {
			alquilerBD.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

}
