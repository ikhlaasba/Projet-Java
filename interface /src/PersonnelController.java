import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PersonnelController {

    @FXML private Button addMenageButton;
    @FXML private Button updateMenageButton;
    @FXML private Button deleteMenageButton;
    @FXML private Button showMenageButton;

    @FXML private Button addAdministratifButton;
    @FXML private Button updateAdministratifButton;
    @FXML private Button deleteAdministratifButton;
    @FXML private Button showAdministratifButton;

    @FXML private Button addSanteButton;
    @FXML private Button updateSanteButton;
    @FXML private Button deleteSanteButton;
    @FXML private Button showSanteButton;

    // Menage actions
    @FXML
    private void addMenage() {
        loadInterface("AddMenage.fxml", "Add Menage");
    }

    @FXML
    private void updateMenage() {
        loadInterface("UpdateMenage.fxml", "Update Menage");
    }

    @FXML
    private void deleteMenage() {
        loadInterface("DeleteMenage.fxml", "Delete Menage");
    }

    @FXML
    private void showMenage() {
        loadInterface("ShowMenage.fxml", "Show Menage");
    }

    // Administratif actions
    @FXML
    private void addAdministratif() {
        loadInterface("AddAdministratif.fxml", "Add Administratif");
    }

    @FXML
    private void updateAdministratif() {
        loadInterface("UpdateAdministratif.fxml", "Update Administratif");
    }

    @FXML
    private void deleteAdministratif() {
        loadInterface("DeleteAdministratif.fxml", "Delete Administratif");
    }

    @FXML
    private void showAdministratif() {
        loadInterface("ShowAdministratif.fxml", "Show Administratif");
    }

    // Sante actions
    @FXML
    private void addSante() {
        loadInterface("AddSante.fxml", "Add Sante");
    }

    @FXML
    private void updateSante() {
        loadInterface("UpdateSante.fxml", "Update Sante");
    }

    @FXML
    private void deleteSante() {
        loadInterface("DeleteSante.fxml", "Delete Sante");
    }

    @FXML
    private void showSante() {
        loadInterface("ShowSante.fxml", "Show Sante");
    }

    // Utility method to load a new interface
    private void loadInterface(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Stage stage = new Stage();
            stage.setScene(new javafx.scene.Scene(loader.load()));

            // Optionally set the title of the new window
            stage.setTitle(title);

            // Show the new scene
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Failed to load " + title + " interface.");
            e.printStackTrace();
        }
    }

    // Utility method for showing alerts
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }
}