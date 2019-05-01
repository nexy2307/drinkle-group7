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
        this.loadFonts();

        primaryStage.setTitle("Drinkle");
        primaryStage.setScene(new Scene(root, 1000, 729));
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    private void loadFonts(){
        //LATO//***********
        Font.loadFont(getClass().getResource("/fonts/Lato-Black.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-BlackItalic.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-Bold.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-BoldItalic.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-Italic.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-Light.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-LightItalic.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/fonts/Lato-Regular.ttf").toExternalForm(), 10);
        //END LATO//***********
    }
}