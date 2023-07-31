package makery.marketplace.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class User {
	
	private IntegerProperty identifiant;
	private StringProperty password;
	private StringProperty nom;
	private StringProperty mail;
	private StringProperty prenom;
	private StringProperty adresse;
	private StringProperty tel;
	private String typeUser;
	private StringProperty nomEntreprise;
	private static int compteurId = 0;
	
	
	public User(String password, String typeUser, String nom, String prenom, String adresse, String mail, String tel, String nomEntreprise) {
		this.identifiant=new SimpleIntegerProperty(compteurId);
		this.password=new SimpleStringProperty(password);
		this.typeUser=typeUser;
		this.nom=new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.adresse = new SimpleStringProperty(adresse);
		this.mail = new SimpleStringProperty(mail);
		this.tel = new SimpleStringProperty(tel);
		this.nomEntreprise = new SimpleStringProperty(nomEntreprise);
	}
	
	public String getMail() {
		return mail.get();
	}
	public void setMail(String mail) {
		this.mail.set(mail);
	}
	
	public String getNomEntreprise() {
		return nomEntreprise.get();
	}
	
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise.set(nomEntreprise);
	}

	@Override
	public String toString() {
		return "User [identifiant=" + identifiant + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", tel=" + tel + ", typeUser=" + typeUser + ", nomEntreprise="
				+ nomEntreprise + "]";
	}

	public String getNom() {
		return nom.get();
	}


	public void setNom(String nom) {
		this.nom.set(nom);
	}


	public String getPrenom() {
		return prenom.get();
	}


	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}


	public String getAdresse() {
		return adresse.get();
	}


	public void setAdresse(String adresse) {
		this.adresse.set(adresse);
	}


	public String getTel() {
		return tel.get();
	}


	public void setTel(String tel) {
		this.tel.set(tel);
	}


	public String getTypeUser() {
		return typeUser;
	}


	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}


	public  Integer getIdentifiant() {
		return identifiant.get();
	}


	public void setIdentifiant(int identifiant) {
		this.identifiant.set(identifiant);
	}


	public String getPassword() {
		return password.get();
	}


	public void setPassword(String pass) {
		this.password.set(pass);
	}


	public static int getCompteurId() {
		return compteurId;
	}


	public static void setCompteurId(int compteurId) {
		User.compteurId = compteurId;
	}
	
	public IntegerProperty idProperty() {
		return identifiant;
	}
	
	public StringProperty passwordProperty() {
		return password;
	}
	
}


