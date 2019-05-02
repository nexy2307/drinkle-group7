package com.espressoshock.drinkle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    private static final int windowWidth = 1000;
    private static final int windowHeight = 729;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //RESOURCE LOADING //***********
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/wrappers/main-v-wrapper.fxml"));

        //WINDOW  //***********
        Scene scene = new Scene(root,windowWidth,windowHeight);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add(getClass().getResource("/css/main-v-wrapper.css").toExternalForm());
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Drinkle");
        primaryStage.setScene(scene);
        primaryStage.show();
        //FONT LOADING //***********
        Font.loadFont(getClass().getResource("/fonts/Lato-Black.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-BlackItalic.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-Bold.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-BoldItalic.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-Italic.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-Light.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-LightItalic.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-Regular.ttf").toExternalForm(), 10);

    }


}