package com.espressoshock.drinkle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/wrappers/main-v-wrapper.fxml"));
        primaryStage.setTitle("Drinkle");
        Scene scene = new Scene(root);
        //scene.setFill(Color.TRANSPARENT);
        //scene.getStylesheets().add(getClass().getResource("/css/MainSceneStyle.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getIcons().add(new Image("/images/icon.png"));
        primaryStage.show();
    }
}