import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { AfficherProduitComponent } from './afficher-produit/afficher-produit.component';
import { AjoutProduitComponent } from './ajout-produit/ajout-produit.component';

const routes: Routes = [
  { path: 'ajouter', component: AjoutProduitComponent },
  { path: 'afficher', component:AfficherProduitComponent },
  { path: 'acceuil', component: AcceuilComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
