package apiAlquilerVideoJuegos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import apiAlquilerVideoJuegos.modelos.Titulo;
import apiAlquilerVideoJuegos.servicios.TituloServicio;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@Controller
@ResponseBody
@RequestMapping(value = "/titulo")
@Api(value = "onlinestore", description = "Operaciones sobre los títulos de la tienda de videojuegos")
@Validated
public class TituloControlador {
	
	private TituloServicio tituloServicio;

	public TituloControlador() {

	}

	@Autowired
	public TituloControlador(TituloServicio tituloServicio) {
		this.tituloServicio = tituloServicio;
	}

	// Listar todos los Titulos
	@ApiOperation(value = "Listar los títulos de la tienda", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista cargada con exito"),
			@ApiResponse(code = 401, message = "No tiene autorización para el recurso"),
			@ApiResponse(code = 403, message = "Recurso prohibido"),
			@ApiResponse(code = 404, message = "Recurso no encontrado") })
	@RequestMapping(value = "/listar", produces = "application/json", method = RequestMethod.GET)
	public List<Titulo> listar() {
		return tituloServicio.obtener();
	}

	@ApiOperation(value = "Buscar un Título por el Id", response = Titulo.class)
	@RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
	public Titulo obtenerTitulo(@PathVariable Long id) {
		return tituloServicio.obtenerTitulo(id);
	}

	@ApiOperation(value = "Agregar un nuevo Título")
	@RequestMapping(value = "/agregar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity agregar(@RequestParam("titulo") @ModelAttribute Titulo titulo) {
		if (tituloServicio.guardar(titulo)) {
			return new ResponseEntity("Título agregado con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity("No se pudo agregar el Título", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@ApiOperation(value = "Actualizar un Título existente")
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.POST)
	public boolean modificar(@ModelAttribute Titulo titulo) {
		return tituloServicio.guardar(titulo);
	}

	@ApiOperation(value = "Eliminar un Título")
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity eliminar(@PathVariable Long id) {
		if (tituloServicio.eliminar(id)) {
			return new ResponseEntity("Título eliminado con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity("No se pudo eliminar el Título", HttpStatus.NOT_ACCEPTABLE);
		}
	}

}