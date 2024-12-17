import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class PersonnelController {

    // Utility method for showing alerts
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }


    // MENAGE Methods
    @FXML
    public void handleAddMenage() {
        try {
            // Load the AddResident FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddResident.fxml"));
            Stage stage = new Stage();
            stage.setScene(new javafx.scene.Scene(loader.load()));

            // Optionally set the title of the new window
            stage.setTitle("Add Resident");

            // Show the AddResident scene
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Failed to load Add Resident interface.");
            e.printStackTrace();
        }
    }

    @FXML
    public void handleDeleteMenage() {
        showAlert("Menage", "Delete Menage clicked");
    }

    @FXML
    public void handleUpdateMenage() {
        showAlert("Menage", "Update Menage clicked");
    }

    @FXML
    public void handleShowMenage() {
        showAlert("Menage", "Show Menage clicked");
    }

    // ADMINISTRATIF Methods
    @FXML
    public void handleAddAdministratif() {
        showAlert("Administratif", "Add Administratif clicked");
    }

    @FXML
    public void handleDeleteAdministratif() {
        showAlert("Administratif", "Delete Administratif clicked");
    }

    @FXML
    public void handleUpdateAdministratif() {
        showAlert("Administratif", "Update Administratif clicked");
    }

    @FXML
    public void handleShowAdministratif() {
        showAlert("Administratif", "Show Administratif clicked");
    }

    // SANTE Methods
    @FXML
    public void handleAddSante() {
        showAlert("Sante", "Add Sante clicked");
    }

    @FXML
    public void handleDeleteSante() {
        showAlert("Sante", "Delete Sante clicked");
    }

    @FXML
    public void handleUpdateSante() {
        showAlert("Sante", "Update Sante clicked");
    }

    @FXML
    public void handleShowSante() {
        showAlert("Sante", "Show Sante clicked");
    }
}
