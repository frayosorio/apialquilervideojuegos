package apiAlquilerVideoJuegos.modelos;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ciudad database table.
 * 
 */
@Entity
@NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String ciudad;

	private int idregion;

	/*
	 * //bi-directional many-to-one association to Region
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="IdRegion") private Region region;
	 */

	/*
	 * //bi-directional many-to-one association to Tercero
	 * 
	 * @OneToMany(mappedBy="ciudad") private List<Tercero> terceros;
	 */

	public Ciudad() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/*
	 * public Region getRegion() { return this.region; }
	 * 
	 * public void setRegion(Region region) { this.region = region; }
	 */
	public int getIdregion() {
		return this.idregion;
	}

	public void setIdregion(int idregion) {
		this.idregion = idregion;
	}
	/*
	 * public List<Tercero> getTerceros() { return this.terceros; }
	 * 
	 * public void setTerceros(List<Tercero> terceros) { this.terceros = terceros; }
	 * 
	 * public Tercero addTercero(Tercero tercero) { getTerceros().add(tercero);
	 * tercero.setCiudad(this);
	 * 
	 * return tercero; }
	 * 
	 * public Tercero removeTercero(Tercero tercero) {
	 * getTerceros().remove(tercero); tercero.setCiudad(null);
	 * 
	 * return tercero; }
	 */
}