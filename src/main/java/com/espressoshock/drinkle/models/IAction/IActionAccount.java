package com.espressoshock.drinkle.models.IAction;

import com.espressoshock.drinkle.models.Drinkle.Blueprint;

public interface IActionAccount {

    boolean addBlueprint(Blueprint blueprint);
    boolean deleteBlueprint(Blueprint blueprint);
    boolean deleteBlueprintUsingIndex(int pos);
    boolean editBlueprint(Blueprint source, Blueprint destination);
    boolean editBlueprintUsingIndex(int pos, Blueprint destination);

}
