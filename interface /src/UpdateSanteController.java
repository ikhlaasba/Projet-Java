import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateSanteController {

    @FXML private TextField id;
    @FXML private TextField salaire;
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
    private void updateSante() {
        try {
            if (id.getText().isEmpty() ||salaire.getText().isEmpty() ) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Please fill in all the fields.");
                return;
            }

            int idValue = Integer.parseInt(id.getText());
            double salaireValue = Double.parseDouble(salaire.getText());
           

            // Assuming updatePersonnelSante method exists in DAL
            boolean success = DAL.updatePersonnelSante(idValue, salaireValue);

            if (success) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Personnel Sante updated successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Failure", "Failed to update Personnel Sante.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "ID, Salaire, and Horaire de Travail must be valid numbers.");
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