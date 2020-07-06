package apiAlquilerVideoJuegos.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tipodocumento database table.
 * 
 */
@Entity
@NamedQuery(name = "Tipodocumento.findAll", query = "SELECT t FROM Tipodocumento t")
public class Tipodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String ingles;

	private String sigla;

	private String tipo;

	/*
	 * //bi-directional many-to-one association to Tercero
	 * 
	 * @OneToMany(mappedBy="tipodocumento") private List<Tercero> terceros;
	 */

	public Tipodocumento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIngles() {
		return this.ingles;
	}

	public void setIngles(String ingles) {
		this.ingles = ingles;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/*
	 * public List<Tercero> getTerceros() { return this.terceros; }
	 * 
	 * public void setTerceros(List<Tercero> terceros) { this.terceros = terceros; }
	 * 
	 * public Tercero addTercero(Tercero tercero) { getTerceros().add(tercero);
	 * tercero.setTipodocumento(this);
	 * 
	 * return tercero; }
	 * 
	 * public Tercero removeTercero(Tercero tercero) {
	 * getTerceros().remove(tercero); tercero.setTipodocumento(null);
	 * 
	 * return tercero; }
	 */
}