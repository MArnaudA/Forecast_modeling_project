
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.ChronoUnit;





public class Marketplace {
	
	private HashSet<Vendeur> listeVendeurs;
	private HashMap<Vendeur, Contrat> listeContrat; 
	private HashSet<Livreur> listeLivreurs;
	private  HashMap<Long,Produit> produitByRef;
  
	private static Marketplace singleton = null;
  public static Marketplace getMarketplace() {
  if (singleton == null) {
    singleton = new Marketplace(new HashSet<Vendeur>(), new HashMap<Vendeur,Contrat>() , new HashSet<Livreur>(), new HashMap<Long,Produit>() );
  }
  return singleton;
}
  
	public Marketplace(HashSet<Vendeur> listeVendeurs,
			HashMap<Vendeur, Contrat> listeContrat,HashSet<Livreur> listeLivreurs, HashMap<Long,Produit> produitByRef) {
		super();
		this.listeVendeurs = listeVendeurs;
		this.listeContrat = listeContrat;
		this.listeLivreurs= listeLivreurs;
		this.produitByRef=produitByRef;
		
	}


	public Boolean signerContrat(String password, String nomEntreprise, String mail, String prenom, String nom, String tel,String adresse, TemporalAccessor dateFinContrat) {
		Vendeur vendeur= new Vendeur(password,prenom,nom,tel,mail,adresse,nomEntreprise);
		if(listeVendeurs.add(vendeur)) {
			Contrat contrat=new Contrat(dateFinContrat,vendeur);
			listeContrat.put(vendeur,contrat);
			return true;
		}
		return false;
	}
	
	public void renouvelerContrat(Contrat contrat, TemporalAccessor nouvelleDateFin) {
		contrat.setFinContrat(nouvelleDateFin);
	}
	
	public void resilierContrat(Vendeur vendeur) {
		listeVendeurs.remove(vendeur);
		
	}
	
	public void voirChiffreAffaires() {
		double CA=0;
		
		for(HashMap.Entry<Long,Produit> m : produitByRef.entrySet()) {
			if(!m.getValue().getEstExterne()) {
				CA+=m.getValue().getCA();
			}
		}
		
		System.out.println("Le chiffre d'affaires est de "+CA);
	}
	
	
	public void ajouterProduit(Produit produit) {
		produitByRef.put(produit.getReferenceProduit(), produit);
	}

	public Produit rechercherProduitByRef(long ref){
		return produitByRef.get(ref);
	}
	
	public void expedierCommande(Commande commande) {
		
		/* on crée une liste de dates estimées de livraison et on la remplit avec les dates estimées des produits contenus dans la commande*/
		ArrayList<Temporal> listeDateEstimee = new ArrayList<Temporal>();
		for(HashMap.Entry<Produit,Integer> m : commande.getComposants().entrySet()) {
			listeDateEstimee.add(m.getKey().getDateEstimeeLivraison());
		}
		/* On va chercher dans la liste des dates estimées de livraison le minimum et le maximum des dates*/
		Temporal minDate=listeDateEstimee.get(0);
		Temporal maxDate=listeDateEstimee.get(0);
		for(Temporal date : listeDateEstimee) {
			if(ChronoUnit.DAYS.between(minDate,date)<0) {
				/* Si date est antérieure à minDate*/
				minDate=date;	
			}
			
			if(ChronoUnit.DAYS.between(date,maxDate)<0) {
				maxDate=date;
			}
		}	
		
		/* avec ces deux dates extrêmes on calcule l'intervalle de temps entre les deux dates et on le segmente en petits segments de 5 jours. Le nombre de segments est stocké*/
		long nbIntervalle = (ChronoUnit.DAYS.between(minDate,maxDate))/5+1;
		/* On décide de stocker les produits dans une arraylist de hashmaps : les arraylist permettent d'indicer les hashmap qui contiendront les produits. On placera les produits dans les hashmaps en fonction de leur date estimée de livraison. Ainsi, un colis ne contiendra que des produits ayant un écart de jours d'au plus 5 jours*/
		ArrayList<HashMap<Produit,Integer>> tabColis=new ArrayList<HashMap<Produit,Integer>>();
		for(int i=0;i<(int)nbIntervalle;i++) {
			HashMap<Produit,Integer> y=new HashMap<Produit,Integer>();
			tabColis.add(y);
		}
			/* Insertion du produit dans sa hashmap associée, contenant le produit et la quantité commandée*/
		for(HashMap.Entry<Produit,Integer> m : commande.getComposants().entrySet()) {
			int x=(int)ChronoUnit.DAYS.between(minDate, m.getKey().getDateEstimeeLivraison())/5;
			System.out.println(x);
			System.out.println(tabColis.size());
			tabColis.get(x).put(m.getKey(), m.getValue());
		}
		/* création du colis que l'on remplit de chaque élément de la arraylist, si cet élément est non vide*/
		for(HashMap<Produit,Integer> arr : tabColis) {
			if(!arr.isEmpty()) {
				/* recherche du livreur le plus apte à livrer la commande. Ici, c'est le livreur qui à le moins de colis à livrer à ce moment.*/
				int minTaille=1000;
				Livreur livreur=null;
				for(Livreur i : listeLivreurs) {
					if (i.afficherColis().size()<minTaille) {
						livreur=i;
					}
				}
				
				Colis colis=new Colis(livreur,arr);
				colis.setStatut(Colis.Statut.EXPEDIE);
				livreur.getListeColis().add(colis);
				commande.getEnsembleColis().add(colis);
				
			}	
	}
	
		
	}
	public static boolean compareWithAccuracy(Temporal lhs, Temporal rhs, ChronoUnit chronoUnit, long accuracy) {
        assert accuracy >= 0 : "accuracy value should be positive.";

        return compareWithRangeAccuracy(lhs, rhs, chronoUnit, 0, accuracy);
	}
	
	
	public static boolean compareWithRangeAccuracy(Temporal lhs, Temporal rhs, ChronoUnit chronoUnit, long from,
            long to) {
        assert from >= 0 : "from value should be positive.";
        assert to >= 0 : "to value should be positive.";
        assert from <= to : "from value should be less or equal to to value.";

        long diff = Math.abs(chronoUnit.between(lhs, rhs));
        return diff >= from && diff <= to;
    }
 
  public void catalogue(){
    for (Vendeur vendeur : this.listeVendeurs){
      vendeur.afficherProduits();
    }
  }

  public HashMap<Long, Produit> getProduitByRef() {
		return produitByRef;
	}

	public void setProduitByRef(HashMap<Long, Produit> produitByRef) {
		this.produitByRef = produitByRef;
	}


	@Override
	public String toString() {
		return "Marketplace [listeVendeurs=" + listeVendeurs + ", listeContrat=" + listeContrat + ", listeLivreurs="
				+ listeLivreurs + ", produitByRef=" + produitByRef + "]";
	}


		public HashSet<Vendeur> getListeVendeurs() {
		return listeVendeurs;
	}


	public void setListeVendeurs(HashSet<Vendeur> listeVendeurs) {
		this.listeVendeurs = listeVendeurs;
	}


	public HashMap<Vendeur, Contrat> getListeContrat() {
		return listeContrat;
	}


	public void setListeContrat(HashMap<Vendeur, Contrat> listeContrat) {
		this.listeContrat = listeContrat;
	}


	public HashSet<Livreur> getListeLivreurs() {
		return listeLivreurs;
	}


	public void setListeLivreurs(HashSet<Livreur> listeLivreurs) {
		this.listeLivreurs = listeLivreurs;
	}
	
	
	
}
