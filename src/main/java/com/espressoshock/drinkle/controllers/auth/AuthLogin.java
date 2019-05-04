package com.espressoshock.drinkle.controllers.auth;

import com.espressoshock.drinkle.viewLoader.EventDispatcherAdapter;
import com.espressoshock.drinkle.viewLoader.ViewMetadata;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class AuthLogin extends EventDispatcherAdapter {
    @FXML
    void openRegistrationView(MouseEvent event) {
        super.dispatchViewChangeRequest(ViewMetadata.AUTH_REGISTRATION);
    }
}
