package apiAlquilerVideoJuegos.modelos;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the empresa database table.
 * 
 */
//@Embeddable
@Entity
@NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	/*
	 * // bi-directional many-to-one association to Pais
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "IdPais") private Pais pais;
	 */
	
	private int idpais;
	/*
	 * //bi-directional many-to-one association to Titulo
	 * 
	 * @OneToMany(mappedBy="empresa") private List<Titulo> titulos;
	 */
	public Empresa() {
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
	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	*/

	public int getIdpais() {
		return this.idpais;
	}

	public void setIdpais(int idpais) {
		this.idpais = idpais;
	}
	/*
	 * public List<Titulo> getTitulos() { return this.titulos; }
	 * 
	 * public void setTitulos(List<Titulo> titulos) { this.titulos = titulos; }
	 * 
	 * public Titulo addTitulo(Titulo titulo) { getTitulos().add(titulo);
	 * titulo.setEmpresa(this);
	 * 
	 * return titulo; }
	 * 
	 * public Titulo removeTitulo(Titulo titulo) { getTitulos().remove(titulo);
	 * titulo.setEmpresa(null);
	 * 
	 * return titulo; }
	 */
}