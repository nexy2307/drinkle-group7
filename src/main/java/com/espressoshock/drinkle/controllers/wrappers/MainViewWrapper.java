package com.espressoshock.drinkle.controllers.wrappers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainViewWrapper {

    @FXML
    private AnchorPane loadingPane;

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
