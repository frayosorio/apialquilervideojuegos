package apiAlquilerVideoJuegos.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the inventario database table.
 * 
 */
@Entity
@NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
public class Inventario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte activo;

	private int consecutivo;

	@Temporal(TemporalType.DATE)
	private Date fechaAdquisicion;

	/*
	 * //bi-directional many-to-one association to Alquiler
	 * 
	 * @OneToMany(mappedBy="inventario") private List<Alquiler> alquilers;
	 */
	private int idtecnologia;
	/*
	 * //bi-directional many-to-one association to Tecnologia
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="IdTecnologia") private Tecnologia tecnologia;
	 */

	/*
	 * //bi-directional many-to-one association to Titulo
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="IdTitulo") private Titulo titulo;
	 */

	private int idtitulo;

	public Inventario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public int getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Date getFechaAdquisicion() {
		return this.fechaAdquisicion;
	}

	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	/*
	 * public List<Alquiler> getAlquilers() { return this.alquilers; }
	 * 
	 * public void setAlquilers(List<Alquiler> alquilers) { this.alquilers =
	 * alquilers; }
	 * 
	 * public Alquiler addAlquiler(Alquiler alquiler) {
	 * getAlquilers().add(alquiler); alquiler.setInventario(this);
	 * 
	 * return alquiler; }
	 * 
	 * public Alquiler removeAlquiler(Alquiler alquiler) {
	 * getAlquilers().remove(alquiler); alquiler.setInventario(null);
	 * 
	 * return alquiler; }
	 */
	/*
	 * public Tecnologia getTecnologia() { return this.tecnologia; }
	 * 
	 * public void setTecnologia(Tecnologia tecnologia) { this.tecnologia =
	 * tecnologia; }
	 */

	public int getIdtecnologia() {
		return this.idtecnologia;
	}

	public void setIdtecnologia(int idtecnologia) {
		this.idtecnologia = idtecnologia;
	}

	/*
	 * public Titulo getTitulo() { return this.titulo; }
	 * 
	 * public void setTitulo(Titulo titulo) { this.titulo = titulo; }
	 */

	public int getIdtitulo() {
		return this.idtitulo;
	}

	public void setIdtitulo(int idtitulo) {
		this.idtitulo = idtitulo;
	}
}