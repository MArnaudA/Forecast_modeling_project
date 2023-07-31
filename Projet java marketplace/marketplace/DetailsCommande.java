public final class DetailsCommande {

	private int quantite;
	
	private Produit _produit;
	private Commande _commande;
	
	@Override
	public String toString() {
		return "Le produit " + _produit.getReferenceProduit() + " se trouve " + quantite + " fois dans la commande numéro " + _commande.getNumero() + ".";
	}

	public int getQuantite() {
		return quantite;
	}

	

	public Produit get_produit() {
		return _produit;
	}

	

	public Commande get_commande() {
		return _commande;
	}

	
	
	
	 

}
