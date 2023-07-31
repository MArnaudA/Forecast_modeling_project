package makery.marketplace.view;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Optional;

import MarketplaceJava.Produit;
import MarketplaceJava.Vendeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import makery.marketplace.MainApp;

public class PanierController{

	 @FXML
	    private TableColumn<Produit, String> descriptionPanier;

	    @FXML
	    private Button homeButton;

	    @FXML
	    private TableColumn<Produit, Temporal> livraisonPanier;

	    @FXML
	    private TableColumn<Produit, String> nomPanier;

	    @FXML
	    private TableColumn<Produit, Double> prixPanier;

	    @FXML
	    private TableColumn<Produit, Integer> qttPanier;

	    @FXML
	    private Button retourButton;

	    @FXML
	    private Button searchButton;

	    @FXML
	    private TextField searchField;

	    @FXML
	    private TableView<Produit> tablePanier;

	    @FXML
	    private Button validerButton;

	    @FXML
	    private TableColumn<Produit, String> vendeurPanier;

	    @FXML
	    private Button viderButton;
	    
	    @FXML
	    private TextField totalprix;
	    
	    private MainApp mainApp= new MainApp();
	    

    @FXML
    void homeButtonAction(ActionEvent event) {
    	
    	try {
    		
			FXMLLoader catalogue = new FXMLLoader(MainApp.class.getResource("view/client.fxml"));
        	Scene catalogueScene = new Scene(catalogue.load());
        	
        	Stage stage = new Stage();
        	stage.setScene(catalogueScene);
        	stage.show();
        	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}

    }

    @FXML
    void retourButtonAction(ActionEvent event) {
    	
    	try {
    		
			FXMLLoader catalogue = new FXMLLoader(MainApp.class.getResource("view/client.fxml"));
        	Scene catalogueScene = new Scene(catalogue.load());
        	
        	Stage stage = new Stage();
        	stage.setScene(catalogueScene);
        	stage.show();
        	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}

    }

    @FXML
    void searchFieldAction(ActionEvent event) {

    }

    @FXML
    void searchbuttonAction(ActionEvent event) {

    }

    @FXML
    void validerButtonAction(ActionEvent event) {
    	
    }

    @FXML
    void viderButtonAction(ActionEvent event) {
    	ObservableList<Produit> listeProduits,produit;
    	listeProduits=tablePanier.getItems();
    	produit=tablePanier.getSelectionModel().getSelectedItems();
    	produit.forEach(listeProduits::remove);
    	
    }
    
    
    Vendeur Jean = new Vendeur("monMDP", "jean@market.fr", "BOU","Jean", "06.50.20.20.20", "Cery", "Apple");
    ObservableList<Produit> listePanier = FXCollections.observableArrayList(
    		
    		new Produit(Jean, "prd1", false, "Le meilleur tel du monde", LocalDateTime.of(2022,05,12,0,0,0), 1200, 50,100),
    		new Produit(Jean, "prd2", false, "Le meilleur tel du monde", LocalDateTime.of(2022,05,12,0,0,0), 1200, 50,100),
    		new Produit(Jean, "prd3", false, "Le meilleur tel du monde", LocalDateTime.of(2022,05,12,0,0,0), 1200, 50,100),
    		new Produit(Jean, "prd4", false, "Le meilleur tel du monde", LocalDateTime.of(2022,05,12,0,0,0), 1200, 50,100),
    		new Produit(Jean, "prd5", false, "Le meilleur tel du monde", LocalDateTime.of(2022,05,12,0,0,0), 1200, 50,100)
    		
    		
    		
    		);  
   

	@FXML
	public void initialize() {
		ObservableList<Produit> listePanier1 = FXCollections.observableArrayList();
		for(Produit p : listePanier) {
			listePanier1.add(p);
			p.setStock(10);
		}
		nomPanier.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
		descriptionPanier.setCellValueFactory(new PropertyValueFactory<Produit, String>("description"));
		prixPanier.setCellValueFactory(new PropertyValueFactory<Produit, Double>("prix"));
		qttPanier.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("stock"));
		livraisonPanier.setCellValueFactory(new PropertyValueFactory<Produit, Temporal>("dateEstimeeLivraison"));
		vendeurPanier.setCellValueFactory(new PropertyValueFactory<Produit, String>("vendeur"));
		totalprix.setEditable(false);
		tablePanier.setItems(listePanier1);
		
//		int sum = 0;
//		for (int i = 0; i < tablePanier.getItems().size(); i++) {
//		    sum = sum + Integer.parseInt(tablePanier.getValueAt(i, 1).toString());
//		}
		
	}

}
