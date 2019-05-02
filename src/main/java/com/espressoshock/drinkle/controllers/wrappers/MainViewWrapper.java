package com.espressoshock.drinkle.controllers.wrappers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewWrapper implements Initializable {

    @FXML
    private AnchorPane loadingPane;
    @FXML
    private Button buttonMoveToIngredientView;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonMoveToIngredientView.setOnAction(e->{
            changeScene(e, "fxml/ingredient-view.fxml");
        });

    }

    private void changeScene(ActionEvent e,String sceneString){

        try{
            Node node =(Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getResource(sceneString));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
