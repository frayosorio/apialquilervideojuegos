package apiAlquilerVideoJuegos.modelos;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tecnologia database table.
 * 
 */
@Entity
@NamedQuery(name = "Tecnologia.findAll", query = "SELECT t FROM Tecnologia t")
public class Tecnologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	/*
	 * //bi-directional many-to-one association to Inventario
	 * 
	 * @OneToMany(mappedBy="tecnologia") private List<Inventario> inventarios;
	 */

	public Tecnologia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * public List<Inventario> getInventarios() { return this.inventarios; }
	 * 
	 * public void setInventarios(List<Inventario> inventarios) { this.inventarios =
	 * inventarios; }
	 * 
	 * public Inventario addInventario(Inventario inventario) {
	 * getInventarios().add(inventario); inventario.setTecnologia(this);
	 * 
	 * return inventario; }
	 * 
	 * public Inventario removeInventario(Inventario inventario) {
	 * getInventarios().remove(inventario); inventario.setTecnologia(null);
	 * 
	 * return inventario; }
	 */

}