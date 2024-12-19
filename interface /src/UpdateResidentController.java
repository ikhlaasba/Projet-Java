import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UpdateResidentController {

    @FXML private TextField idResident;
    @FXML private TextField dossierMedical;
    @FXML private Button updateButton;
    @FXML private Button backToMenuButton;

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }

    @FXML
    private void handleUpdateResident() {
        try {
            if (idResident.getText().isEmpty() || dossierMedical.getText().isEmpty()) {
                showAlert("Input Error", "Please fill in all the fields.");
                return;
            }

            int id = Integer.parseInt(idResident.getText());
            String medicalFile = dossierMedical.getText();
            
            boolean success = DAL.updateResident(id, medicalFile);

            if (success) {
                showAlert("Success", "Resident updated successfully!");
            } else {
                showAlert("Failure", "Failed to update resident.");
            }
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Resident ID must be a valid number.");
        } catch (Exception e) {
            showAlert("Error", "An unexpected error occurred: " + e.getMessage());
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
