package produit;

public class Poisson extends Produit {
   private String dateDePeche;
   
   public Poisson(String date) {
	   super("poisson",Unite.PIECE);
	   this.dateDePeche=date;
   }
	@Override
	public void description() {
		System.out.println(descriptionProduit());

	}

	@Override
	public String descriptionProduit() {
		return "poisson pechés le "+dateDePeche;
	}
	public double calculerPrix(double prix) {
		return prix;
	}

}
