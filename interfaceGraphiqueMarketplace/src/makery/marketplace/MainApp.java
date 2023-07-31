package makery.marketplace;

import java.io.IOException;

import makery.marketplace.model.User;
import makery.marketplace.view.PageInscriptionClientController;
import makery.marketplace.view.PageInscriptionLivreurController;
import makery.marketplace.view.PageInscriptionMarketplaceController;
import makery.marketplace.view.PageInscriptionVendeurController;
import makery.marketplace.view.PageConnexionController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainApp extends Application {
	private Stage primaryStage = new Stage();
    private BorderPane rootLayout;
    
    private ObservableList<User> userData = FXCollections.observableArrayList();
    
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MarketplaceApp");
        
        initRootLayout();
        
        showConnexion();
	}
	
	public MainApp() {
		
	}
	
	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	 public void showConnexion() {
	        try {
	            // Load person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/PageConnexion.fxml"));
	            AnchorPane pageConnexion = (AnchorPane) loader.load();
	            
	            // Set person overview into the center of root layout.
	            rootLayout.setCenter(pageConnexion);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	    }
	 
	 public ObservableList<User> getUserData(){
		 return userData;
	 }
	 
	 public Stage getPrimaryStage() {
			return primaryStage;
		}
	 
	 public boolean showNewClientDialog(User user) {
	        try {
	            // Load the fxml file and create a new stage for the popup dialog.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/PageInscriptionClient.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Créer un nouveau compte Client");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);

	            // Set the person into the controller.
	            PageInscriptionClientController controller = loader.getController();
	            controller.setDialogStage(dialogStage);
	            controller.setUser(user);

	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait();

	            return controller.isOkClicked();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false ;
	        }
	 }
	 public boolean showNewMarketplaceDialog(User user) {
	        try {
	            // Load the fxml file and create a new stage for the popup dialog.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/PageInscriptionMarketplace.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Créer un nouveau compte Marketplace");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);

	            // Set the person into the controller.
	            PageInscriptionMarketplaceController controller = loader.getController();
	            controller.setDialogStage(dialogStage);
	            controller.setUser(user);

	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait();

	            return controller.isOkClicked();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	 }
	 
	 public boolean showNewLivreurDialog(User user) {
	        try {
	            // Load the fxml file and create a new stage for the popup dialog.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/PageInscriptionLivreur.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Créer un nouveau compte livreur");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);

	            // Set the person into the controller.
	            PageInscriptionLivreurController controller = loader.getController();
	            controller.setDialogStage(dialogStage);
	            controller.setUser(user);

	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait();

	            return controller.isOkClicked();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	 }
	 
	 public boolean showNewVendeurDialog(User user) {
	        try {
	            // Load the fxml file and create a new stage for the popup dialog.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/PageInscriptionVendeur.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Créer un nouveau compte Vendeur");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);

	            // Set the person into the controller.
	            PageInscriptionVendeurController controller = loader.getController();
	            controller.setDialogStage(dialogStage);
	            controller.setUser(user);

	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait();

	            return controller.isOkClicked();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	 }
	        
	      
	    
	 
	public static void main(String[] args) {
		launch(args);
	}

}
