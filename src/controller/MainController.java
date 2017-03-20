package controller;

import interfaces.impls.ElevatorsImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.constant.Const;
import start.Main;

import java.io.IOException;

public class MainController {

    private ElevatorsImpl elevators = new ElevatorsImpl();

    @FXML
    private Label currentPos1;
    @FXML
    private Label status1;
    @FXML
    private ChoiceBox<Integer> startPosSet1;
    @FXML
    private Button callElevator1;

    @FXML
    private Label currentPos2;
    @FXML
    private Label status2;
    @FXML
    private ChoiceBox<Integer> startPosSet2;
    @FXML
    private Button callElevator2;

    @FXML
    private Label currentPos3;
    @FXML
    private Label status3;
    @FXML
    private ChoiceBox<Integer> startPosSet3;
    @FXML
    private Button callElevator3;

    @FXML
    private void initialize(){

        updateCurrentPos(Const.FREIGHT_ELEVATOR_ID);
        updateCurrentPos(Const.FIRST_PASSENGER_ELEVATOR_ID);
        updateCurrentPos(Const.SECOND_PASSENGER_ELEVATOR_ID);

        elevators.getBuilding().getElevatorById(Const.FREIGHT_ELEVATOR_ID).getObservatedCurrentPos().
                addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        updateCurrentPos(Const.FREIGHT_ELEVATOR_ID);
                        updateCurrentPos(Const.FIRST_PASSENGER_ELEVATOR_ID);
                        updateCurrentPos(Const.SECOND_PASSENGER_ELEVATOR_ID);
                    }
                });


        startPosSet1.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6 , 7, 8, 9, 10));
        startPosSet1.setValue(1);
        startPosSet2.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6 , 7, 8, 9, 10));
        startPosSet2.setValue(1);
        startPosSet3.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6 , 7, 8, 9, 10));
        startPosSet3.setValue(1);
    }

    private void updateCurrentPos(int elevatorId){
        currentPos1.setText("Current position " + elevators.showCurrentPosition(elevatorId));
    }

    public void callElevator(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if(!(source instanceof Button)){
            return;
        }

        Button clickedButton = (Button)source;

        int selectedFloor = startPosSet1.getValue();

        System.out.println("start floor " + selectedFloor);

        Elevator1Cabin(actionEvent);
    }

    public void elevatorCabinSetting(ActionEvent actionEvent, Stage stage, String fxmlLoader) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlLoader));
        stage.setTitle("Elevator cabin");
        stage.setMinHeight(270);
        stage.setMinWidth(320);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    public void Elevator1Cabin(ActionEvent actionEvent){

        try{
            Stage stage = new Stage();
            elevatorCabinSetting(actionEvent, stage, "../fxml/cabin1.fxml");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void Elevator2Cabin(ActionEvent actionEvent){

        try{
            Stage stage = new Stage();
            elevatorCabinSetting(actionEvent, stage, "../fxml/cabin2.fxml");

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void Elevator3Cabin(ActionEvent actionEvent){

        try{
            Stage stage = new Stage();
            elevatorCabinSetting(actionEvent, stage, "../fxml/cabin3.fxml");

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
