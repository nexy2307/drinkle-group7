package com.espressoshock.drinkle.controllers.wrappers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewWrapper {
    private double initialX, initialY;
    @FXML
    private AnchorPane loadingPane;
    @FXML
    private Rectangle draggableNode;

    @FXML
    private void exitProgramAction() {
        System.exit(0);
    }
    @FXML
    private void minimizeProgramAction(Event minimizeProgramEvent) {
        Stage stage = (Stage)((ImageView)minimizeProgramEvent.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
    private void addDraggableNode(final Node node) {

        node.setOnMousePressed(mouseEvent -> {
            if (mouseEvent.getButton() != MouseButton.MIDDLE) {
                initialX = mouseEvent.getSceneX();
                initialY = mouseEvent.getSceneY();
            }
        });

        node.setOnMouseDragged(me -> {
            if (me.getButton() != MouseButton.MIDDLE) {
                node.getScene().getWindow().setX(me.getScreenX() - initialX);
                node.getScene().getWindow().setY(me.getScreenY() - initialY);
            }
        });
    }

    @FXML
    public void initialize() throws IOException {
        //fields loaded here -> check if logged/remembered is checked etc...

        boolean auth = false;
        /*if(auth){
            //logged show main ui
        } else{
            //not logged - load auth-default
            Pane authLogin = FXMLLoader.load(getClass().getResource("/fxml/auth/auth-login.fxml"));
            this.loadingPane.getChildren().add(authLogin);

        }*/
        addDraggableNode(draggableNode);
    }

}
