import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ShowAllResidentsController {

    @FXML private TableView<Resident> residentsTable;

    @FXML private TableColumn<Resident, Integer> idColumn;
    @FXML private TableColumn<Resident, String> nameColumn;
    @FXML private TableColumn<Resident, String> firstNameColumn;
    @FXML private TableColumn<Resident, String> medicalFileColumn;
    @FXML private TableColumn<Resident, String> dateOfBirthColumn;

    @FXML
    private void initialize() {
        // Initialize the table columns
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        medicalFileColumn.setCellValueFactory(cellData -> cellData.getValue().medicalFileProperty());
        dateOfBirthColumn.setCellValueFactory(cellData -> cellData.getValue().dateOfBirthProperty());

        // Load all residents from the database and display them in the table
        residentsTable.setItems(DAL.selectAllResidents());
    }

    public void goToMainMenu() {
        try {
            Stage stage = (Stage) residentsTable.getScene().getWindow();
            App.setRoot(stage, "MainMenu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
