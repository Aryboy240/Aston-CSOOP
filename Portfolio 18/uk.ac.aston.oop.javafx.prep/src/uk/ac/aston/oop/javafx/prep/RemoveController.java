package uk.ac.aston.oop.javafx.prep;

import uk.ac.aston.oop.javafx.prep.model.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RemoveController {
	
	@FXML
	private Label lblItem;
	private Item selectedItem;
	private boolean confirmed = false;
	
	public RemoveController(Item selectedItem) {
		this.selectedItem = selectedItem;
	}
	
	public boolean isConfirmed() {
		return this.confirmed;
	}

	@FXML
	public void initialize() {
		lblItem.setText(selectedItem.toString());
	}
	
	@FXML
    public void cancelPressed() {
        confirmed = false;
        lblItem.getScene().getWindow().hide();
    }
	
	@FXML
	public void confirmPressed() {
        confirmed = true;
        lblItem.getScene().getWindow().hide();
    }
}
