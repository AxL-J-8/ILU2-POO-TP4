package village;

import personnages.Gaulois;
import produit.Produit;
import scenarioTest.Scenario.DepenseMarchand;
import villagegaulois.Etal;

public interface IVillage {
public <P extends Produit> boolean installerVendeur(Etal<P> etal,
Gaulois vendeur, P[] produit, int prix);


public DepenseMarchand[] acheterProduit(String produit,
int quantiteSouhaitee);
}
