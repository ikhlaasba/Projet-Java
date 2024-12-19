import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ShowSanteController {

    @FXML private TableView<Sante> santeTable;
    @FXML private TableColumn<Sante, Integer> idColumn;
    @FXML private TableColumn<Sante, String> nomColumn;
    @FXML private TableColumn<Sante, String> prenomColumn;
    @FXML private TableColumn<Sante, Double> salaireColumn;
    @FXML private TableColumn<Sante, Integer> horaireDeTravailColumn;
    @FXML private TableColumn<Sante, String> specialiteColumn;
    @FXML private Button backToMenuButton;

    @FXML
    private void initialize() {
        // Initialize the table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        salaireColumn.setCellValueFactory(new PropertyValueFactory<>("salaire"));
        horaireDeTravailColumn.setCellValueFactory(new PropertyValueFactory<>("horaireDeTravail"));
        specialiteColumn.setCellValueFactory(new PropertyValueFactory<>("specialite"));

        // Load the data from the database
        ObservableList<Sante> santeList = FXCollections.observableArrayList(DAL.selectAllPersonnelSante());
        santeTable.setItems(santeList);
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