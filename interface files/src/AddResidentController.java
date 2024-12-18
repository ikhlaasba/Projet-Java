import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AddResidentController {

    @FXML private TextField idResident;
    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private DatePicker dateNaissance;
    @FXML private TextField dossierMedical;
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
    private void handleAddResident() {
        try {
            if (idResident.getText().isEmpty() || nom.getText().isEmpty() || prenom.getText().isEmpty() || 
                dateNaissance.getValue() == null || dossierMedical.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Please fill in all the fields.");
                return;
            }

            int id = Integer.parseInt(idResident.getText());
            String name = nom.getText();
            String firstName = prenom.getText();
            LocalDate dateOfBirth = dateNaissance.getValue();
            String medicalFile = dossierMedical.getText();

            boolean success = DAL.addResident(id, name, firstName, dateOfBirth, medicalFile);

            if (success) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Resident added successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Failure", "Failed to add resident.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Resident ID must be a valid number.");
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
