package apiAlquilerVideoJuegos.modelos;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name = "pais")
@NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String codigoAlfa2;

	private String codigoAlfa3;

	private String pais;

	/*
	 * //bi-directional many-to-one association to Empresa
	 * 
	 * @OneToMany(mappedBy="pais") private List<Empresa> empresas;
	 */

	/*
	 * //bi-directional many-to-one association to Region
	 * 
	 * @OneToMany(mappedBy="pais") private List<Region> regions;
	 */

	public Pais() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoAlfa2() {
		return this.codigoAlfa2;
	}

	public void setCodigoAlfa2(String codigoAlfa2) {
		this.codigoAlfa2 = codigoAlfa2;
	}

	public String getCodigoAlfa3() {
		return this.codigoAlfa3;
	}

	public void setCodigoAlfa3(String codigoAlfa3) {
		this.codigoAlfa3 = codigoAlfa3;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	/*
	 * public List<Empresa> getEmpresas() { return this.empresas; }
	 * 
	 * public void setEmpresas(List<Empresa> empresas) { this.empresas = empresas; }
	 * 
	 * public Empresa addEmpresa(Empresa empresa) { getEmpresas().add(empresa);
	 * empresa.setPais(this);
	 * 
	 * return empresa; }
	 * 
	 * public Empresa removeEmpresa(Empresa empresa) {
	 * getEmpresas().remove(empresa); empresa.setPais(null);
	 * 
	 * return empresa; }
	 */

	/*
	 * public List<Region> getRegions() { return this.regions; }
	 * 
	 * public void setRegions(List<Region> regions) { this.regions = regions; }
	 * 
	 * public Region addRegion(Region region) { getRegions().add(region);
	 * region.setPais(this);
	 * 
	 * return region; }
	 * 
	 * public Region removeRegion(Region region) { getRegions().remove(region);
	 * region.setPais(null);
	 * 
	 * return region; }
	 */
}