package com.espressoshock.drinkle.controllers.auth;

import com.espressoshock.drinkle.viewLoader.EventDispatcherAdapter;
import com.espressoshock.drinkle.viewLoader.ViewLoader;
import com.espressoshock.drinkle.viewLoader.ViewMetadata;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class AuthRegistration extends EventDispatcherAdapter {

  @FXML
  public void openLoginView(MouseEvent event) {
    super.dispatchViewChangeRequest(ViewMetadata.AUTH_LOGIN);
  }
  @FXML
  public void register(MouseEvent event){
    //some serious business logic
    super.dispatchViewChangeRequest(ViewLoader.default_view);
  }

}
