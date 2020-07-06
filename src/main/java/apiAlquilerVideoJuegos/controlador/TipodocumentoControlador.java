package apiAlquilerVideoJuegos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import apiAlquilerVideoJuegos.modelos.Tipodocumento;
import apiAlquilerVideoJuegos.servicios.TipodocumentoServicio;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@Controller
@ResponseBody
@RequestMapping(value = "/tipodocumento")
@Api(value = "onlinestore", description = "Operaciones sobre las tipos de documentos de identidad")
@Validated
public class TipodocumentoControlador {


	private TipodocumentoServicio tipodocumentoServicio;

	public TipodocumentoControlador() {

	}

	@Autowired
	public TipodocumentoControlador(TipodocumentoServicio tipodocumentoServicio) {
		this.tipodocumentoServicio = tipodocumentoServicio;
	}

	// Listar todos los Tipodocumentos
	@ApiOperation(value = "Listar los tipos de documentos de identidad", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista cargada con exito"),
			@ApiResponse(code = 401, message = "No tiene autorización para el recurso"),
			@ApiResponse(code = 403, message = "Recurso prohibido"),
			@ApiResponse(code = 404, message = "Recurso no encontrado") })
	@RequestMapping(value = "/listar", produces = "application/json", method = RequestMethod.GET)
	public List<Tipodocumento> listar() {
		return tipodocumentoServicio.obtener();
	}

	@ApiOperation(value = "Buscar un Tipo de documento por el Id", response = Tipodocumento.class)
	@RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
	public Tipodocumento obtenerTipodocumento(@PathVariable Long id) {
		return tipodocumentoServicio.obtenerTipodocumento(id);
	}

	@ApiOperation(value = "Agregar un nuevo Tipo de documento")
	@RequestMapping(value = "/agregar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity agregar(@RequestParam("tipodocumento") @ModelAttribute Tipodocumento tipodocumento) {
		if (tipodocumentoServicio.guardar(tipodocumento)) {
			return new ResponseEntity("Tipo de documento agregado con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity("No se pudo agregar el Tipo de documento", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@ApiOperation(value = "Actualizar un Tipo de documento existente")
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.POST)
	public boolean modificar(@ModelAttribute Tipodocumento tipodocumento) {
		return tipodocumentoServicio.guardar(tipodocumento);
	}

	@ApiOperation(value = "Eliminar un Tipo de documento")
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity eliminar(@PathVariable Long id) {
		if (tipodocumentoServicio.eliminar(id)) {
			return new ResponseEntity("Tipo de documento eliminado con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity("No se pudo eliminar el Tipo de documento", HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
