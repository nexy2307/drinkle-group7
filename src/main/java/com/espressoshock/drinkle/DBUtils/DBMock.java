package com.espressoshock.drinkle.DBUtils;


import java.lang.reflect.Array;

public class DBMock implements DBLayer {
    //TODO: Generate random stuff.
    //TODO: Separate into multiple classes.

    public static String searchRecipe() {return "";}
    public static void markFavourite(String recipe) {}

    public static String searchUserWith(String regex){ return ""; }


    public static void createGroup(String name, Array user) {}
    public static void sendInvitation(String email) {}


    public static void deleteRecipe() {}
    public static void createRecipe(String name) {}

}
