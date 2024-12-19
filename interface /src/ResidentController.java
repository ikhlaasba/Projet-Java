import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ResidentController {

    @FXML private Button addButton;
    @FXML private Button updateButton;
    @FXML private Button deleteButton;
    @FXML private Button showButton;

    // Handle the "Add" button to load the AddResident scene
    public void handleAdd() {
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

    // Handle the "Update" button to load the UpdateResident scene
    public void handleUpdate() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateResident.fxml"));
            Stage stage = new Stage();
            stage.setScene(new javafx.scene.Scene(loader.load()));

            stage.setTitle("Update Resident");

            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Failed to load Update Resident interface.");
            e.printStackTrace();
        }
    }

    // Handle the "Delete" button to load the DeleteResident scene
    public void handleDelete() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteResident.fxml"));
            Stage stage = new Stage();
            stage.setScene(new javafx.scene.Scene(loader.load()));

            stage.setTitle("Delete Resident");

            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Failed to load Delete Resident interface.");
            e.printStackTrace();
        }
    }

    // Handle the "Show" button to load the ShowAllResidents scene
    public void handleShow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowAllResidents.fxml"));
            Stage stage = new Stage();
            stage.setScene(new javafx.scene.Scene(loader.load()));

            stage.setTitle("Show All Residents");

            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Failed to load Show All Residents interface.");
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
