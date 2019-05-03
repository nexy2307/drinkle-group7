package com.espressoshock.drinkle.controllers.wrappers;

import static com.espressoshock.drinkle.appState.UserState.loggedIn;
import static com.espressoshock.drinkle.appState.UserState.loggedOut;

import com.espressoshock.drinkle.appState.Current;
import com.espressoshock.drinkle.viewLoader.EventObserverAdapter;
import com.espressoshock.drinkle.viewLoader.IEventObserver;
import com.espressoshock.drinkle.viewLoader.ViewLoader;
import com.espressoshock.drinkle.viewLoader.ViewMetadata;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewWrapper extends EventObserverAdapter implements IEventObserver {

    /********* =COMPONENT INJECTION FIELD */
    @FXML
    private AnchorPane loadingWrapperPane;
    /********* END =COMPONENT INJECTION FIELD */

    /********* =VIEW-LOADER           */
    @Override
    public void onViewChangeRequest(ViewMetadata view) {
        System.out.println("onViewChangeRequest received");
    }

    @SuppressWarnings("ConstantConditions")
    public MainViewWrapper() {
        ViewLoader.setLoadingWrapperNode(this.loadingWrapperPane);
    }

    /********* END =VIEW-LOADER           */

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
    /********* END =WINDOW          */





    /********* =INIT W/ LOADED */
    @FXML
    public void initialize() throws IOException {


        //fields loaded here -> check if logged/remembered is checked etc...
        if (Current.environment.userStatus.equals(loggedIn)) {
            //logged show main ui
        } else if (Current.environment.userStatus.equals(loggedOut)) {

            //NOT_LOGGED -> LOAD auth-login


        }
    }
/********* END =INIT W/ LOADED */


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
