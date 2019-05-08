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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BeverageBuilder extends EventDispatcherAdapter implements Initializable {
    //-------------------------Test variables only!!!----------------
    Label chosenIngredientTEST = null;
    //------------------------End of Test variables------------------
    RingProgressIndicator alcoholPercent = new RingProgressIndicator();
    RingProgressIndicator pourCostPercent = new RingProgressIndicator();
    @FXML
    Label lblChosenName;
    @FXML
    AnchorPane alcoholPercentCircle, pourCostCircle;
    @FXML
    VBox vBoxChosenIngredients, vBoxListOfIngredients;


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
    for (int i = 0; i<60; i++){
        choseIngredientListElement("Ingredient",i+1);
    }
}
public void addIngredientWidget(){
    Label ingredientName = new Label();
    Label ingredientVolume = new Label();
    ProgressBar addedIngredientPercentBar = new ProgressBar();
    ingredientName.setText(lblChosenName.getText());
    ingredientName.setLayoutX(16.0);
    ingredientVolume.setText("0ml");
    ingredientVolume.setLayoutX(195.0);
    addedIngredientPercentBar.setLayoutX(14.0);
    addedIngredientPercentBar.setLayoutY(29.0);
    addedIngredientPercentBar.setProgress(0);
    addedIngredientPercentBar.setPrefWidth(204);
    addedIngredientPercentBar.setPrefHeight(8);
    Group ingredient = new Group();
    ingredient.getChildren().add(ingredientName);
    ingredient.getChildren().add(ingredientVolume);
    ingredient.getChildren().add(addedIngredientPercentBar);
    vBoxChosenIngredients.getChildren().add(ingredient);
}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    alcoholPercent.setProgress(17);
    pourCostPercent.setProgress(36);
    alcoholPercentCircle.getChildren().add(alcoholPercent);
    pourCostCircle.getChildren().add(pourCostPercent);
    dummyIngredientAddToList();
    }
}
