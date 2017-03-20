package start;

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

//    public void test(){
//
//        for (int i = 0; i < 5; i++) {
//            Building.getInstance().createPassenger();
//        }
//
//    }
//
//    public static void test2(){
//        Building.getInstance().elevatorStart(Building.getInstance().getElevatorById(Const.FREIGHT_ELEVATOR_ID));
//    }

}
