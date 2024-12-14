import { Categorie } from "./categorie";

export class Produit {
    constructor(
        public reference: number,
        public description: string,
        public prixUnit: number,
        public categorie?: Categorie
    ) {}
}

