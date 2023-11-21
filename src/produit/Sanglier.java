package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
    private Gaulois chasseur;
    private double poids;
    
	public Sanglier(int poids,Gaulois gaulois) {
		super("sanglier",Unite.KILOGRAMME);
         this.chasseur=gaulois;
         this.poids=poids;
	}

	@Override
	public void description(){
		System.out.println(descriptionProduit());
	}
	
	public  String descriptionProduit() {
		return "sanglier de "+poids+" "+super.getUniteP().toString()+" chassé par "+chasseur.getNom();
		
	}
	public double calculerPrix(double prix) {
		return (poids/1000)*prix;
	}


}
