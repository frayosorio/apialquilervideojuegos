package apiAlquilerVideoJuegos.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the region database table.
 * 
 */
@Entity
@NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String codigo;

	private String region;

	/*
	 * //bi-directional many-to-one association to Ciudad
	 * 
	 * @OneToMany(mappedBy="region") private List<Ciudad> ciudads;
	 */
	private int idpais;

	/*
	 * //bi-directional many-to-one association to Pais
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="IdPais") private Pais pais;
	 */
	public Region() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	/*
	 * public List<Ciudad> getCiudads() { return this.ciudads; }
	 * 
	 * public void setCiudads(List<Ciudad> ciudads) { this.ciudads = ciudads; }
	 * 
	 * public Ciudad addCiudad(Ciudad ciudad) { getCiudads().add(ciudad);
	 * ciudad.setRegion(this);
	 * 
	 * return ciudad; }
	 * 
	 * public Ciudad removeCiudad(Ciudad ciudad) { getCiudads().remove(ciudad);
	 * ciudad.setRegion(null);
	 * 
	 * return ciudad; }
	 */

	public int getIdpais() {
		return this.idpais;
	}

	public void setIdpais(int idpais) {
		this.idpais = idpais;
	}

	/*
	 * public Pais getPais() { return this.pais; }
	 * 
	 * public void setPais(Pais pais) { this.pais = pais; }
	 */

}