package com.espressoshock.drinkle.viewLoader;

import com.espressoshock.drinkle.controllers.app.BeverageList;
import com.espressoshock.drinkle.controllers.app.IngredientList;
import com.espressoshock.drinkle.controllers.app.MenuList;
import com.espressoshock.drinkle.controllers.auth.AuthLogin;
import com.espressoshock.drinkle.controllers.auth.AuthRegistration;

public enum ViewMetadata {
    AUTH_LOGIN(AuthLogin.class, "/fxml/auth/auth-login.fxml"),
    AUTH_REGISTRATION(AuthRegistration.class, "/fxml/auth/auth-registration.fxml"),
    APP_INGREDIENT_LIST(IngredientList.class, "/fxml/app/ingredient-list.fxml"),
    APP_BEVERAGE_LIST(BeverageList.class, "/fxml/app/beverage-list.fxml"),
    APP_MENU_LIST(MenuList.class, "/fxml/app/menu-list.fxml");




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
