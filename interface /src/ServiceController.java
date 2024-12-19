import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ServiceController {

    @FXML private Button addServiceButton;
    @FXML private Button updateServiceButton;
    @FXML private Button deleteServiceButton;
    @FXML private Button showServiceButton;

    // Service actions
    @FXML
    private void addService() {
        loadInterface("AddService.fxml", "Add Service");
    }

    @FXML
    private void updateService() {
        loadInterface("UpdateService.fxml", "Update Service");
    }

    @FXML
    private void deleteService() {
        loadInterface("DeleteService.fxml", "Delete Service");
    }

    @FXML
    private void showService() {
        loadInterface("ShowService.fxml", "Show Services");
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