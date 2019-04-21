package com.espressoshock.drinkle.Model.Menu;

import com.espressoshock.drinkle.Model.AccessLevel;
import com.espressoshock.drinkle.Model.Account.Permission;
import com.espressoshock.drinkle.Model.Drinkle.Beverage;
import com.espressoshock.drinkle.Model.Drinkle.Blueprint;
import com.espressoshock.drinkle.Model.Statistic;

import java.sql.Timestamp;
import java.util.List;

public class Menu extends Blueprint {
    private List<Beverage> beverages;
    private String name;
    private String theme;
    private String pictureURL;

    public Menu(String metadata, Timestamp ts, int blueprintId, List<Permission> permissions, AccessLevel accessLevel, Statistic statistic, List<Beverage> beverages, String name, String theme, String pictureURL) {

        super(metadata, ts, blueprintId, permissions, accessLevel, statistic);
        this.beverages = beverages;
        this.name = name;
        this.theme = theme;
        this.pictureURL = pictureURL;
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public String getName() {
        return name;
    }

    public String getTheme() {
        return theme;
    }

    public String getPictureURL() {
        return pictureURL;
    }


    //***NOT RECOMMENDED
    public void setBeverages(List<Beverage> beverages) {
        this.beverages = beverages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}
