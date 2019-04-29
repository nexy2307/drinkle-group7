package com.espressoshock.drinkle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }




    @Override
    public void start(Stage primaryStage) {
        Text text = new Text("Hello world drinkle!");
        Group root = new Group();
        text.setY(50);
        root.getChildren().add(text);
        primaryStage.setTitle("Drinkle");
        primaryStage.setScene(new Scene(root, 1000, 729));
        primaryStage.show();
    }




}