import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Client extends Utilisateur {
	private Map<Produit, Integer> panier = new HashMap<Produit, Integer>();
	boolean prime;
  Scanner input = new Scanner(System.in);

	public Client(String password, String Nom, String Prenom, String Telephone, String email, String Adresse, boolean prime) {
        super(password, email, Nom, Prenom, Telephone, Adresse);
		this.panier = new HashMap<Produit, Integer>();
		this.prime = prime;
	}

	public Map<Produit, Integer> getpanier() {
		return (Map<Produit, Integer>) panier;
	}

	public boolean isPrime() {
		return prime;
	}

	public void setpanier(Map<Produit, Integer> panier) {
		panier = (Map<Produit, Integer>) panier;
	}

	public void setPrime(boolean prime) {
		this.prime = prime;
	}

	
  
	public void Ajouter_au_panier(long ref, int qtty){
		Produit prd = Marketplace.getMarketplace().rechercherProduitByRef(ref);
		if(prd.getStock()>0 && qtty< prd.getStock()){
			panier.put(prd, qtty);
			System.out.println(""+prd.getNom()+" a été ajouté a votre panier");
		}else{
			System.out.println("Le produit "+prd.getNom()+" n'est pas disponible en stock");
		}
	}

	public void Supprimer_du_panier(long ref, int qtty){
		Produit prd = Marketplace.getMarketplace().rechercherProduitByRef(ref);
		if(panier.containsKey(prd)==true){
          System.out.print("Voulez-vous vraiment supprimer cet article de votre panier ? y/n ");
          String confirmation = input.nextLine();
          confirmation = confirmation.toLowerCase();
            if(confirmation.equals("y")){
                panier.remove(qtty);
                System.out.println(""+prd.getNom()+"a été supprimé de votre panier");
            }else{
                System.out.println(""+prd.getNom()+"n'a pas été supprimer");
            }
		}else{
			System.out.println(""+prd.getNom()+"n'a pas été trouvé");
		}
	}

    public void Vider_panier(){
    if(panier.size()==0){
    System.out.println("votre panier est vide !!");
    }else{
      System.out.print("Voulez-vous vraiment vider votre panier ? y/n");
      String confirmation = input.nextLine();
      confirmation = confirmation.toLowerCase();
      while(confirmation.equals("y")==false && confirmation.equals("n")==false){
        System.out.println("Choix est invalide");
        System.out.print("Voulez-vous vraiment supprimer cet article de votre panier ? y/n");
        confirmation = input.nextLine();
        confirmation = confirmation.toLowerCase();
      }
      if(confirmation.equals("y")){
          panier.clear();
          System.out.println("Votre paier a été vidé avec succès !");
      }else{
          System.out.println("Votre paier n'a pas été vidé !");
      }
    }
  }
  
    public void Afficher_panier(){
  		 Set<Produit> keys = panier.keySet();
  		int count = 0;
  		for(Produit i : keys ){
              System.out.println("[ le nom du produit: "+i.getNom()+" | le prix de l'unité: "+i.getPrix()+" | la quantité commandée: "+panier.get(i)+"]");
              count += i.getPrix();
              count = count*panier.get(i);
  		}
  		System.out.print("le prix total de votre panier est de: "+count);
  	}

    public boolean Valider_panier(){
        if(panier.size() > 0){
            Commande cmd = new Commande(this, (HashMap<Produit, Integer>) this.panier, this.getAdresse());
            System.out.print("l'adresse de livraison par defaut est: "+getAdresse());
            System.out.print("Voulez-vous changer l'adresse de livraison ? y/n");
            String confirmation = input.nextLine();
            confirmation = confirmation.toLowerCase();
            while(confirmation.equals('y')==false && confirmation.equals('n')==false){
                System.out.println("Choix est invalide");
                System.out.print("Voulez-vous changer l'adresse de livraison ? y/n");
                confirmation = input.nextLine();
                confirmation = confirmation.toLowerCase();
            }
          if(confirmation.equals('n')){
            return true;
          }else{
                System.out.print("Veuillez tapper la nouvelle adresse :");
                String newAdress = input.nextLine();
                System.out.print("la nouvelle adresse est : "+newAdress);
                cmd.setAdresse(newAdress);
                System.out.print("l'adresse est elle correct ? y/n");
                String conf = input.nextLine();
                conf = conf.toLowerCase();
                while(!conf.equals('y') && !conf.equals('n')){
                  System.out.println("Choix est invalide");
                  System.out.print("la nouvelle adresse est : "+newAdress);
                  System.out.print("l'adresse est elle correct ? y/n");
                  conf = input.nextLine();
                  conf = conf.toLowerCase();
                }
                while(conf.equals('n')){
                  System.out.print("la nouvelle adresse est : "+newAdress);
                  System.out.print("L'adresse est elle correct ? y/n");
                  conf = input.nextLine();
                  conf = conf.toLowerCase();
                }
              }
          return true;
            
        }else{
          System.out.print("Votre panier est vide !");
          return false;
        }     
  }
  


    public void recevoirNotification(Colis c) { // appelé par le livreur ou la marketplace lors d'un changement de statut d'un colis
        if (c.getStatut().equals(Colis.Statut.LIVRE))
            System.out.println("Le colis numéro " + c.getNumero() + " a été livré.");
        else
            System.out.println("Le colis numéro " + c.getNumero() + " a été expédié.");
    }

	@Override
	public String toString() {
		return "Client [panier=" + panier + ", prime=" + prime + ", input=" + input + "]";
	}
}
