package apiAlquilerVideoJuegos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import apiAlquilerVideoJuegos.modelos.Tercero;
import apiAlquilerVideoJuegos.servicios.TerceroServicio;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@Controller
@ResponseBody
@RequestMapping(value = "/tercero")
@Api(value = "onlinestore", description = "Operaciones sobre los terceros(clientes) de la tienda de videojuegos")
@Validated
public class TerceroControlador {


	private TerceroServicio terceroServicio;

	public TerceroControlador() {

	}

	@Autowired
	public TerceroControlador(TerceroServicio terceroServicio) {
		this.terceroServicio = terceroServicio;
	}

	// Listar todos los Terceros
	@ApiOperation(value = "Listar los títulos de la tienda", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista cargada con exito"),
			@ApiResponse(code = 401, message = "No tiene autorización para el recurso"),
			@ApiResponse(code = 403, message = "Recurso prohibido"),
			@ApiResponse(code = 404, message = "Recurso no encontrado") })
	@RequestMapping(value = "/listar", produces = "application/json", method = RequestMethod.GET)
	public List<Tercero> listar() {
		return terceroServicio.obtener();
	}

	@ApiOperation(value = "Buscar un Tercero por el Id", response = Tercero.class)
	@RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
	public Tercero obtenerTercero(@PathVariable Long id) {
		return terceroServicio.obtenerTercero(id);
	}

	@ApiOperation(value = "Agregar un nuevo Tercero")
	@RequestMapping(value = "/agregar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity agregar(@RequestParam("tercero") @ModelAttribute Tercero tercero) {
		if (terceroServicio.guardar(tercero)) {
			return new ResponseEntity("Tercero agregado con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity("No se pudo agregar la Tercero", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@ApiOperation(value = "Actualizar un Tercero existente")
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.POST)
	public boolean modificar(@ModelAttribute Tercero tercero) {
		return terceroServicio.guardar(tercero);
	}

	@ApiOperation(value = "Eliminar un Tercero")
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity eliminar(@PathVariable Long id) {
		if (terceroServicio.eliminar(id)) {
			return new ResponseEntity("Tercero eliminado con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity("No se pudo eliminar la Tercero", HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
