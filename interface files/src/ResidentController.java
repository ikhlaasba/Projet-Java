import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ResidentController {

    @FXML private Button addButton;
    @FXML private Button updateButton;
    @FXML private Button deleteButton;
    @FXML private Button showButton;

    public void handleAdd() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Add Other clicked");
        alert.show();
    }

    public void handleUpdate() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Update Other clicked");
        alert.show();
    }

    public void handleDelete() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Delete Other clicked");
        alert.show();
    }

    public void handleShow() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Show Other clicked");
        alert.show();
    }
}
