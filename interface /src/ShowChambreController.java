import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ShowChambreController {

    @FXML private TableView<Chambre> chambreTable;
    @FXML private TableColumn<Chambre, Integer> numeroColumn;
    @FXML private TableColumn<Chambre, String> typeColumn;
    @FXML private TableColumn<Chambre, String> statutColumn;
    @FXML private Button backToMenuButton;

    @FXML
    private void initialize() {
        // Initialize the table columns
        numeroColumn.setCellValueFactory(new PropertyValueFactory<>("numero"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        statutColumn.setCellValueFactory(new PropertyValueFactory<>("statut"));

        // Load the data from the database
        ObservableList<Chambre> chambreList = FXCollections.observableArrayList(DAL.selectAllChambres());
        chambreTable.setItems(chambreList);
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