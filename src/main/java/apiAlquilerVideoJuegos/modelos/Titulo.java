package apiAlquilerVideoJuegos.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the titulo database table.
 * 
 */
@Entity
@NamedQuery(name = "Titulo.findAll", query = "SELECT t FROM Titulo t")
public class Titulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int año;

	private String director;

	private String nombre;

	private float precio;

	private String productor;

	private String protagonistas;
	
	private int idempresa;

	// bi-directional many-to-one association to Inventario
	@OneToMany(mappedBy = "titulo")
	private List<Inventario> inventarios;

	/*
	 * //bi-directional many-to-one association to Empresa
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="IdEmpresa") private Empresa empresa;
	 */
	

	public Titulo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAño() {
		return this.año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getProductor() {
		return this.productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public String getProtagonistas() {
		return this.protagonistas;
	}

	public void setProtagonistas(String protagonistas) {
		this.protagonistas = protagonistas;
	}

	public List<Inventario> getInventarios() {
		return this.inventarios;
	}

	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}

	public Inventario addInventario(Inventario inventario) {
		getInventarios().add(inventario);
		inventario.setTitulo(this);

		return inventario;
	}

	public Inventario removeInventario(Inventario inventario) {
		getInventarios().remove(inventario);
		inventario.setTitulo(null);

		return inventario;
	}

	/*
	 * public Empresa getEmpresa() { return this.empresa; }
	 * 
	 * public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
	 */
	public int getIdEmpresa() {
		return this.idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

}