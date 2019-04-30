package com.espressoshock.drinkle.controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.text.NumberFormat;

public class RecipeEditor {
    
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
}
