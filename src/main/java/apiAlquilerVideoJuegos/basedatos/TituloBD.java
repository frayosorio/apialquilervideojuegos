package apiAlquilerVideoJuegos.basedatos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import apiAlquilerVideoJuegos.modelos.Titulo;

@Repository
public interface TituloBD extends CrudRepository<Titulo, Long>{
	
}