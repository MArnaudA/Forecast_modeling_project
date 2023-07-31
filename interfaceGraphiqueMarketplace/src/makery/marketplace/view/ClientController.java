package makery.marketplace.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import makery.marketplace.MainApp;

public class ClientController {

    @FXML
    private Button catalogueButton;

    @FXML
    private AnchorPane clientHome;

    @FXML
    private Button commandeButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button panierButton;
    
    @FXML
    void catalogueButton(javafx.event.ActionEvent event){
    	try {
    		
			FXMLLoader catalogue = new FXMLLoader(MainApp.class.getResource("view/catalogue.fxml"));
        	Scene catalogueScene = new Scene(catalogue.load());
        	
        	Stage stage = new Stage();
        	stage.setScene(catalogueScene);
        	stage.show();
        	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	

    }
    
    @FXML
    void panierButtonAction(javafx.event.ActionEvent event) {
    	try {
    		
			FXMLLoader catalogue = new FXMLLoader(MainApp.class.getResource("view/panier.fxml"));
        	Scene catalogueScene = new Scene(catalogue.load());
        	
        	Stage stage = new Stage();
        	stage.setScene(catalogueScene);
        	stage.show();
        	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

}
