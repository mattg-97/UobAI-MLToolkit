
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {//parent class, abstract methods



    public static void main(String[] args) {
        launch(args);
    } //life cycle

    @Override
    public void start(Stage stage) throws Exception { //create UI
        stage.setTitle("Hello, world!");
        //stage.setHeight(500);
        //stage.setWidth(300);
        StackPane root = new StackPane(); //simple, non resizeable layout
        Scene scene = new Scene(root, 300, 400); //layout
        scene.setFill(Color.MAROON);
        //Image icon = new Image("D2BHG8ZU0AAZuPC.jpg");
        //stage.getIcons().add(icon);
        Button btn = new Button("Click me"); //leaf node off root
        btn.setPrefSize(69, 69);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hello, world!");
            }
        });
        root.getChildren().add(btn);//add widget to scene, via root
        stage.setScene(scene);
        stage.show();
    }
}