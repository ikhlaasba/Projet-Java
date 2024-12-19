import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ShowAdministratifController {

    @FXML private TableView<Administratif> administratifTable;
    @FXML private TableColumn<Administratif, Integer> idColumn;
    @FXML private TableColumn<Administratif, String> nomColumn;
    @FXML private TableColumn<Administratif, String> prenomColumn;
    @FXML private TableColumn<Administratif, Double> salaireColumn;
    @FXML private TableColumn<Administratif, Integer> horaireDeTravailColumn;
    @FXML private TableColumn<Administratif, String> responsabiliteColumn;
    @FXML private TableColumn<Administratif, Integer> numeroBureauColumn;
    @FXML private Button backToMenuButton;

    @FXML
    private void initialize() {
        // Initialize the table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        salaireColumn.setCellValueFactory(new PropertyValueFactory<>("salaire"));
        horaireDeTravailColumn.setCellValueFactory(new PropertyValueFactory<>("horaireDeTravail"));
        responsabiliteColumn.setCellValueFactory(new PropertyValueFactory<>("responsabilite"));
        numeroBureauColumn.setCellValueFactory(new PropertyValueFactory<>("numeroBureau"));

        // Load the data from the database
        ObservableList<Administratif> administratifList = FXCollections.observableArrayList(DAL.selectAllPersonnelAdministratif());
        administratifTable.setItems(administratifList);
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