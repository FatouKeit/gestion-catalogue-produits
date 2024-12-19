import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Produit } from '../model/produit';
import { Categorie } from '../model/categorie';

@Component({
  selector: 'app-afficher-produit',
  standalone: false,
  
  templateUrl: './afficher-produit.component.html',
  styleUrls: ['./afficher-produit.component.css']
})

export class AfficherProduitComponent implements OnInit {
  produits: Produit[] = [];
  categories: Categorie[] = [];
  selectedCategory: number = 0;

  
  private urlProduits = 'http://localhost:8080/produits';
  private urlCategories = 'http://localhost:8080/categories';

  constructor(private client: HttpClient) {}
  
  ngOnInit(): void {
    this.getProduits();
    this.getCategories();
  }

   // produits
   getProduits() {
    let url = this.selectedCategory ? `${this.urlProduits}/${this.selectedCategory}` : this.urlProduits;
    
    this.client.get<Produit[]>(url).subscribe({
      next: (reponse) => {
        this.produits = reponse;
        console.log('Produits récupérés : ', reponse);
      },
    });
  }

  // categories
  getCategories() {
    this.client.get<Categorie[]>(this.urlCategories).subscribe({
      next: (reponse) => {
        this.categories = reponse;
        console.log('Catégories récupérées : ', reponse);
      },
    });
  }

  // Filtration
  filterByCategory() {
    this.getProduits(); 
  }


  //Supprimer Produit
  deleteProduit(produit: Produit): void {
    const reference = produit.reference;
    this.client.delete(`http://localhost:8080/produits/${reference}`).subscribe({
      next: (response) => {
        this.produits = this.produits.filter(p => p.reference !== reference);
        console.log('Produit supprimé');
        // Actualisation produits
        this.getProduits();
      },
      error: (error) => {
        console.error('Erreur de suppression:', error);
      }
    });
  }

}