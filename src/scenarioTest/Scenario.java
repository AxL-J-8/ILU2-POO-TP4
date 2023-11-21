package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import village.IVillage;
import villagegaulois.Etal;

public class Scenario {

	public static class DepenseMarchand {
		private Gaulois marchand;
		private int qteVendue;
		private double prixPaye;
		private double sommeDepensee;
		private String produit;

		public DepenseMarchand(Gaulois marchand, int qteVendue, String produit, double prixPaye, double sommeDepensee) {
			this.marchand = marchand;
			this.qteVendue = qteVendue;
			this.prixPaye = prixPaye;
			this.sommeDepensee = sommeDepensee;
			this.produit = produit;

			if (qteVendue > 1) {
				this.produit += "s";
			}
		}

		public String toString() {
			return "Achat de " + qteVendue + " " + produit + " sur l'étal du marchand " + marchand.getNom()
					+ " pour un total de " + sommeDepensee + " sous.\n";
		}

	}

	public static void main(String[] args) {

		// TODO Partie 4 : creer de la classe anonyme Village

		class Village implements IVillage {
			private Etal[] marche;
			private int nbEtal = 0;
			private int nbEtalMax;

			private Village(int nbEtalmax) {
				marche=new Etal[nbEtalmax];
				this.nbEtalMax=nbEtalmax;
			};

			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				if (nbEtal < nbEtalMax) {
					etal.installerVendeur(vendeur,produit,prix);
					marche[nbEtal]=etal;
					nbEtal++;
					return true;
				}
				return false;
			}

			@Override
			public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
            int quantiteAcheter;
            int quantiteRestant;
            int i=0;
            double prix;
            DepenseMarchand[] depenses=new DepenseMarchand[nbEtal];
            quantiteRestant=quantiteSouhaitee;
            while(quantiteRestant>0 && i<nbEtal) {
			 
			 quantiteAcheter=marche[i].contientProduit(produit, quantiteRestant);
			 if(quantiteAcheter>0) {
				 prix=marche[i].acheterProduit(quantiteAcheter);
				 depenses[i]=new DepenseMarchand(marche[i].getVendeur(), quantiteAcheter, produit, prix, prix);
			 }
			 quantiteRestant-=quantiteAcheter;
			 i++;
			}
            return depenses;
			}
			@Override
		    public String toString() {
		    	StringBuilder sb=new StringBuilder();
		    	for(int i=0;i<nbEtal;i++) {
		    		sb.append(marche[i].etatEtal());
		    		sb.append("\n");
		    	}
				return sb.toString();
		    }

		}

		// fin
        Village village=new Village(3);
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village);

	}

}