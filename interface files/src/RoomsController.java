import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class RoomsController {

    @FXML private Button addButton;
    @FXML private Button updateButton;
    @FXML private Button deleteButton;
    @FXML private Button showButton;

    public void handleAdd() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Add Room clicked");
        alert.show();
    }

    public void handleUpdate() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Update Room clicked");
        alert.show();
    }

    public void handleDelete() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Delete Room clicked");
        alert.show();
    }

    public void handleShow() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Show Room clicked");
        alert.show();
    }
}
