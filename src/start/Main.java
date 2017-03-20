package start;

import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.constant.Const;
import model.entities.Building;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../fxml/main.fxml"));
        Parent fxmlMain = fxmlLoader.load();
        MainController mainController = fxmlLoader.getController();
        mainController.setMainStage(primaryStage);

        primaryStage.setTitle("Elevator");
        primaryStage.setMinHeight(510);
        primaryStage.setMinWidth(900);
        primaryStage.setMaxHeight(510);
        primaryStage.setMaxWidth(900);
        primaryStage.setScene(new Scene(fxmlMain, 900, 510));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }

}
