package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by vs on 16.03.2017.
 */
public class Cabin1Controller {

    @FXML
    private Button elevator1_1;
    @FXML
    private Button elevator1_2;
    @FXML
    private Button elevator1_3;
    @FXML
    private Button elevator1_4;
    @FXML
    private Button elevator1_5;
    @FXML
    private Button elevator1_6;
    @FXML
    private Button elevator1_7;
    @FXML
    private Button elevator1_8;
    @FXML
    private Button elevator1_9;
    @FXML
    private Button elevator1_10;
    @FXML
    private Button btnGo1;

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.hide();
    }
}
