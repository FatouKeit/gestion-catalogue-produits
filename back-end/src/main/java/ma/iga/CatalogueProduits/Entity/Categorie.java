package ma.iga.CatalogueProduits.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categorie {
	
	@Id
	@GeneratedValue
	@Column(name="id_categorie")
	private int idCategorie;
	@Column(name="nom_categorie")
	private String nomCategorie;
	
	@OneToMany(mappedBy="categorie")
	@JsonIgnore 
	private List<Produit> produits;

	
	public Categorie() {
		super();
	}

	public Categorie(int idCategorie, String nomCategorie, List<Produit> produits) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.produits = produits;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
}