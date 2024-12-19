import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddMenageController {

    @FXML private TextField id;
    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private TextField salaire;
    @FXML private TextField horaireDeTravail;
    @FXML private TextField tache;
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
    private void addMenage() {
        try {
            if (id.getText().isEmpty() || nom.getText().isEmpty() || prenom.getText().isEmpty() || 
                salaire.getText().isEmpty() || horaireDeTravail.getText().isEmpty() || tache.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Please fill in all the fields.");
                return;
            }

            int idValue = Integer.parseInt(id.getText());
            String nomValue = nom.getText();
            String prenomValue = prenom.getText();
            double salaireValue = Double.parseDouble(salaire.getText());
            int horaireDeTravailValue = Integer.parseInt(horaireDeTravail.getText());
            String tacheValue = tache.getText();

            boolean success = DAL.addPersonnelMenage(idValue, nomValue, prenomValue, salaireValue, horaireDeTravailValue, tacheValue);

            if (success) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Personnel Menage added successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Failure", "Failed to add Personnel Menage.");
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