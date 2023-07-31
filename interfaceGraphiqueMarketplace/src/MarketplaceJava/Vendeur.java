package MarketplaceJava;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.time.temporal.*;
import java.time.LocalDateTime;


public final class Vendeur extends Utilisateur {
	private String nomEntreprise;
	private Set<Produit> listeProduitVendeur = new HashSet<Produit>();
	private Map <Long,Produit> produitByRef;
	private Map <String,Produit> produitByNom;
	
	public Vendeur(String password, String mail, String nom, String prenom, String tel, String adresse, String nomEntreprise) {
		/*super.password=password;
		super.id=1;*/ /* Ce sont les attributs à définir dans la classe user*/
		super(password, mail, nom, prenom, tel, adresse);
		this.nomEntreprise = nomEntreprise;
		this.listeProduitVendeur = new HashSet<Produit>();
		this.produitByNom= new HashMap<String,Produit>();
		this.produitByRef= new HashMap<Long,Produit>();
	}
	
	
// -------------------- Ajout d'un produit ----------------
	
	public boolean ajouterProduit(String nom, String description, LocalDateTime dateEstimeeLivraison, double prix, int stock, double profitProduit){
		boolean estExterne = true;
		Produit produit = new Produit(this, nom, estExterne, description, dateEstimeeLivraison, prix, stock, profitProduit);
		if(listeProduitVendeur.add(produit)){
			produitByRef.put(produit.getReferenceProduit(), produit);
			produitByNom.put(produit.getNom(), produit);
      Marketplace.getMarketplace().getProduitByRef().put(produit.getReferenceProduit(), produit);
			return true;
		}
		return false;
	}
		
// ---------------- Supprimer un produit -----------------

	public boolean supprimerProduit(Produit produitASupprimer) {
		if (listeProduitVendeur.remove(produitASupprimer)) {
			produitByRef.remove(produitASupprimer.getReferenceProduit(),produitASupprimer);
			produitByNom.remove(produitASupprimer.getNom(),produitASupprimer);
			return true;
		}
		return false;
	}
	
	private <K> boolean supprimerProduit(K clef, Map<K,Produit> index) { 
        if (index.containsKey(clef)){
        	Produit produitASupprimer = index.get(clef);
        	return this.supprimerProduit(produitASupprimer); 
        }
        else return false;
	}
	
	public boolean supprimerProduitByRef(long ref) {
		return supprimerProduit(ref,produitByRef);
	}
	
	public boolean supprimerProduitByNom(String nom) {
		return supprimerProduit(nom,produitByNom);
	}

	
// ----------------- Recherche d'un produit  ----------------
	
	public Produit rechercherProduitByRef(long ref){
		return produitByRef.get(ref);
	}
	
	public Produit rechercherProduitByNom(String nom) {
		return produitByNom.get(nom);
	}
	
	
// ----------------- Getter et Setter -----------------------
	
	public String getNomEntreprise(){
		return nomEntreprise;
	}

	public Set<Produit> getListeProduitVendeur(){
		return listeProduitVendeur;
	}

	public void setNomEntreprise(String nomEntreprise){
		this.nomEntreprise = nomEntreprise;
	}

	public void setListeProduitVendeur(Set<Produit> listeProduitVendeur){
		this.listeProduitVendeur = listeProduitVendeur;
	}

	
// ---------------------- To String --------------------------
	
	@Override
	public String toString() {
		return "Vendeur [nomEntreprise=" + nomEntreprise + ", listeProduit=" + listeProduitVendeur + ", produitByRef="
				+ produitByRef + ", produitByNom=" + produitByNom + "]";
	}

// -------------------- Afficher mes produits ---------------
	
	public void afficherProduits(){
		for(Produit p : this.listeProduitVendeur){
			System.out.println(p);
		}
	}
	
}
