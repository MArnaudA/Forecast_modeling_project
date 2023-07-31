import java.util.ArrayList;
import java.util.HashMap;

public final class Commande {
	
	private long numero;
	private Client client;
	private String adresse;
	private HashMap<Produit, Integer> composants; /* contient le produit et la quantité demandée associée*/
	private ArrayList<Colis> ensembleColis = new ArrayList<Colis>();
	private static long compteur = 6000;	
	
	public Commande(Client client, HashMap<Produit, Integer> comp, String adresse) {
    ++compteur;
    this.numero = compteur;
    this.client = client;
    this.adresse = adresse;
    this.composants = comp;
    /* Il faudra ajouter la méthode expédier commande qui sépare la commande en une arraylist de produits*/
    }

	public long getNumero() {
		return numero;
	}

	public Client getClient() {
		return client;
	}

	public String getAdresse() {
		return adresse;
	}

  public void setAdresse(String adr) {
		this.adresse = adr;
	}

	public HashMap<Produit, Integer> getComposants() {
		return composants;
	}

	public ArrayList<Colis> getEnsembleColis() {
		return ensembleColis;
	}

	public static long getCompteur() {
		return compteur;
	}

	@Override
	public String toString() {
		return "Commande [numero=" + numero + ", client=" + client + ", adresse=" + adresse + ", composants="
				+ composants + ", ensembleColis=" + ensembleColis + "]";
	}
	
}