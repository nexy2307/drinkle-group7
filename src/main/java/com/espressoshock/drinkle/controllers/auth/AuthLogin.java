package com.espressoshock.drinkle.controllers.auth;

import com.espressoshock.drinkle.daoLayer.JPADaoManager;
import com.espressoshock.drinkle.models.PrivateAccount;
import com.espressoshock.drinkle.viewLoader.EventDispatcherAdapter;
import com.espressoshock.drinkle.viewLoader.ViewLoader;
import com.espressoshock.drinkle.viewLoader.ViewMetadata;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.util.concurrent.*;

public class AuthLogin extends EventDispatcherAdapter {
    private static class AsyncCallable implements Callable<Boolean>{
        public static Boolean digestresult;
        private final String email;
        private final String password;

        public AsyncCallable(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public Boolean call(){
            JPADaoManager jpaDaoManager = new JPADaoManager();
            if (jpaDaoManager.login(new PrivateAccount(email, password, null, null, null)) != null) {
                //logged
                return true;
            } else {
                //incorrect username/password
              return false;

            }
        }
    }

    @FXML
    private TextField emailTf;

    @FXML
    private HBox dialogWindow;

    @FXML
    private ToggleGroup loginType;

    @FXML
    private PasswordField passwordTf;

    @FXML
    private Label errorLbl;


    @FXML
    public void openRegistrationView(MouseEvent event) {
        super.dispatchViewChangeRequest(ViewMetadata.AUTH_REGISTRATION);
    }

    @FXML
    public void login(MouseEvent event)throws Exception {
        /********* SHOW LOGIN MODAL DIALOG  */
        this.showDialog();

        /********* =NON-BLOCK ASYNC REQUEST  */
       CompletableFuture.supplyAsync( () -> {
            JPADaoManager jpaDaoManager = new JPADaoManager();
            if (jpaDaoManager.login(new PrivateAccount(emailTf.getText(), passwordTf.getText(), null, null, null)) != null) {
                //logged
                this.hideDialog();
                errorLbl.setVisible(false);
                return true;
            } else {
                //incorrect username/password
                this.hideDialog();
                errorLbl.setVisible(true);
                return false;
            }
        }).thenAccept( (status) ->{
            /********* EVENT DISPATCHER -> WITHIN SAME THREAD  */
           Platform.runLater(new Runnable(){
               @Override public void run() {
                   System.out.println(status);
                   if(status) AuthLogin:SynchContinueApp();
               }
           });
            System.out.println(status);
        });








    }

    /********* =DIALOGS  */
    private void showDialog(){
      this.dialogWindow.setVisible(true);
    }

    private void hideDialog(){
        this.dialogWindow.setVisible(false);
    }
    /********* END =DIALOGS  */

    public void SynchContinueApp(){
        super.dispatchViewChangeRequest(ViewLoader.default_view);
    }

}
