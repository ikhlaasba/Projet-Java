import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ShowMenageController {

    @FXML private TableView<Menage> menageTable;
    @FXML private TableColumn<Menage, Integer> idColumn;
    @FXML private TableColumn<Menage, String> nomColumn;
    @FXML private TableColumn<Menage, String> prenomColumn;
    @FXML private TableColumn<Menage, Double> salaireColumn;
    @FXML private TableColumn<Menage, Integer> horaireDeTravailColumn;
    @FXML private TableColumn<Menage, String> tacheColumn;
    @FXML private Button backToMenuButton;

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        salaireColumn.setCellValueFactory(new PropertyValueFactory<>("salaire"));
        horaireDeTravailColumn.setCellValueFactory(new PropertyValueFactory<>("horaireDeTravail"));
        tacheColumn.setCellValueFactory(new PropertyValueFactory<>("tache"));

        ObservableList<Menage> menageList = FXCollections.observableArrayList(DAL.selectAllPersonnelMenage());
        menageTable.setItems(menageList);
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