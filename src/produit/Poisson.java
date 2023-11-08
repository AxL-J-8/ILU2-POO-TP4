package produit;

public class Poisson extends Produit {
   private String dateDePeche;
   
   public Poisson(String date) {
	   super("poisson",Unite.PIECE);
	   this.dateDePeche=date;
   }
	@Override
	public void descriptionProduit() {
		System.out.println("poisson pechés le "+dateDePeche);

	}

}
