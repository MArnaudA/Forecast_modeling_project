import java.time.temporal.Temporal;
import java.time.LocalDateTime;

public final class Produit {
	private String nom;
	private boolean estExterne;
	private long referenceProduit;
	private static long compteur=500;
	private String description;
	private Temporal dateEstimeeLivraison;
	private double prix;
	private int stock;
	private int nbVendu;
	private double profitProduit;
	private Vendeur vendeur;
	
	public Produit(Vendeur vendeur, String nom,boolean estExterne, String description, Temporal dateEstimeeLivraison, double prix, int stock, double profitProduit) {
		super();
		++compteur;
		this.vendeur=vendeur;
		this.nom = nom;
		this.referenceProduit = compteur; 
		this.estExterne = estExterne;
		this.description = description;
		this.dateEstimeeLivraison = dateEstimeeLivraison;
		this.prix = prix;
		this.stock = stock;
		this.profitProduit = profitProduit;
		this.nbVendu = 0;
	}

	public double getCA() {
		return (this.nbVendu*this.profitProduit) ;
	}

	public String getNom() {
		return nom;
	}

	public long getReferenceProduit() {
		return referenceProduit;
	}

	public String getDescription() {
		return description;
	}

	public Temporal getDateEstimeeLivraison() {
		return dateEstimeeLivraison;
	}

	public double getPrix() {
		return prix;
	}

	public int getStock() {
		return stock;
	}

	public int getNbVendu() {
		return nbVendu;
	}

	public double getProfitProduit() {
		return profitProduit;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setReferenceProduit(long referenceProduit) {
		this.referenceProduit = referenceProduit;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDateEstimeeLivraison(Temporal dateEstimeeLivraison) {
		this.dateEstimeeLivraison = dateEstimeeLivraison;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setNbVendu(int nbVendu) {
		this.nbVendu = nbVendu;
	}

	public void setProfitProduit(double profitProduit) {
		this.profitProduit = profitProduit;
	}

	public boolean getEstExterne() {
		return estExterne;
	}

	@Override
	public String toString() {
		return "Produit [nom=" + nom + ", referenceProduit=" + referenceProduit + ", description=" + description
				+ ", dateEstimeeLivraison=" + dateEstimeeLivraison + ", prix=" + prix + ", stock=" + stock
				+ ", nbVendu=" + nbVendu + ", vendeur=" +  vendeur.getNomEntreprise() +  "]";
	}

	
	
	
	
	
}

