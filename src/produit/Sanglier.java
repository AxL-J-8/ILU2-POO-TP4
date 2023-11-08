package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
    private Gaulois chasseur;
    private int poids;
    
	public Sanglier(int poids,Gaulois gaulois) {
		super("sanglier",Unite.KILOGRAMME);
         this.chasseur=gaulois;
         this.poids=poids;
	}

	@Override
	public void descriptionProduit() {
		System.out.println("sanglier de "+poids+" "+super.getUniteP().toString()+" chassé par "+chasseur.getNom());
	}

}
