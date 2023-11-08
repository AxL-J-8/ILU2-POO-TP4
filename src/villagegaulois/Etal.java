package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;
import produit.Produit;

public class Etal<P extends IProduit> implements IEtal {
	private Gaulois vendeur;
	private P[] produit ;
	private int nbProduit;
	private int prix;
	@Override
	public Gaulois getVendeur() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double donnerPrix() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int contientProduit(String produit, int quantiteSouhaitee) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double acheterProduit(int quantiteSouhaitee) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String etatEtal() {
		// TODO Auto-generated method stub
		return null;
	}

}
