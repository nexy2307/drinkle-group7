package com.espressoshock.drinkle.controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class RecipeEditor implements Initializable {
    @FXML
    Slider slider;
    @FXML
    ProgressBar progressGlass, testBar;
    @FXML
    Label lblVol, lblCost, lblHeader, lblIngredient;
    @FXML
    VBox vBoxChosenIngredients;
    @FXML
    private BorderPane borderPane;

    public void choseIngredient(Event event) {
        Label lbl = (Label) event.getSource();
        String s = lbl.getText();
        System.out.println(s);
        lblIngredient.setText(lbl.getText());
    }

    public void setText(ActionEvent event){
        Button btn = (Button) event.getSource();
        lblHeader.setText(btn.getText()+" button pressed!");
    }
    private void sliderProgressChange(){
        slider.valueProperty().addListener((arg0, arg1, arg2) -> {
            NumberFormat numFormat = NumberFormat.getInstance();
            numFormat.setMaximumFractionDigits(2);
            numFormat.setGroupingUsed(false);
            double sliderValue = slider.getValue();
            sliderValue = Double.valueOf(numFormat.format(sliderValue));
            Double dbl2 = sliderValue*100;
            Double dbl3 = dbl2 * 0.0315;
            progressGlass.setProgress(sliderValue);

            lblVol.setText(String.valueOf(dbl2.intValue()));
            lblCost.setText(numFormat.format(dbl3)+"$");

        });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sliderProgressChange();
    }
}
