import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateChambreController {

    @FXML private TextField numero;
    @FXML private TextField statut;
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
    private void updateChambre() {
        try {
            if (numero.getText().isEmpty() || statut.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Please fill in all fields.");
                return;
            }

            int roomNumber = Integer.parseInt(numero.getText());
            String newStatus = statut.getText();

            boolean success = DAL.updateChambre(roomNumber, newStatus);

            if (success) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Chambre updated successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Failure", "Failed to update chambre.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Room Number must be a valid number.");
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