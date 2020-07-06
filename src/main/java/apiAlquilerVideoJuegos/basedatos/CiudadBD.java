package apiAlquilerVideoJuegos.basedatos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import apiAlquilerVideoJuegos.modelos.Ciudad;

@Repository
public interface CiudadBD extends CrudRepository<Ciudad, Long>{
	
}
