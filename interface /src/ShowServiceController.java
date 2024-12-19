import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ShowServiceController {

    @FXML private TableView<Service> serviceTable;
    @FXML private TableColumn<Service, String> serviceColumn;
    @FXML private TableColumn<Service, Integer> dureeColumn;
    @FXML private Button backToMenuButton;

    @FXML
    private void initialize() {
        // Initialize the table columns
        serviceColumn.setCellValueFactory(new PropertyValueFactory<>("service"));
        dureeColumn.setCellValueFactory(new PropertyValueFactory<>("duree"));

        // Load the data from the database
        ObservableList<Service> serviceList = FXCollections.observableArrayList(DAL.selectAllServices());
        serviceTable.setItems(serviceList);
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