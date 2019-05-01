package com.espressoshock.drinkle.controllers.wrappers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
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
    private BorderPane borderPane;
    @FXML
    private Button btn1, btn2, btn3, btn4, btn5, btn6;

    @FXML
    private void exitProgramAction() {
        System.exit(0);
    }
    @FXML
    private void minimizeProgramAction(Event minimizeProgramEvent) {
        Stage stage = (Stage)((ImageView)minimizeProgramEvent.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
    private static void clipChildren(Region pane, double arc) {

        final Rectangle rectangleClip = new Rectangle();
        rectangleClip.setArcWidth(arc);
        rectangleClip.setArcHeight(arc);
        pane.setClip(rectangleClip);

        pane.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            rectangleClip.setWidth(newValue.getWidth());
            rectangleClip.setHeight(newValue.getHeight());
        });
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
    private void menu1(){
        loadScene("/fxml/menu2.fxml");
    }
    @FXML
    private void menu2(){
        loadScene("/fxml/recipe-editor.fxml");
    }
    @FXML
    private void menu3(){
        borderPane.setCenter(null);
    }
    @FXML
    private void menu4(){
        borderPane.setCenter(null);
    }
    @FXML
    private void menu5(){
        borderPane.setCenter(null);
    }
    @FXML
    private void menu6(){
        borderPane.setCenter(null);
    }
    private void loadScene(String path){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(path));
        }catch (IOException ex){
            ex.printStackTrace();
        }
        borderPane.setCenter(root);
    }
    private void setGraphics(){
        btn1.setGraphic(new ImageView("images/drinkIcon.png"));
        btn2.setGraphic(new ImageView("images/editorIcon.png"));
        btn3.setGraphic(new ImageView("images/btn.png"));
        btn4.setGraphic(new ImageView("images/btn.png"));
        btn5.setGraphic(new ImageView("images/btn.png"));
        btn6.setGraphic(new ImageView("images/btn.png"));
    }
    @FXML
    public void initialize() throws IOException {
        //fields loaded here -> check if logged/remembered is checked etc...

        /*boolean auth = false;
        if(auth){
            //logged show main ui
        } else{
            //not logged - load auth-default
            Pane authLogin = FXMLLoader.load(getClass().getResource("/fxml/auth/auth-login.fxml"));
            this.loadingPane.getChildren().add(authLogin);

        }*/
        addDraggableNode(draggableNode);
        clipChildren(borderPane, 60);
        setGraphics();
        menu1();
    }

}
