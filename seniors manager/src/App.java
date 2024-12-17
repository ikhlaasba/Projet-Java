import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Set the initial scene (Login) when the app starts
        setRoot(stage, "Login");
    }

    public static void setRoot(Stage stage, String fxml) throws Exception {
        // Load the FXML file for the scene
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Scene scene = new Scene(loader.load());
        
        // Set the scene to the stage
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
