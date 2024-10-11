package uk.ac.aston.oop.javafx.assessed;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uk.ac.aston.oop.javafx.assessed.model.CD;
import uk.ac.aston.oop.javafx.assessed.model.Database;
import uk.ac.aston.oop.javafx.assessed.model.Item;

public class CreateCDController{
	
	private Database database;

	public void setDatabase(Database database) {
	    this.database = database;
	}

	public void createCD(String title, String artist, int numberOfTracks, int playingTime, boolean own) {
		if (database != null) {
			CD addCD = new CD(title, artist, numberOfTracks, playingTime);
	        addCD.setOwn(own);
	        database.addItem(addCD);
		}
	}


	private Item newCD;
	
	@FXML private Label lblItem;
	
    @FXML
    private TextField titleField;

    @FXML
    private TextField artistField;

    @FXML
    private CheckBox ownCheckBox;

    @FXML
    private Slider playingTimeSlider;

    @FXML
    private Slider tracksSlider;

    @FXML
    private Label playingTimeLabel;

    @FXML
    private Label tracksLabel;

    @FXML
    private Button createButton;

    @FXML
    private Button cancelButton;

    @FXML
    public void initialize() {
        playingTimeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int playingTime = newValue.intValue();
            String labelText = "Playing time: " + playingTime;
            playingTimeLabel.setText(labelText);
        });

        tracksSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int numberOfTracks = newValue.intValue();
            String labelText = "Number of tracks: " + numberOfTracks;
            tracksLabel.setText(labelText);
        });
    }


    @FXML
    public void createPressed() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        String title = titleField.getText();
        String artist = artistField.getText();
        boolean own = ownCheckBox.isSelected();
        int playingTime = (int) playingTimeSlider.getValue();
        int numberOfTracks = (int) tracksSlider.getValue();

        createCD(title, artist, numberOfTracks, playingTime, own);

        stage.close();
    }


    @FXML
    public void cancelPressed() {
    	Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
    public Item getCD() {
    	return newCD;
    }
}
