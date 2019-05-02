package com.espressoshock.drinkle.controllers.wrappers;

import static com.espressoshock.drinkle.appState.UserState.loggedIn;
import static com.espressoshock.drinkle.appState.UserState.loggedOut;

import com.espressoshock.drinkle.appState.Current;
import javafx.event.Event;
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
        if (Current.environment.userStatus.equals(loggedIn)) {
            //logged show main ui
        } else if (Current.environment.userStatus.equals(loggedOut)) {
            //not logged - load auth-default
            Pane authLogin = FXMLLoader.load(getClass().getResource("/fxml/auth/auth-login.fxml"));
            this.loadingPane.getChildren().add(authLogin);
        }
    }

    @FXML
    public void closeWindow(Event e){
        System.exit(0);
    }
}
