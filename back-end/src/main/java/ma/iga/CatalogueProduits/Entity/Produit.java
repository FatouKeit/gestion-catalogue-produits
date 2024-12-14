package ma.iga.CatalogueProduits.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produit {
	@Id	
	@GeneratedValue
	private long reference;
	private String description;
	@Column(name="prix_Unit")
	private double prixUnit;
	@ManyToOne
	@JoinColumn(name="id_categorie")
	@JsonBackReference
	private Categorie categorie;
	
	
	public Produit() {
		super();
	}
	
	public Produit(long reference, String description, double prixUnit, Categorie categorie) {
		super();
		this.reference = reference;
		this.description = description;
		this.prixUnit = prixUnit;
		this.categorie = categorie;
	}

	public long getReference() {
		return reference;
	}

	public void setReference(long reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrixUnit() {
		return prixUnit;
	}

	public void setPrixUnit(double prixUnit) {
		this.prixUnit = prixUnit;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
}