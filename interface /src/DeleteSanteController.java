import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteSanteController {

    @FXML private TextField id;
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
    private void deleteSante() {
        try {
            if (id.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Please fill in the ID field.");
                return;
            }

            int idValue = Integer.parseInt(id.getText());

            boolean success = DAL.removePersonnelSante(idValue);

            if (success) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Personnel Sante deleted successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Failure", "Failed to delete Personnel Sante.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "ID must be a valid number.");
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