package com.espressoshock.drinkle.controllers.app;

import com.espressoshock.drinkle.progressIndicator.RingProgressIndicator;
import com.espressoshock.drinkle.viewLoader.EventDispatcherAdapter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BeverageBuilder extends EventDispatcherAdapter implements Initializable {
    RingProgressIndicator alcoholPercent = new RingProgressIndicator();
    RingProgressIndicator pourCostPercent = new RingProgressIndicator();
    @FXML
    AnchorPane alcoholPercentCircle, pourCostCircle;


public void choseIngredient(){

}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    alcoholPercent.setProgress(17);
    pourCostPercent.setProgress(36);
    alcoholPercentCircle.getChildren().add(alcoholPercent);
    pourCostCircle.getChildren().add(pourCostPercent);
    }
}
