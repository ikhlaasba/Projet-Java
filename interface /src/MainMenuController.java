import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML private Label welcomeLabel; // This will link to the Label in FXML
    @FXML private Button personnelButton;
    @FXML private Button serviceButton;
    @FXML private Button roomsButton;
    @FXML private Button ResidentButton;

    // set the welcome message with the username
    public void setWelcomeMessage(String username) {
        welcomeLabel.setText("Welcome, " + username);
    }

    // Go to the Personnel scene
    public void goToPersonnel() {
        try {
            Stage stage = (Stage) personnelButton.getScene().getWindow();
            App.setRoot(stage, "Personnel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Go to the Service scene
    public void goToService() {
        try {
            Stage stage = (Stage) serviceButton.getScene().getWindow();
            App.setRoot(stage, "Service");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Go to the Rooms scene
    public void goToRooms() {
        try {
            Stage stage = (Stage) roomsButton.getScene().getWindow();
            App.setRoot(stage, "Chambre");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Go to the Other scene
    public void goToResident() {
        try {
            Stage stage = (Stage) ResidentButton.getScene().getWindow();
            App.setRoot(stage, "Resident");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
