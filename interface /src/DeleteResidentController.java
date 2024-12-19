import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class DeleteResidentController {

    @FXML private TextField idResident;
    @FXML private Button deleteButton;

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }

    @FXML
    private void handleDeleteResident() {
        try {
            if (idResident.getText().isEmpty()) {
                showAlert("Input Error", "Please enter the Resident ID.");
                return;
            }

            int id = Integer.parseInt(idResident.getText());

            boolean success = DAL.removeResident(id);

            if (success) {
                showAlert("Success", "Resident deleted successfully!");
            } else {
                showAlert("Failure", "Failed to delete resident.");
            }
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Resident ID must be a valid number.");
        } catch (Exception e) {
            showAlert("Error", "An unexpected error occurred: " + e.getMessage());
        }
    }

    public void goToMainMenu() {
        try {
            Stage stage = (Stage) deleteButton.getScene().getWindow();
            App.setRoot(stage, "MainMenu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
