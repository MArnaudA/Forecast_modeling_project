package makery.marketplace.view;

import java.io.IOException;

import makery.marketplace.model.User;
import makery.marketplace.view.PageInscriptionClientController;
import makery.marketplace.view.PageConnexionController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PageInscriptionMarketplaceController {
	@FXML
	private TextField mdpTextField;
	@FXML 
	private TextField mdpConfirmationTextField;
	@FXML
	private TextField mailTextField;
	@FXML
	private TextField nomTextField;
	@FXML
	private TextField prenomTextField;
	@FXML
	private TextField telTextField;
	@FXML
	private TextField adresseTextField;
	
	@FXML
	private TextField idAttribue;
	
	private Stage dialogStage;
	private User user;
	private boolean okClicked = false;
	
	@FXML
	private void initialize() {
		idAttribue.setEditable(false);
		idAttribue.setText(Integer.toString(User.getCompteurId()+1));
		
	}
	public PageInscriptionMarketplaceController() {
		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage=dialogStage;
	}
	
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			user.setPassword(mdpTextField.getText());
			user.setAdresse(adresseTextField.getText());
			user.setNom(nomTextField.getText());
			user.setPrenom(prenomTextField.getText());
			user.setMail(mailTextField.getText());
			user.setTel(telTextField.getText());
			user.setIdentifiant(Integer.parseInt(idAttribue.getText()));
			okClicked = true;
			User.setCompteurId(User.getCompteurId()+1);
			dialogStage.close();
		}	
	}
	
	@FXML
	private void handleCancel(){
		dialogStage.close();
	}
	
	public void setUser(User user) {
		this.user = user;
		
		
	}
	
	private boolean isInputValid() {
		String errorMessage="";
		if(mdpTextField.getText()==null || mdpTextField.getText().length()==0) {
			errorMessage+= "Le mot de passe est vide. ";
		}
		if(mdpConfirmationTextField.getText()==null || mdpConfirmationTextField.getText().length()==0) {
			errorMessage+="Il faut confirmer votre mot de passe. ";
		}
		if(!mdpTextField.getText().equals(mdpConfirmationTextField.getText())) {
			errorMessage+="Le mot de passe et la confirmation ne correspondent pas. ";
		}
		if(mailTextField.getText()==null || mailTextField.getText().length()==0) {
			errorMessage+="Le mail est vide. ";
		}
		if(nomTextField.getText()==null || nomTextField.getText().length()==0) {
			errorMessage+="Le nom est vide. ";
		}
		if(prenomTextField.getText()==null || prenomTextField.getText().length()==0) {
			errorMessage+="Le prenom est vide. ";
		}
		if(adresseTextField.getText()==null || adresseTextField.getText().length()==0) {
			errorMessage+="L'adresse est vide";
		}
		if(errorMessage.length()==0) {
			return true;
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("champs invalides");
			alert.setContentText(errorMessage);;
			alert.showAndWait();
			return false;
		}
	}
}
