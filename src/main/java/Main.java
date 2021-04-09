import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;


public class Main extends Application {//parent class, abstract methods



    public static void main(String[] args) {
        launch(args);
    } //life cycle

    @Override
    public void start(Stage stage) throws Exception { //create UI
        URL url = new File("src/main/java/Toolkit.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}