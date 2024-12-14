package ma.iga.CatalogueProduits.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.iga.CatalogueProduits.Entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
