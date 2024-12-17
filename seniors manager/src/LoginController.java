import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    // Handle login button click
    public void handleLogin() {
        // Get the input values
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        // Check if the username and password are not empty
        if (!username.isEmpty() && !password.isEmpty()) {
            try {
                // Load the MainMenu.fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
                Parent root = loader.load();

                // Get the controller for MainMenu.fxml
                MainMenuController mainMenuController = loader.getController();
                mainMenuController.setWelcomeMessage(username); // Pass the username to MainMenuController

                // Create a new stage (window) and set the scene
                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Show error message if either the username or password is empty
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username and password cannot be empty.");
            alert.show();
        }
    }
}
