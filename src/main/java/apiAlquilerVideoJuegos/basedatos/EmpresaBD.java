package apiAlquilerVideoJuegos.basedatos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import apiAlquilerVideoJuegos.modelos.Empresa;

@Repository
public interface EmpresaBD extends CrudRepository<Empresa, Long>{
	
}
