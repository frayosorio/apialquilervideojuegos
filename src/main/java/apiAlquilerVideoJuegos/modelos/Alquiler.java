package apiAlquilerVideoJuegos.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the alquiler database table.
 * 
 */
@Entity
@NamedQuery(name = "Alquiler.findAll", query = "SELECT a FROM Alquiler a")
public class Alquiler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechadevolucion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaprestamo;

	private int plazo;

	private float precio;

	/*
	 * //bi-directional many-to-one association to Inventario
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="IdInventario") private Inventario inventario;
	 */

	private int idinventario;
	/*
	 * //bi-directional many-to-one association to Tercero
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="IdTercero") private Tercero tercero;
	 */

	private int idtercero;

	public Alquiler() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechadevolucion() {
		return this.fechadevolucion;
	}

	public void setFechadevolucion(Date fechadevolucion) {
		this.fechadevolucion = fechadevolucion;
	}

	public Date getFechaprestamo() {
		return this.fechaprestamo;
	}

	public void setFechaprestamo(Date fechaprestamo) {
		this.fechaprestamo = fechaprestamo;
	}

	public int getPlazo() {
		return this.plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/*
	 * public Inventario getInventario() { return this.inventario; }
	 * 
	 * public void setInventario(Inventario inventario) { this.inventario =
	 * inventario; }
	 */

	public int getIdinventario() {
		return this.idinventario;
	}

	public void setIdinventario(int idinventario) {
		this.idinventario = idinventario;
	}

	/*
	 * public Tercero getTercero() { return this.tercero; }
	 * 
	 * public void setTercero(Tercero tercero) { this.tercero = tercero; }
	 */

	public int getIdtercero() {
		return this.idtercero;
	}

	public void setIdtercero(int idtercero) {
		this.idtercero = idtercero;
	}
}