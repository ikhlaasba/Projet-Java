import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteServiceController {

    @FXML private TextField service;
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
    private void deleteService() {
        try {
            if (service.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Please fill in the Service field.");
                return;
            }

            String serviceName = service.getText();

            boolean success = DAL.removeService(serviceName);

            if (success) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Service deleted successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Failure", "Failed to delete service.");
            }
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