import java.util.ArrayList;

public final class Livreur extends Utilisateur{
	
	private ArrayList<Colis> listeColis = new ArrayList<Colis>();
	
	
	public Livreur( String nom, String prenom, String psw, String tel, String mail, String adr) {
		super(psw, mail, nom, prenom, tel, adr);
	}
	
	public ArrayList<Colis> afficherColis() {
		return listeColis;
	}
	
	@Override
	public String toString() {
		return "Livreur [nom=" + nom + "]";
	}

	public void notifier(Colis c) {
		c.setStatut(Colis.Statut.LIVRE);
		c.getCommande().getClient().recevoirNotification(c);
	}

	public ArrayList<Colis> getListeColis() {
		return listeColis;
	}

	public void setListeColis(ArrayList<Colis> listeColis) {
		this.listeColis = listeColis;
	}
	
}