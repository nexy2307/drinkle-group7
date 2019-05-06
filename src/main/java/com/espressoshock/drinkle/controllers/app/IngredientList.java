package com.espressoshock.drinkle.controllers.app;

import com.espressoshock.drinkle.viewLoader.EventDispatcherAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class IngredientList extends EventDispatcherAdapter {
    @FXML
    private VBox vBoxIngredients;

    @FXML
    private Button btnCreate, btnAddToInventory, btnSearch, btnChoose1, btnChoose2;

    @FXML
    private CheckBox checkBoxAddToList, checkBoxLike;

    @FXML
    private MenuButton menuButtonBrands, menuButtonProducts, menuBtnGoTo;

    @FXML
    private ProgressBar progressBarAlcohol, progressBarPrice;

    @FXML
    private TextArea txtAreaDescription;

    @FXML
    private TextField  txtFieldPrice, txtFieldSearchOption, txtFieldVisualisations, txtFieldLike, txtFieldProductName, txtFieldSimilarWithProduct, txtFieldProductOneName, txtFieldProductTwoName, txtFieldAlcohol;

    @FXML
    private ImageView imgViewProduct, imgViewSimilarProduct1, imgViewSimilarProduct2;

}
