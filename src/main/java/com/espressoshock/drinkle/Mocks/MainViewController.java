package com.espressoshock.drinkle.Mocks;

import com.espressoshock.drinkle.DBUtils.DBMock;

public final class MainViewController {

    /*
    Note: there will be three views in the app, handled by a tabBar.
     */

    /*
    Search Recipe use case
    type String should be modified to "Recipe"
     */


    public void init() {}

    private void searchRecipeWith(String query) {
       String recipe =  DBMock.searchRecipe();
       updateView();
    }

    private void updateView(){}

//    private void selectRecipe(String recipe) { }

    private void markFavourite(String recipe) {
        DBMock.markFavourite(recipe);
        updateView();
    }


    /*
    Create Recipe Use Case
    */


    ///gllasstype, name,ingredients, blablabla
    private void createRecipe(String name, String glasstype) {
        DBMock.createRecipe(name);
        updateView();
    }






}