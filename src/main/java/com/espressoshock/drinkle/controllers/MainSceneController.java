package com.espressoshock.drinkle.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    @FXML
    Slider slider;
    @FXML
    ProgressBar progressGlass;
    @FXML
    Label lblVol, lblCost, lblHeader, lblIngredient;
    @FXML
    Tab tab1,tab2;
    @FXML
    Pane paneTab1;

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
    public void asd(){
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                NumberFormat numFormat = NumberFormat.getInstance();
                numFormat.setMaximumFractionDigits(2);
                numFormat.setGroupingUsed(false);
                Double sliderValue = Double.valueOf((double) slider.getValue());
                sliderValue = Double.valueOf(numFormat.format(sliderValue));
                Double dbl2 = sliderValue*100;
                Double dbl3 = dbl2 * 0.0315;
                progressGlass.setProgress(sliderValue);

                lblVol.setText(String.valueOf(dbl2.intValue()));
                lblCost.setText(String.valueOf(numFormat.format(dbl3))+"$");

            }
        });

    }
    public void setGraphic(){
        tab1.setGraphic(new ImageView("img/editorIcon.png"));
        tab2.setGraphic(new ImageView("img/drinkIcon.png"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        asd();
        setGraphic();

    }
}
