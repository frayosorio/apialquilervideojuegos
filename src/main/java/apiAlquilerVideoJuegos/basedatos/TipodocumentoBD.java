package apiAlquilerVideoJuegos.basedatos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import apiAlquilerVideoJuegos.modelos.Tipodocumento;

@Repository
public interface TipodocumentoBD extends CrudRepository<Tipodocumento, Long>{
	
}
