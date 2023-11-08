package produit;

public enum Unite {
	LITRE("l"), GRAMME("g"), KILOGRAMME("kg"), CENTILITRE("cl"), MILILITRE("ml"), PIECE("");

	private String nom;

	private Unite(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return this.nom;
	}
}
