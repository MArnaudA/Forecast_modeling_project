public class Utilisateur {
	public int identifiant;
	public static int compteur=100;
	protected String password;
	protected String mail;
	protected String nom;
	private String prenom;
	private String tel;
	private String adresse;
	
	
	public Utilisateur(String password, String mail, String nom, String prenom, String tel, String adresse) {
		super();
		++compteur;
		this.identifiant = compteur;
		this.password = password;
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.setAdresse(adresse);
	}
	
	public boolean sidentifier(int identifiant, String password) {
		if (identifiant == this.identifiant && password == this.password) {
			System.out.println("Identification reussie !");
			return true;
		}
		else {
			System.out.println("Identifiant et/ou mot de passe incorrect !");
			return false;
		}
	}

	public int getIdentifiant() {
		return identifiant;
	}


	public String getPassword() {
		return password;
	}


	public String getMail() {
		return mail;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getTel() {
		return tel;
	}


	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
}
