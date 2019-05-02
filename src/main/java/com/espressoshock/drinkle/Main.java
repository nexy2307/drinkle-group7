package com.espressoshock.drinkle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //RESOURCE LOADING //***********
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/wrappers/main-v-wrapper.fxml"));
        //FONT LOADING //***********


        primaryStage.setTitle("Drinkle");
        primaryStage.setScene(new Scene(root, 1000, 729));
        primaryStage.show();
    }

    private void loadFonts(){
        //VEGUR//***********
        Font.loadFont(getClass().getResource("/fonts/Vegur-Bold.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Vegur-Light.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Vegur-Regular.ttf").toExternalForm(), 10);
        //END VEGUR//***********
    }
}