package ma.iga.CatalogueProduits.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ma.iga.CatalogueProduits.Entity.Produit;
import ma.iga.CatalogueProduits.Repository.ProduitRepository;
import ma.iga.CatalogueProduits.Service.ProduitService;

@RestController
public class ProduitController {
	
	@Autowired
	private ProduitRepository prdRepository;
	
	@Autowired
    private ProduitService produitService;
	
	//GET // RECUPERER LA LISTE DES PRODUITS
	@RequestMapping(value = "/produits")
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public List<Produit> produits() {
	    return (List<Produit>) prdRepository.findAll();
	}
	
	
	//AJOUTER UN NOUVEAU PRODUIT
	@RequestMapping(
		    value = "/ajoutProduit",
		    produces = MediaType.APPLICATION_JSON_VALUE,
		    consumes = MediaType.APPLICATION_JSON_VALUE,
		    method = RequestMethod.POST
		)
		@CrossOrigin(origins = "http://localhost:4200")
		public Produit ajoutProduit(@RequestBody Produit produit) {
		    return produitService.ajouterProduit(produit);
		}
	
	
	// FILTRER L'AFFICHAGE DES PRODUITS PAR CATEGORIE
	@RequestMapping(value = "/produits/{idCategorie}", 
			method = RequestMethod.GET,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	    @CrossOrigin(origins = "http://localhost:4200")
	    public List<Produit> getProduitsParCategorie(@PathVariable int idCategorie) {
	        return produitService.getProduitsParCategorie(idCategorie);
	    }
	
	
	// SUPPRESSION PRODUIT
	@RequestMapping(
		    value = "/produits/{reference}",
		    method = RequestMethod.DELETE,
		    produces = MediaType.APPLICATION_JSON_VALUE
		)
	    @CrossOrigin(origins = "http://localhost:4200")
	public String deleteProduit(@PathVariable("reference") Long reference) {
	    if (prdRepository.existsById(reference)) {
	        prdRepository.deleteById(reference);
	        return "{\"message\":\"Produit supprimé avec succès\"}";
	    }
	    return "{\"message\":\"Produit non trouvé\"}";
	}
}
