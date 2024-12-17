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
    @FXML private Button addButton;

    // Utility method for showing alerts
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }

    // Handle the addition of a resident
    @FXML
    private void handleAddResident() {
        try {
            // Check if any required field is empty
            if (idResident.getText().isEmpty() || nom.getText().isEmpty() || prenom.getText().isEmpty() || 
                dateNaissance.getValue() == null || dossierMedical.getText().isEmpty()) {
                showAlert("Input Error", "Please fill in all the fields.");
                return;
            }

            // Parsing the input values
            int id = Integer.parseInt(idResident.getText());
            String name = nom.getText();
            String firstName = prenom.getText();
            LocalDate dateOfBirth = dateNaissance.getValue();
            String medicalFile = dossierMedical.getText();

            // Attempt to add the resident
            boolean success = DAL.addResident(id, name, firstName, dateOfBirth, medicalFile);

            if (success) {
                showAlert("Success", "Resident added successfully!");
            } else {
                showAlert("Failure", "Failed to add resident.");
            }
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Resident ID must be a valid number.");
        } catch (Exception e) {
            showAlert("Error", "An unexpected error occurred: " + e.getMessage());
        }
    }

    // Go back to the main menu (or any other scene)
    public void goToMainMenu() {
        try {
            Stage stage = (Stage) addButton.getScene().getWindow();
            App.setRoot(stage, "MainMenu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
