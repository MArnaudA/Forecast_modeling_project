package MarketplaceJava;

import java.time.LocalDateTime;
import java.util.HashMap;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Marketplace.getMarketplace();
		Vendeur Jean = new Vendeur("monMDP", "jean@market.fr", "BOU","Jean", "06.50.20.20.20", "Cery", "Apple");
		Jean.ajouterProduit("iPhoneXX", "Le meilleur tel du monde", LocalDateTime.of(2022,04,20,0,0,0), 1200, 10, 100);
		Jean.ajouterProduit("iPhoneX", "Le meilleur tel du monde", LocalDateTime.of(2022,04,21,0,0,0), 1200, 10, 100);
		Jean.ajouterProduit("iPhone9", "Le meilleur tel du monde", LocalDateTime.of(2022,04,27,0,0,0), 1200, 10, 100);
		Jean.ajouterProduit("iPhone12", "Le meilleur tel du monde", LocalDateTime.of(2022,05,12,0,0,0), 1200, 10, 100);
		Client Arnaud = new Client("bonjour123", "Mouttapa", "Arnaud", "0635252512", "ar.mout@gmail.com", "3 rue de la fleur Cergy", true);
		
		Livreur livreur=new Livreur("nom","prenom","psw","tel","mail","adr");
		Colis colis=new Colis(livreur,null);
		livreur.getListeColis().add(colis);
		Marketplace.getMarketplace().getListeLivreurs().add(livreur);
		
		//Jean.afficherProduits();
		
		//System.out.println(Jean.rechercherProduitByRef(502));
		
		Vendeur Jeanne = new Vendeur("monMDP", "jeanne@market.fr", "BOU","Jeanne", "06.50.20.20.50", "Cery", "Appla");
		Jeanne.ajouterProduit("iPad", "Le meilleur tab du monde", LocalDateTime.of(2022,04,20,0,0,0), 1500, 10, 100);
		Jeanne.ajouterProduit("iPad", "Le meilleur tab du monde", LocalDateTime.of(2022,04,20,0,0,0), 1500, 10, 100);
		//Jeanne.afficherProduits();
		Produit pdt1 = new Produit(Jeanne, "iPhoneXX",false, "Le meilleur tel du monde",LocalDateTime.of(2022,04,20,0,0,0),1200,10,100);
		Produit pdt2 = new Produit(Jeanne,"iPhone12",false, "Le meilleur tel du monde", LocalDateTime.of(2022,05,12,0,0,0), 1200, 10, 100);
		Marketplace.getMarketplace().catalogue();
		
		
		System.out.println(Marketplace.getMarketplace().getListeVendeurs());
		
		Jean.supprimerProduitByRef(501);
		Jean.afficherProduits();
		
		HashMap<Produit, Integer> listepdt = new HashMap<Produit, Integer>();
		listepdt.put(pdt1,4);
		listepdt.put(pdt2, 2);
		Commande commande = new Commande(Arnaud,listepdt,"1 rue d'enghien" );
		System.out.println(commande);
		Marketplace.getMarketplace().expedierCommande(commande);
		System.out.println(commande.getEnsembleColis());
		
		
	}

}
