import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Produit } from '../model/produit';
import { Categorie } from '../model/categorie';

@Component({
  selector: 'app-ajout-produit',
  standalone: false,

  templateUrl: './ajout-produit.component.html',
  styleUrls: ['./ajout-produit.component.css']
})

export class AjoutProduitComponent {
  reference: number = 0;
  description: string = '';
  prixUnit: number = 0;
  categorieId: number = 0;

  categories: { idCategorie: number; nomCategorie: string }[] = [];

  private urlAjoutProduit = 'http://localhost:8080/ajoutProduit';
  private urlCategories = 'http://localhost:8080/categories';

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.getCategories();
  }

  //categories
  getCategories() {
    this.http.get<any[]>(this.urlCategories).subscribe(
      (data) => {
        this.categories = data;
      },
    );
  }

  // Ajouter un produit
  ajoutProduit() {
    const produit = { 
      description: this.description,
      prixUnit: this.prixUnit,
      categorie: { idCategorie: this.categorieId },
    };

    console.log('Produit à ajouter :', produit);
    this.resetForm();
    this.http.post<any>(this.urlAjoutProduit, produit).subscribe(
      (response) => {
        console.log('Produit ajouté avec succès :', response);
        this.reference = 0;
        this.description = '';
        this.prixUnit = 0;
        this.categorieId = 0;
      },
    );
  }

  // Renitialisation du formulaire
  resetForm() {
    this.description = '';
    this.prixUnit = 0;
    this.categorieId = 0; 
  }
}