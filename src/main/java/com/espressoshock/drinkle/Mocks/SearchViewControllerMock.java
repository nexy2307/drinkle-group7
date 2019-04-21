package com.espressoshock.drinkle.Mocks;

import com.espressoshock.drinkle.DBUtils.DBLayer;
import com.espressoshock.drinkle.DBUtils.DBMock;

public class SearchViewControllerMock {

    /*
    Search Recipe use case
    type String should be modified to "Recipe"
     */

    private String searchRecipeWith(String query) {
        return DBMock.searchRecipe();
    }

//    private void selectRecipe(String recipe) { }

    private void markFavourite(String recipe) {
        DBMock.markFavourite(recipe);
    }




}
