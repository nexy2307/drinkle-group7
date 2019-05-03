package com.espressoshock.drinkle.controllers.wrappers;

import static com.espressoshock.drinkle.appState.UserState.loggedIn;
import static com.espressoshock.drinkle.appState.UserState.loggedOut;

import com.espressoshock.drinkle.appState.Current;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewWrapper {

    /********* =WINDOW          */
    public static class Window{
        private static double currentY;
        private static double currentX;

        public Window() {
        }

        public static double getCurrentY() {
            return currentY;
        }

        public static void setCurrentY(double currentY) {
            Window.currentY = currentY;
        }

        public static double getCurrentX() {
            return currentX;
        }

        public static void setCurrentX(double currentX) {
            Window.currentX = currentX;
        }
    }


    /********* =VIEW LOADER */
    public static class ViewLoader{
        private static AnchorPane loadingWrapper;


        public Pane getView(ViewPaths viewPath) throws IOException{
            return FXMLLoader.load(getClass().getResource(viewPath.getPath()));
        }

        public void load(ViewPaths viewPath) throws IOException{
            loadingWrapper.getChildren().add(getView(viewPath));
        }

        public void load(ViewPaths viewPath, double offsetX, double offsetY) throws IOException{
            Pane view = getView(viewPath);
            view.setLayoutX(offsetX);
            view.setLayoutY(offsetY);
            loadingWrapper.getChildren().add(view);
        }

    }
    /********* =END VIEW LOADER */


    /********* =COMPONENT INJECTION FIELD */
    @FXML
    private AnchorPane loadingPane;
    /********* END =COMPONENT INJECTION FIELD */

    /********* =TEMPORARY */
    private ViewLoader viewLoader;
    /********* =TEMPORARY */

    @FXML
    public void initialize() throws IOException {
        viewLoader = new ViewLoader();
        ViewLoader.loadingWrapper = this.loadingPane;

        //fields loaded here -> check if logged/remembered is checked etc...
        if (Current.environment.userStatus.equals(loggedIn)) {
            //logged show main ui
        } else if (Current.environment.userStatus.equals(loggedOut)) {

            //NOT_LOGGED -> LOAD auth-login
            viewLoader.load(ViewPaths.AUTH_LOGIN);

        }
    }



    /********* =WINDOW-CONTROLS */
    @FXML
    public void windowDragStart(MouseEvent event) {
        Window.currentX = event.getSceneX();
        Window.currentY = event.getY();
    }
    @FXML
    public void windowDragEnd(MouseEvent event) {
       ((Node) event.getSource()).getScene().getWindow().setX(event.getScreenX() - Window.currentX);
       ((Node) event.getSource()).getScene().getWindow().setY(event.getScreenY() - Window.currentY);
    }
    @FXML
    public void windowClose(MouseEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }
    public void windowMinimize(MouseEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).setIconified(true);
    }
    /********* END =WINDOW-CONTROLS */
}
