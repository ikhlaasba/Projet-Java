import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ShowAllResidentsController {

    @FXML private TableView<Resident> residentTable;
    @FXML private TableColumn<Resident, Integer> idColumn;
    @FXML private TableColumn<Resident, String> nomColumn;
    @FXML private TableColumn<Resident, String> prenomColumn;
    @FXML private TableColumn<Resident, String> dossierMedicalColumn;
    @FXML private TableColumn<Resident, String> dateNaissanceColumn;
    @FXML private Button backToMenuButton;

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_resident"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        dossierMedicalColumn.setCellValueFactory(new PropertyValueFactory<>("dossierMedical"));
        dateNaissanceColumn.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));

        ObservableList<Resident> residentList = FXCollections.observableArrayList(DAL.selectAllResidents());
        residentTable.setItems(residentList);
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
