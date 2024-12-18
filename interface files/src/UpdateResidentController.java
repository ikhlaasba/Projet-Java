import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UpdateResidentController {

    @FXML private TextField idResident;
    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private DatePicker dateNaissance;
    @FXML private TextField dossierMedical;
    @FXML private Button updateButton;

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
            if (idResident.getText().isEmpty() || nom.getText().isEmpty() || prenom.getText().isEmpty() || 
                dateNaissance.getValue() == null || dossierMedical.getText().isEmpty()) {
                showAlert("Input Error", "Please fill in all the fields.");
                return;
            }

            int id = Integer.parseInt(idResident.getText());
            String name = nom.getText();
            String firstName = prenom.getText();
            String medicalFile = dossierMedical.getText();
            LocalDate dateOfBirth = dateNaissance.getValue();

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

    public void goToMainMenu() {
        try {
            Stage stage = (Stage) updateButton.getScene().getWindow();
            App.setRoot(stage, "MainMenu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
