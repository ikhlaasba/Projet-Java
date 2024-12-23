import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddServiceController {

    @FXML private ChoiceBox<String> serviceChoiceBox;
    @FXML private TextField duree;
    @FXML private Button submitButton;
    @FXML private Button backToMenuButton;

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    public void initialize() {
        ObservableList<String> SERVICES = FXCollections.observableArrayList(
                "Alimentation", "Massage", "Animation", "Restauration"
        );
        serviceChoiceBox.setItems(SERVICES);
        serviceChoiceBox.setValue("Alimentation"); // Set default value (optional)
    }

    @FXML
    private void addService() {
        try {
            if (serviceChoiceBox.getValue() == null || duree.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Please select a service and fill in the duration.");
                return;
            }

            String serviceName = serviceChoiceBox.getValue();
            int duration = Integer.parseInt(duree.getText());

            // Simulating database call
            boolean success = DAL.addService(serviceName, duration);

            if (success) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Service added successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Failure", "Failed to add service.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Duration must be a valid number.");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "An unexpected error occurred: " + e.getMessage());
        }
    }

    @FXML
    private void goToMainMenu() {
        try {
            Stage stage = (Stage) backToMenuButton.getScene().getWindow();
            App.setRoot(stage, "MainMenu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
