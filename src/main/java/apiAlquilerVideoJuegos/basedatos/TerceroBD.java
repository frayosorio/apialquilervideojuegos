package apiAlquilerVideoJuegos.basedatos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import apiAlquilerVideoJuegos.modelos.Tercero;

@Repository
public interface TerceroBD extends CrudRepository<Tercero, Long>{
	
}