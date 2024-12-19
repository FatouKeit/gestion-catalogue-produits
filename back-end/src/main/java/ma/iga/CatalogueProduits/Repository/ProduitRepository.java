package ma.iga.CatalogueProduits.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.iga.CatalogueProduits.Entity.Produit;


public interface ProduitRepository extends JpaRepository<Produit,Long>{

	List<Produit> findByCategorieIdCategorie(int idCategorie);
	
	Produit findByReference(long reference);
}
