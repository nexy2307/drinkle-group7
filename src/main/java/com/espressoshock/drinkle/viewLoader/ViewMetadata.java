package com.espressoshock.drinkle.viewLoader;

import com.espressoshock.drinkle.controllers.auth.AuthLogin;
import com.espressoshock.drinkle.controllers.auth.AuthRegistration;

public enum ViewMetadata {
    AUTH_LOGIN(AuthLogin.class, "/fxml/auth/auth-login.fxml"),
    AUTH_REGISTRATION(AuthRegistration.class, "/fxml/auth/auth-registration.fxml");

    private final Class controllerClass;
    private final String resourcePath;

    ViewMetadata(Class controllerClass, String resourcePath) {
        this.controllerClass = controllerClass;
        this.resourcePath = resourcePath;
    }

    public Class getControllerClass() {
        return controllerClass;
    }

    public String getResourcePath() {
        return resourcePath;
    }
}
