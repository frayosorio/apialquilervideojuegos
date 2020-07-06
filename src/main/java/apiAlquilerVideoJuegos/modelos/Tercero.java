package apiAlquilerVideoJuegos.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tercero database table.
 * 
 */
@Entity
@NamedQuery(name = "Tercero.findAll", query = "SELECT t FROM Tercero t")
public class Tercero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String correo;

	private String direccion;

	private String documento;

	private String movil;

	private String nombre;

	private String telefono;

	/*
	 * //bi-directional many-to-one association to Alquiler
	 * 
	 * @OneToMany(mappedBy="tercero") private List<Alquiler> alquilers;
	 */

	private int idciudad;
	/*
	 * //bi-directional many-to-one association to Ciudad
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="IdCiudad") private Ciudad ciudad;
	 */

	private int idtipodocumento;
	/*
	 * //bi-directional many-to-one association to Tipodocumento
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="IdTipoDocumento") private Tipodocumento tipodocumento;
	 */

	public Tercero() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getMovil() {
		return this.movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/*
	 * public List<Alquiler> getAlquilers() { return this.alquilers; }
	 * 
	 * public void setAlquilers(List<Alquiler> alquilers) { this.alquilers =
	 * alquilers; }
	 * 
	 * public Alquiler addAlquiler(Alquiler alquiler) {
	 * getAlquilers().add(alquiler); alquiler.setTercero(this);
	 * 
	 * return alquiler; }
	 * 
	 * public Alquiler removeAlquiler(Alquiler alquiler) {
	 * getAlquilers().remove(alquiler); alquiler.setTercero(null);
	 * 
	 * return alquiler; }
	 */

	/*
	 * public Ciudad getCiudad() { return this.ciudad; }
	 * 
	 * public void setCiudad(Ciudad ciudad) { this.ciudad = ciudad; }
	 */
	public int getIdciudad() {
		return this.idciudad;
	}

	public void setIdciudad(int idciudad) {
		this.idciudad = idciudad;
	}
	/*
	 * public Tipodocumento getTipodocumento() { return this.tipodocumento; }
	 * 
	 * public void setTipodocumento(Tipodocumento tipodocumento) {
	 * this.tipodocumento = tipodocumento; }
	 */

	public int getIdtipodocumento() {
		return this.idtipodocumento;
	}

	public void setIdtipodocumento(int idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}
}