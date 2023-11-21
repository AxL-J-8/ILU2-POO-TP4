package produit;

public interface IProduit {

	String getNom();

	void setUniteP(Unite uniteP);

	Unite getUniteP();

	void description();
	double calculerPrix(double prix);

	String descriptionProduit();


}