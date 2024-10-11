package uk.ac.aston.oop.javafx.prep;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import uk.ac.aston.oop.javafx.prep.model.Database;
import uk.ac.aston.oop.javafx.prep.model.Item;

public class ListController {

    private final Database model;

    @FXML
    private ListView <Item> listItems;

    public ListController(Database model) {
        this.model = model;
    }

    @FXML
    public void initialize() {
        // Initialize the ListView with data from the model
        listItems.setItems(model.itemsProperty());
    }

    @FXML
    public void shufflePressed() {
    	FXCollections.shuffle(model.itemsProperty());
    }

    @FXML
    public void removePressed() {
    	
    	// 1: get the selected index
    	int selIndex = listItems.getSelectionModel().getSelectedIndex();
    	
    	// 2: index shows an item was selected
        if (selIndex >= 0) {
        	
        	// 3: get the selected item
        	Item selectedItem = model.itemsProperty().get(selIndex);

            try {
            	
                // 4: create the FXMLLoader and store it in local variable "loader"
            	FXMLLoader loader = new FXMLLoader();
            	
                // 5: set the location of the FXML file in the loader
            	URL fxmlLocation = getClass().getResource("RemoveItem.fxml");
            	loader.setLocation(fxmlLocation);
            	
                // 6: create the RemoveController while passing the selected item
            	RemoveController removeController = new RemoveController(selectedItem);
            	
                // 7: set the controller in the loader
            	loader.setController(removeController);
            	
                // 8: load the FXML file and store the root object in a variable
            	VBox root = loader.load();
            	
                // 9: create a "new Stage()" and store it in local variable "stage"
            	Stage stage = new Stage();
            	
                // 10: set the modality of the Stage
            	stage.initModality(Modality.APPLICATION_MODAL);
            	
                // 11: create a new Scene with root object (250px x 200px)
            	Scene scene = new Scene(root, 250, 200);
            	
                // 12: set the Scene of the Stage
            	stage.setScene(scene);
            	
                // 13: show the Stage and wait for it to be closed
            	stage.showAndWait();
            	
            	// 14: Remove controller says Confirm was pressed
                if (removeController.isConfirmed()) {
                	
                	// 15: remove the selected index from the items of the Database
                	model.itemsProperty().remove(selectedItem);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    public void quitPressed() {
    	Scene scene = listItems.getScene();
    	Window window = scene.getWindow();
    	window.hide();
    }
}
