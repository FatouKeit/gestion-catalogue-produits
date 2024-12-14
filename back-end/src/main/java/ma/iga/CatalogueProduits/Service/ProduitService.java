package ma.iga.CatalogueProduits.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.iga.CatalogueProduits.Entity.Categorie;
import ma.iga.CatalogueProduits.Entity.Produit;
import ma.iga.CatalogueProduits.Repository.CategorieRepository;
import ma.iga.CatalogueProduits.Repository.ProduitRepository;

@Service
public class ProduitService {
    
    @Autowired
    private ProduitRepository prdRepository;
    @Autowired
    private CategorieRepository categorieRepository;

    public Produit ajouterProduit(Produit produit) {
        return prdRepository.save(produit);
    }
    
    //Recupere produits par catégorie
    public List<Produit> getProduitsParCategorie(int idCategorie) {
        return prdRepository.findByCategorieIdCategorie(idCategorie);
    }
    
}