package apiAlquilerVideoJuegos.basedatos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import apiAlquilerVideoJuegos.modelos.Alquiler;

@Repository
public interface AlquilerBD extends CrudRepository<Alquiler, Long>{
	
}