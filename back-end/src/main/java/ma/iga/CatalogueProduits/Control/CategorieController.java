package ma.iga.CatalogueProduits.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.iga.CatalogueProduits.Entity.Categorie;
import ma.iga.CatalogueProduits.Repository.CategorieRepository;

@RestController
public class CategorieController {

	@Autowired
    private CategorieRepository categorieRepository;

    @GetMapping("/categories")
    @CrossOrigin(origins = "http://localhost:4200")
    
    public List<Categorie> getCategories() {
        return categorieRepository.findAll();
    }
}