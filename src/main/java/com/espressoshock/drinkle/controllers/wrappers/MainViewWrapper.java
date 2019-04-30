package com.espressoshock.drinkle.controllers.wrappers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewWrapper {

    @FXML
    private AnchorPane loadingPane;

    @FXML
    private void exitProgramAction() {
        System.exit(0);
    }
    @FXML
    public void minimizeProgramAction(Event minimizeProgramEvent) {
        Stage stage = (Stage)((ImageView)minimizeProgramEvent.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void initialize() throws IOException {
        //fields loaded here -> check if logged/remembered is checked etc...
        boolean auth = false;
        if(auth){
            //logged show main ui
        } else{
            //not logged - load auth-default
            Pane authLogin = FXMLLoader.load(getClass().getResource("/fxml/auth/auth-login.fxml"));
            this.loadingPane.getChildren().add(authLogin);

        }
    }

}
