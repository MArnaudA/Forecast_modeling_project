package makery.marketplace.view;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ResourceBundle;

import MarketplaceJava.Marketplace;
import MarketplaceJava.Produit;
import MarketplaceJava.Vendeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import makery.marketplace.MainApp;

public class CatalogueController implements Initializable {

    @FXML
    private Button buyButton;

    @FXML
    private AnchorPane catalogueHome;

    @FXML
    private TableColumn<Produit, String> descriptionCatalogue;

    @FXML
    private Button homeButton;

    @FXML
    private TableColumn<Produit, Temporal> livraisonCatalogue;

    @FXML
    private TableColumn<Produit, String> nameCatalogue;

    @FXML
    private TableColumn<Produit, Double> prixCatalogue;

    @FXML
    private Button retourButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button showButton;

    @FXML
    private TableColumn<Produit, Integer> stockCatalogue;

    @FXML
    private TableView<Produit> tableCatalogue;

    @FXML
    private TextField textfieldSearch;

    @FXML
    private Label title;

    @FXML
    private VBox vBoxCatalogue;

    @FXML
    private TableColumn<Produit, String> vendeurCatalogue;

    @FXML
    void buyButtonAction(ActionEvent event) {

    }

    @FXML
    void homeButtonAction(ActionEvent event) {

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
    void searchButtonAction(ActionEvent event) {

    }

    @FXML
    void showAllButtonAction(ActionEvent event) {

    }

    @FXML
    void textfieldSearchAction(ActionEvent event) {

    }
    

    Vendeur Jean = new Vendeur("monMDP", "jean@market.fr", "BOU","Jean", "06.50.20.20.20", "Cery", "Apple");
    ObservableList<Produit> liste = FXCollections.observableArrayList(
    		
    		new Produit(Jean, "prd1", false, "Le meilleur tel du monde", LocalDateTime.of(2022,05,12,0,0,0), 1200, 50,100),
    		new Produit(Jean, "prd2", false, "Le meilleur tel du monde", LocalDateTime.of(2022,05,12,0,0,0), 1200, 50,100),
    		new Produit(Jean, "prd3", false, "Le meilleur tel du monde", LocalDateTime.of(2022,05,12,0,0,0), 1200, 50,100),
    		new Produit(Jean, "prd4", false, "Le meilleur tel du monde", LocalDateTime.of(2022,05,12,0,0,0), 1200, 50,100),
    		new Produit(Jean, "prd5", false, "Le meilleur tel du monde", LocalDateTime.of(2022,05,12,0,0,0), 1200, 50,100)
    		
    		
    		
    		);
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nameCatalogue.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
		descriptionCatalogue.setCellValueFactory(new PropertyValueFactory<Produit, String>("description"));
		prixCatalogue.setCellValueFactory(new PropertyValueFactory<Produit, Double>("prix"));
		stockCatalogue.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("stock"));
		livraisonCatalogue.setCellValueFactory(new PropertyValueFactory<Produit, Temporal>("dateEstimeeLivraison"));
		vendeurCatalogue.setCellValueFactory(new PropertyValueFactory<Produit, String>("vendeur"));
		
		tableCatalogue.setItems(liste);
		
	}

}
