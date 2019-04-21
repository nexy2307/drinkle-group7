package com.espressoshock.drinkle.Mocks;

import com.espressoshock.drinkle.DBUtils.DBMock;

public class SearchRecipeViewControllerMock {

    /*
    Search Recipe use case
    type String should be modified to "Recipe"
     */

    private void searchRecipeWith(String query) {
       String recipe =  DBMock.searchRecipe();
       updateView(recipe);
    }

    private void updateView(String recipe) {}

//    private void selectRecipe(String recipe) { }

    private void markFavourite(String recipe) {
        DBMock.markFavourite(recipe);
        updateView(recipe);
    }





}
