package produit;



public abstract class Produit implements IProduit {
	private String nom;
	private Unite uniteP;

	@Override
	public String getNom() {
		return nom;
	}

	public Produit(String nom,Unite uniteP) {
		this.nom = nom;
		this.uniteP=uniteP;
	}

	@Override
	public void setUniteP(Unite uniteP) {
		this.uniteP = uniteP;
	}
	@Override
	public Unite getUniteP() {
		return uniteP;
	}

	@Override
	public abstract void descriptionProduit();
}
