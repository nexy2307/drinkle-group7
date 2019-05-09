package com.espressoshock.drinkle;
import com.espressoshock.drinkle.daoLayer.JPADaoManager;
import com.espressoshock.drinkle.daoLayer.entities.JPAPersonDao;
import com.espressoshock.drinkle.daoLayer.entities.PersonDao;
import com.espressoshock.drinkle.models.Account;
import com.espressoshock.drinkle.models.Person;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    private static final int windowWidth = 1000;
    private static final int windowHeight = 729;

    private PersonDao personDao;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, Exception {
        //RESOURCE LOADING //***********
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/wrappers/main-v-wrapper.fxml"));
        //WINDOW  //***********
        Scene mainScene = new Scene(root, windowWidth, windowHeight);
        mainScene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);


        primaryStage.setTitle("Drinkle");
        primaryStage.setResizable(false);
        primaryStage.setScene(mainScene);
        primaryStage.show();


        //JPADaoManager jpaDaoManager = new JPADaoManager();
        //jpaDaoManager.login(new Account("email@company.com", "password", "pictureURL", null, null));

        /*
        shows current jdk used by the app itself.
        System.out.println(System.getProperties());
        */
    }


}