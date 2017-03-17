package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));
        primaryStage.setTitle("Elevator");
        primaryStage.setMinHeight(510);
        primaryStage.setMinWidth(900);
        primaryStage.setMaxHeight(510);
        primaryStage.setMaxWidth(900);
        primaryStage.setScene(new Scene(root, 900, 510));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
