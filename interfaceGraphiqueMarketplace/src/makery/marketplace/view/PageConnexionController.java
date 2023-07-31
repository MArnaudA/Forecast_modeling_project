package makery.marketplace.view;

import java.io.IOException;
import MarketplaceJava.Vendeur;
import MarketplaceJava.Client;
import makery.marketplace.model.User;
import makery.marketplace.view.PageInscriptionClientController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import makery.marketplace.MainApp;
import makery.marketplace.model.User;
import javafx.scene.Node;

public class PageConnexionController {
	@FXML
	private TextField idTextField;
	
	@FXML 
	private TextField passwordTextField;
	
	@FXML
	private Button creerCompteMarketplaceButton;
	@FXML
	private Button creerCompteClientButton;
	@FXML
	private Button creerCompteLivreurButton;
	@FXML
	private Button creerCompteVendeurButton;
	
	@FXML 
	private Button valider;
	
	public static Client client;
	
	private MainApp mainApp = new MainApp();
	
	
	@FXML
	private void handleNewClient() {
		User user = new User(null,"Client",null,null,null,null,null,null);
		boolean okClicked = mainApp.showNewClientDialog(user);
		if(okClicked) {
			mainApp.getUserData().add(user);
		}
	}
	
	@FXML
	private void handleNewVendeur() {
		User user = new User(null,"Vendeur",null,null,null,null,null,null);
		boolean okClicked = mainApp.showNewVendeurDialog(user);
		if(okClicked) {
			mainApp.getUserData().add(user);
		}
	}
	
	@FXML
	private void handleNewMarketplace() {
		User user = new User(null,"Marketplace",null,null,null,null,null,null);
		boolean okClicked = mainApp.showNewMarketplaceDialog(user);
		if(okClicked) {
			mainApp.getUserData().add(user);
		}
	}
	
	@FXML
	private void handleNewLivreur() {
		User user = new User(null,"Livreur",null,null,null,null,null,null);
		boolean okClicked = mainApp.showNewLivreurDialog(user);
		if(okClicked) {
			mainApp.getUserData().add(user);
		}
	}
	@FXML
	private void validation(ActionEvent actionEvent){
		Integer id = Integer.parseInt(idTextField.getText()) ;
		String password = passwordTextField.getText();
		String messageConfirmation ="";
		for(User parcoursUser : mainApp.getUserData()) {
			if (parcoursUser.getIdentifiant().equals(id) && parcoursUser.getPassword().equals(password)) {
				if(parcoursUser.getTypeUser()=="Client") {
					try {
			    		client = new Client(parcoursUser.getPassword(),parcoursUser.getNom(),parcoursUser.getPrenom(),parcoursUser.getTel(),parcoursUser.getMail(),parcoursUser.getAdresse(),false);
						Parent root1 = FXMLLoader.load(getClass().getResource("client.fxml"));
						Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
						stage.setScene(new Scene(root1));
						stage.show();
						
			        	
			    	}catch(Exception e) {
			    		e.printStackTrace();
			    	}
				}
				messageConfirmation="combinaison valide";
				System.out.println(messageConfirmation);
				break;
			}
			
		}
		if(messageConfirmation.length()==0) {
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("Identifiants, mot de passe et type incorrects");
	        alert.setHeaderText("La sélection n'est pas reconnue");
	        alert.setContentText("Veuillez réessayer avec des champs corrects");

	        alert.showAndWait();
		
			
		}
	}
	
	
}
