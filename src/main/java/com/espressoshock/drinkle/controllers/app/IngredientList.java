package com.espressoshock.drinkle.controllers.app;

import com.espressoshock.drinkle.models.Brand;
import com.espressoshock.drinkle.models.Ingredient;
import com.espressoshock.drinkle.models.IngredientCategory;
import com.espressoshock.drinkle.viewLoader.EventDispatcherAdapter;
//import com.espressoshock.drinkle.viewLoader.ViewMetadata;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IngredientList extends EventDispatcherAdapter implements Initializable {

    private ArrayList<Brand> brandsList = new ArrayList<>();
    private ArrayList<IngredientCategory> typesList = new ArrayList<>();
    private ArrayList<Ingredient> ingredientsList = new ArrayList<>();

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

    public void changeView(){
      //  super.dispatchViewChangeRequest(ViewMetadata.);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBrandsList();
        setTypesList();
        setIngredientsList();
    }

    // TODO*********************Methods*************************************
    @FXML
    private void selectSimilarProductPicture(){}
    @FXML
    private void selectLike(){}
    @FXML
    private void selectAddToFavorit(){}
    @FXML
    private void selectCreate(){}

    private void changeScene(String fxmlFile){}
    //TODO****************************************************************End

    @FXML
    private void selectGoToMenuButton(ActionEvent e) {
        MenuItem selection = (MenuItem) e.getSource();
        if (selection.getText().equals("Account Scene")) {
            //TODO changeScene to AccountScene
            changeScene("AccountScene.fxml");//to check
        } else {
            //TODO changeScene to RecipeScene
            changeScene("RecipeScene.fxml");//to check
        }
    }//TODO add the right fxml file when ready
    @FXML
    private void selectBtnSearch() {
        vBoxIngredients.getChildren().clear();
        String text = txtFieldSearchOptions.getText().toLowerCase();
        for (Ingredient x : ingredientsList) {
            if (text.length() != 0) {
                if (x.getName().toLowerCase().contains(text)) {
                    Button button = new Button();
                    button.setOnAction(this::selectVboxButton);
                    button.setMinWidth(280);
                    button.setMinHeight(40);
                    button.setText(x.getName());
                    vBoxIngredients.getChildren().add(button);
                }
            }else if(txtFieldProductName.getText().isEmpty()){
                prgBarAlc.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
                prgBarPrice.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
            }
        }
    }
    @FXML
    private void selectMenuItemType(ActionEvent e) {
        MenuItem selection = (MenuItem) e.getSource();
        menuButtonSelectBrand.getItems().clear();
        for (Brand x : brandsList) {
            if (selection.getText().equals(x.getProductType().getName())) {
                MenuItem button = new MenuItem();
                button.setText(x.getBrandName());
                button.setOnAction(this::selectMenuItemBrand);
                txtAreaDescription.clear();
                txtAreaDescription.appendText(x.getDescription());
                txtFieldProductName.setText(x.getProductType().getName());
                menuButtonSelectBrand.getItems().add(button);
            }
        }
    }
    @FXML
    private void selectMenuItemBrand(ActionEvent e) {
        MenuItem selection = (MenuItem) e.getSource();
        for (Ingredient x : ingredientsList) {
            if (selection.getText().equals(x.getBrand().getBrandName())) {
                Button button = new Button();
                button.setOnAction(this::selectVboxButton);
                button.setMinWidth(280);
                button.setMinHeight(40);
                button.setText(x.getName());
                vBoxIngredients.getChildren().add(button);
            }
        }
    }
    @FXML
    private void selectVboxButton(ActionEvent e) {

        Button selectedButton = (Button) e.getSource();
        txtFieldProductName.setText(selectedButton.getText());
        prgBarAlc.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
        prgBarPrice.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
        for (Ingredient x : ingredientsList)
            if (x.getName().equals(selectedButton.getText())) {
                txtAreaDescription.clear();
                txtAreaDescription.appendText(x.getDescription());
                txtFieldAlcohol.setText(String.valueOf(x.getAlcohol()));
                txtFieldPrice.setText(String.valueOf(x.getPrice()));
                txtFieldSimilarWith.setText(x.getName());
                prgBarAlc.setProgress(x.getAlcohol() / 100);
                prgBarPrice.setProgress(x.getPrice() / 1000);
                //TODO add product image
                //TODO add three similar products images
            }
    }//TODO add images to the view

    private void setIngredientsList() {
        ingredientsList.add(new Ingredient("Jameson black", "Collection Jameson", IngredientCategory.WHISKEY, Brand.JAMESON, 445.45, 44.5));
        ingredientsList.add(new Ingredient("Fortaleza xo", "XO Tequila", IngredientCategory.TEQUILA, Brand.FORTALEZA, 1280.90, 42.5));
        ingredientsList.add(new Ingredient("Absolut Dry", "Dry vodka", IngredientCategory.VODKA, Brand.ABSOLUTE, 345.45, 40));
        ingredientsList.add(new Ingredient("Smirnoff lemon", "Lemon Vodka", IngredientCategory.VODKA, Brand.SMIRNOFF, 280.90, 38.5));
        ingredientsList.add(new Ingredient("Jack Daniel's black label", "12 XO Jack Daniel", IngredientCategory.WHISKEY, Brand.JACK_DANIELS, 1045.5, 40));
        ingredientsList.add(new Ingredient("Grey Goose XO", "12 XO Grey Goose", IngredientCategory.VODKA, Brand.GREY_GOOSE, 1450.5, 42.5));
        ingredientsList.add(new Ingredient("Tito's Extra", "Collection Tequila", IngredientCategory.TEQUILA, Brand.TITOS, 345.45, 44));
        ingredientsList.add(new Ingredient("Carolans special", "Extra Carolans", IngredientCategory.LIQUEUR, Brand.CAROLANS, 230.90, 28.5));
        ingredientsList.add(new Ingredient("Kahlua  x", "Kahlua special", IngredientCategory.LIQUEUR, Brand.KAHLUA, 1450.5, 36.5));
    }

    private void setTypesList() {
        typesList.add(IngredientCategory.GLASSWARE);
        typesList.add(IngredientCategory.GARNISH);
        typesList.add(IngredientCategory.ICE_TYPE);
    }

    private void setBrandsList() {
        //  brandsList.add();
    }


}
}
