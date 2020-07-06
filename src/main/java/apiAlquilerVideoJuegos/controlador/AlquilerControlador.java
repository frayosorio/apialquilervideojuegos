package apiAlquilerVideoJuegos.controlador;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import apiAlquilerVideoJuegos.modelos.Alquiler;
import apiAlquilerVideoJuegos.modelos.AlquilerB;
import apiAlquilerVideoJuegos.servicios.AlquilerServicio;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@Controller
@ResponseBody
@RequestMapping(value = "/alquiler")
@Api(value = "onlinestore", description = "Operaciones sobre los Alquileres de Títulos de Videojuegos")
@Validated
public class AlquilerControlador {


	private AlquilerServicio alquilerServicio;

	public AlquilerControlador() {

	}

	@Autowired
	public AlquilerControlador(AlquilerServicio alquilerServicio) {
		this.alquilerServicio = alquilerServicio;
	}

	// Listar todos los Alquileres
	@ApiOperation(value = "Listar los Alquileres de Títulos de Videojuegos", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista cargada con exito"),
			@ApiResponse(code = 401, message = "No tiene autorización para el recurso"),
			@ApiResponse(code = 403, message = "Recurso prohibido"),
			@ApiResponse(code = 404, message = "Recurso no encontrado") })
	@RequestMapping(value = "/listar", produces = "application/json", method = RequestMethod.GET)
	public List<Alquiler> listar() {
		return alquilerServicio.obtener();
	}
	
	@ApiOperation(value = "Buscar Alquileres por fecha de préstamo", response = List.class)
	@RequestMapping(value = "/buscarfecha/{desde}/{hasta}", method = RequestMethod.GET)
	public List<AlquilerB> buscarPorFecha(@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable Date desde, 
										@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable Date hasta) {
		return alquilerServicio.buscar(desde, hasta);
	}
	
	@ApiOperation(value = "Buscar Alquileres por título de videojuego", response = List.class)
	@RequestMapping(value = "/buscartitulo/{titulo}", method = RequestMethod.GET)
	public List<AlquilerB> buscarPorTitulo(@PathVariable String titulo) {
		return alquilerServicio.buscar(titulo, 1);
	}
	
	@ApiOperation(value = "Buscar Alquileres por nombre del cliente", response = List.class)
	@RequestMapping(value = "/buscarcliente/{cliente}", method = RequestMethod.GET)
	public List<AlquilerB> buscarPorCliente(@PathVariable String cliente) {
		return alquilerServicio.buscar(cliente, 2);
	}

	@ApiOperation(value = "Buscar una Alquiler por el Id", response = Alquiler.class)
	@RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
	public Alquiler obtenerAlquiler(@PathVariable Long id) {
		return alquilerServicio.obtenerAlquiler(id);
	}

	@ApiOperation(value = "Agregar una nueva Alquiler")
	@RequestMapping(value = "/agregar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity agregar(@RequestParam("alquiler") @ModelAttribute Alquiler alquiler) {
		if (alquilerServicio.guardar(alquiler)) {
			return new ResponseEntity("Alquiler agregadi con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity("No se pudo agregar el Alquiler", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@ApiOperation(value = "Actualizar un Alquiler existente")
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.POST)
	public boolean modificar(@ModelAttribute Alquiler alquiler) {
		return alquilerServicio.guardar(alquiler);
	}

	@ApiOperation(value = "Eliminar un Alquiler")
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity eliminar(@PathVariable Long id) {
		if (alquilerServicio.eliminar(id)) {
			return new ResponseEntity("Alquiler eliminado con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity("No se pudo eliminar el Alquiler", HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
