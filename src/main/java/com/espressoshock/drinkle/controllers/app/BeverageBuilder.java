package com.espressoshock.drinkle.controllers.app;

import com.espressoshock.drinkle.progressIndicator.RingProgressIndicator;
import com.espressoshock.drinkle.viewLoader.EventDispatcherAdapter;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BeverageBuilder extends EventDispatcherAdapter implements Initializable {
    //-------------------------Test variables only!!!----------------

    Integer volumeSeparator = 0;
    Double progressSeparator = 0.0;
    String strDouble = null;
    String cost = null;
    Double volume = null;
    //------------------------End of Test variables------------------
    RingProgressIndicator alcoholPercent = new RingProgressIndicator();
    RingProgressIndicator pourCostPercent = new RingProgressIndicator();
    @FXML
    Label lblChosenName, lblVolume, lblCost, lblTotalVolume;
    @FXML
    AnchorPane alcoholPercentCircle, pourCostCircle;
    @FXML
    VBox vBoxChosenIngredients, vBoxListOfIngredients;
    @FXML
    Slider slider;
    @FXML
    ProgressBar progressGlass;

    private void sliderProgressChange(){
        slider.valueProperty().addListener((arg0, arg1, arg2) -> {
            try {
                strDouble = String.format("%.2f", slider.getValue());
                volume = Double.parseDouble(strDouble) * 100;
                cost = String.format("%.2f", volume * 0.0315);
                progressGlass.setProgress(Double.parseDouble(strDouble));
                lblVolume.setText(String.valueOf(volume.intValue()));
                lblCost.setText(cost);
            } catch(NumberFormatException ex) {
                //throws exception only on MacOS.
                System.out.println(ex);
            }
        });


    }

public void choseIngredient(Event event){
    Label lbl = (Label) event.getSource();
    lblChosenName.setText(lbl.getText());
}
public void choseIngredientListElement(String name, int number){

    Label choseIngredientName = new Label();
    Label choseIngredientPrice = new Label();
    choseIngredientName.setText(name + " nr. " + number);
    choseIngredientName.setOnMouseClicked((Event event) -> {choseIngredient(event);});
    choseIngredientName.setCursor(Cursor.HAND);
    choseIngredientPrice.setText("3.15" + " $/l");
    choseIngredientPrice.setLayoutX(214.0);
    Group choseIngredient = new Group();
    choseIngredient.getChildren().add(choseIngredientName);
    choseIngredient.getChildren().add(choseIngredientPrice);
    vBoxListOfIngredients.getChildren().add(choseIngredient);
}
public void dummyIngredientAddToList(){//for Test Purpose Only!!!!
                                       // To be replaced with observable list of ingredient objects

    for (int i = 0; i<60; i++){
        choseIngredientListElement("Ingredient",i+1);
    }
}

public void addIngredientWidget(){
        // Test purposes only
    Integer setVolume = volume.intValue() - volumeSeparator;
    Double setProgress = progressGlass.getProgress()-progressSeparator;
    Label ingredientName = new Label();
    Label ingredientVolume = new Label();
    ProgressBar addedIngredientPercentBar = new ProgressBar();
    ingredientName.setText(lblChosenName.getText());
    ingredientName.setLayoutX(16.0);
    ingredientVolume.setText(setVolume+"ml");
    ingredientVolume.setLayoutX(195.0);
    addedIngredientPercentBar.setLayoutX(14.0);
    addedIngredientPercentBar.setLayoutY(29.0);
    addedIngredientPercentBar.setProgress(setProgress);
    addedIngredientPercentBar.setPrefWidth(204);
    addedIngredientPercentBar.setPrefHeight(8);
    Group ingredient = new Group();
    ingredient.getChildren().add(ingredientName);
    ingredient.getChildren().add(ingredientVolume);
    ingredient.getChildren().add(addedIngredientPercentBar);
    vBoxChosenIngredients.getChildren().add(ingredient);
    volumeSeparator = volume.intValue();
    progressSeparator = progressGlass.getProgress();
    slider.setMin(slider.getValue());


}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    alcoholPercent.setProgress(17);
    pourCostPercent.setProgress(36);
    alcoholPercentCircle.getChildren().add(alcoholPercent);
    pourCostCircle.getChildren().add(pourCostPercent);
    dummyIngredientAddToList();
    sliderProgressChange();
        lblTotalVolume.setText("100");


    }
}
