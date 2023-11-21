package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Sanglier;
import scenarioTest.Scenario.DepenseMarchand;
import villagegaulois.Etal;

public class ScenarioTest {
	public static void main(String[] args) {

//		Etal<Sanglier> etalSanglier = new Etal<>();
//		Etal<Poisson> etalPoisson = new Etal<>();
//		marche[0] = etalSanglier;
//		marche[1] = etalPoisson;

//		IEtal[] etals = new IEtal[3];
//		Etal<Sanglier> etalSanglier = new Etal<>();
//		etals[0] = etalSanglier;

		// creer des Gaulois
		Gaulois ordralfabetix = new Gaulois("Ordralfabetix", 9);
		Gaulois obelix = new Gaulois("Obelix", 20);
		Gaulois asterix = new Gaulois("Asterix", 6);

		// creer les tableux de produits
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		Etal[] marche = new Etal[3];
		Etal<Sanglier> etalSanglier1 = new Etal<>();
		Etal<Sanglier> etalSanglier2 = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		marche[0] = etalSanglier1;
		marche[1] = etalSanglier2;
		marche[2] = etalPoisson;
		
		marche[0].installerVendeur(asterix, sangliersAsterix, 10);
		marche[1].installerVendeur(obelix, sangliersObelix, 8);
		marche[2].installerVendeur(ordralfabetix, poissons, 7);
		
		/// affichage marche
		
		int quantiteRestant;
		int quantiteAcheter;
		double prix=0;
		int indx=0;

		etatMarche(marche);
        quantiteRestant=3;
        while(quantiteRestant>0 && indx<3) {
		 
		 quantiteAcheter=marche[indx].contientProduit("sanglier", quantiteRestant);
		 if(quantiteAcheter>0) {
			 prix=marche[indx].acheterProduit(quantiteAcheter);
			 System.out.println("A l'étal "+indx+ " je paye "+prix+ " sous\n");
		 }
		 quantiteRestant-=quantiteAcheter;
		 indx++;
		}
        System.out.println("Je voulais 3 sangliers, j'en ai acheté 3");
        etatMarche(marche);
	}

public static void etatMarche(Etal[ ]marche) {
	for (int i=0;i<3;i++) {
		System.out.println(marche[i].etatEtal());
	}
}
}
