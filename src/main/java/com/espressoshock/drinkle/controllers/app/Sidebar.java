package com.espressoshock.drinkle.controllers.app;

import com.espressoshock.drinkle.viewLoader.EventDispatcherAdapter;
import com.espressoshock.drinkle.viewLoader.ViewLoader;
import com.espressoshock.drinkle.viewLoader.ViewMetadata;
import javafx.fxml.FXML;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class Sidebar extends EventDispatcherAdapter {
    @FXML
    private ToggleGroup sidebarMenu;


    @FXML
    public void initialize() {
        /********* =DEFAULT_LOADED SELECTOR */
        this.selecteMenuItem(ViewLoader.default_view.name());
        /********* END =DEFAULT_LOADED SELECTOR */

        /********* =TOGGLE-GROUP SELECTED STATE LISTENER */
        sidebarMenu.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if(sidebarMenu.getSelectedToggle() != null)
                super.dispatchViewChangeRequest(this.getViewMetadata(sidebarMenu.getSelectedToggle().getUserData().toString()));
        });
        /********* END =TOGGLE-GROUP SELECTED STATE LISTENER */

    }

    public ViewMetadata getViewMetadata(String viewName){
        for(ViewMetadata vm : ViewMetadata.values())
            if (vm.name().equals(viewName) )
                return ViewMetadata.valueOf(vm.name());

        return ViewLoader.default_view;

    }

    public String getSelectedMenuItem(){
       return (String)sidebarMenu.getSelectedToggle().getUserData().toString();
    }
    public void selecteMenuItem(String userData){
        for(Toggle toggle : this.sidebarMenu.getToggles())
            if(toggle.getUserData().toString().equals(userData))
                toggle.setSelected(true);
            //careful here-userData must be valid
    }
}
