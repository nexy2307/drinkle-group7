package com.espressoshock.drinkle.controllers.auth;

import com.espressoshock.drinkle.daoLayer.JPADaoManager;
import com.espressoshock.drinkle.models.Account;
import com.espressoshock.drinkle.models.PrivateAccount;
import com.espressoshock.drinkle.viewLoader.EventDispatcherAdapter;
import com.espressoshock.drinkle.viewLoader.ViewLoader;
import com.espressoshock.drinkle.viewLoader.ViewMetadata;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AuthLogin extends EventDispatcherAdapter {
    private class AsyncCallable implements Callable<Boolean>{
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

    /********* TODO: IMPLEMENT APPSTATE CON. */
    private Boolean digestResult;
    /********* END TODO: IMPLEMENT APPSTATE CON. */

    @FXML
    public void openRegistrationView(MouseEvent event) {
        super.dispatchViewChangeRequest(ViewMetadata.AUTH_REGISTRATION);
    }

    @FXML
    public void login(MouseEvent event)throws Exception {

        showDialog();

        /********* =NON-BLOCK ASYNC REQUEST  */
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Boolean> task = es.submit(new AsyncCallable(emailTf.getText(), passwordTf.getText()));

        /********* END =NON-BLOCK ASYNC REQUEST  */

        /********* EVENT DISPATCHER -> WITHIN SAME THREAD  */
        //if(task.get())
            super.dispatchViewChangeRequest(ViewLoader.default_view);

    }

    /********* =DIALOGS  */
    private void showDialog(){
      this.dialogWindow.setVisible(true);
    }

    private void hideDialog(){
        this.dialogWindow.setVisible(false);
    }
    /********* END =DIALOGS  */

    public void continueApp(){

    }

}
