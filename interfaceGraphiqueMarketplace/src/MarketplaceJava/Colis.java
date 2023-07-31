package MarketplaceJava;

import java.util.HashMap;

public final class Colis {

	public enum Statut {
		ENTREPOT, EXPEDIE, LIVRE
	}

	private Livreur livreur;
	private HashMap<Produit, Integer> composants = new HashMap<Produit, Integer>();  // HashMap avec quantite pour chaque produit
	private int numero;
	private Commande commande;
	private Statut statut;
  private static int compteur = 7000;
	
	
	public Colis(Livreur livreur, HashMap<Produit, Integer> composants) {
		this.livreur = livreur;
		this.statut = Statut.ENTREPOT;
		this.numero = ++compteur;
		this.composants = composants;
	}
  
	
	@Override
	public String toString() {
		return "Colis [livreur=" + livreur + ", composants=" + composants + ", numero=" + numero + ", commande="
				+ commande + ", statut=" + statut + "]";
	}


	public Livreur getLivreur() {
		return livreur;
	}

  @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colis other = (Colis) obj;
		if (statut != other.statut)
			return false;
		return true;
	}

	public HashMap<Produit, Integer> getComposants() {
		return composants;
	}

	public int getNumero() {
		return numero;
	}

	public Commande getCommande() {
		return commande;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	
}
