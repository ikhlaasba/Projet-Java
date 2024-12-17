import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller1 {

    @FXML
    private Button btn;

    @FXML
    private PasswordField pw;

    @FXML
    private TextField un;

    
    @FXML
    void onbtnclick(ActionEvent event) {
        // Get user input
        String name = un.getText();  // Use un for username
        String pwd = pw.getText();   // Use pw for password

    }
}
