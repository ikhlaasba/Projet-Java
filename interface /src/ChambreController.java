import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChambreController {

    @FXML private Button addChambreButton;
    @FXML private Button updateChambreButton;
    @FXML private Button deleteChambreButton;
    @FXML private Button showChambreButton;

    // Chambre actions
    @FXML
    private void addChambre() {
        loadInterface("AddChambre.fxml", "Add Chambre");
    }

    @FXML
    private void updateChambre() {
        loadInterface("UpdateChambre.fxml", "Update Chambre");
    }

    @FXML
    private void deleteChambre() {
        loadInterface("DeleteChambre.fxml", "Delete Chambre");
    }

    @FXML
    private void showChambre() {
        loadInterface("ShowChambre.fxml", "Show Chambres");
    }

    // Utility method to load a new interface
    private void loadInterface(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Stage stage = new Stage();
            stage.setScene(new javafx.scene.Scene(loader.load()));

            // Optionally set the title of the new window
            stage.setTitle(title);

            // Show the new scene
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Failed to load " + title + " interface.");
            e.printStackTrace();
        }
    }

    // Utility method for showing alerts
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }
}