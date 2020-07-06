package apiAlquilerVideoJuegos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import apiAlquilerVideoJuegos.modelos.Empresa;
import apiAlquilerVideoJuegos.servicios.EmpresaServicio;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@Controller
@ResponseBody
@RequestMapping(value = "/empresa")
@Api(value = "onlinestore", description = "Operaciones sobre las empresas desarrolladoras de videojuegos")
@Validated
public class EmpresaControlador {


	private EmpresaServicio empresaServicio;

	public EmpresaControlador() {

	}

	@Autowired
	public EmpresaControlador(EmpresaServicio empresaServicio) {
		this.empresaServicio = empresaServicio;
	}

	// Listar todos los Empresas
	@ApiOperation(value = "Listar las empresas desarrolladoras de videojuegos", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista cargada con exito"),
			@ApiResponse(code = 401, message = "No tiene autorización para el recurso"),
			@ApiResponse(code = 403, message = "Recurso prohibido"),
			@ApiResponse(code = 404, message = "Recurso no encontrado") })
	@RequestMapping(value = "/listar", produces = "application/json", method = RequestMethod.GET)
	public List<Empresa> listar() {
		return empresaServicio.obtener();
	}

	@ApiOperation(value = "Buscar una Empresa por el Id", response = Empresa.class)
	@RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
	public Empresa obtenerEmpresa(@PathVariable Long id) {
		return empresaServicio.obtenerEmpresa(id);
	}

	@ApiOperation(value = "Agregar una nueva Empresa")
	@RequestMapping(value = "/agregar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity agregar(@RequestParam("empresa") @ModelAttribute Empresa empresa) {
		if (empresaServicio.guardar(empresa)) {
			return new ResponseEntity("Empresa agregada con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity("No se pudo agregar la Empresa", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@ApiOperation(value = "Actualizar una Empresa existente")
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.POST)
	public boolean modificar(@ModelAttribute Empresa empresa) {
		return empresaServicio.guardar(empresa);
	}

	@ApiOperation(value = "Eliminar un Empresa")
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity eliminar(@PathVariable Long id) {
		if (empresaServicio.eliminar(id)) {
			return new ResponseEntity("Empresa eliminada con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity("No se pudo eliminar la Empresa", HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
