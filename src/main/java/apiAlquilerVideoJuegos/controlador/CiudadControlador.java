package apiAlquilerVideoJuegos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import apiAlquilerVideoJuegos.modelos.Ciudad;
import apiAlquilerVideoJuegos.servicios.CiudadServicio;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@Controller
@ResponseBody
@RequestMapping(value = "/ciudad")
@Api(value = "onlinestore", description = "Operaciones sobre las Ciudades donde residen los clientes")
@Validated
public class CiudadControlador {


	private CiudadServicio ciudadServicio;

	public CiudadControlador() {

	}

	@Autowired
	public CiudadControlador(CiudadServicio ciudadServicio) {
		this.ciudadServicio = ciudadServicio;
	}

	// Listar todos los Ciudades
	@ApiOperation(value = "Listar las Ciudades donde residen los clientes", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista cargada con exito"),
			@ApiResponse(code = 401, message = "No tiene autorización para el recurso"),
			@ApiResponse(code = 403, message = "Recurso prohibido"),
			@ApiResponse(code = 404, message = "Recurso no encontrado") })
	@RequestMapping(value = "/listar", produces = "application/json", method = RequestMethod.GET)
	public List<Ciudad> listar() {
		return ciudadServicio.obtener();
	}

	@ApiOperation(value = "Buscar una Ciudad por el Id", response = Ciudad.class)
	@RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
	public Ciudad obtenerCiudad(@PathVariable Long id) {
		return ciudadServicio.obtenerCiudad(id);
	}

	@ApiOperation(value = "Agregar una nueva Ciudad")
	@RequestMapping(value = "/agregar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity agregar(@RequestParam("ciudad") @ModelAttribute Ciudad ciudad) {
		if (ciudadServicio.guardar(ciudad)) {
			return new ResponseEntity("Ciudad agregada con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity("No se pudo agregar la Ciudad", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@ApiOperation(value = "Actualizar una Ciudad existente")
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.POST)
	public boolean modificar(@ModelAttribute Ciudad ciudad) {
		return ciudadServicio.guardar(ciudad);
	}

	@ApiOperation(value = "Eliminar una Ciudad")
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity eliminar(@PathVariable Long id) {
		if (ciudadServicio.eliminar(id)) {
			return new ResponseEntity("Ciudad eliminada con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity("No se pudo eliminar la Ciudad", HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
