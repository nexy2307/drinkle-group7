package com.espressoshock.drinkle.models;


import java.util.ArrayList;
import java.util.List;

public class Account implements IActionAccount{
    private String accountID;
    private String accountName;
    private String accountPassword;
    private Person registered;
    private List<Blueprint> blueprints;

    public Account(String accountID, String accountName,String accountPassword,Person registered){
        this.accountID = accountID;
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.registered = registered;
        this.blueprints = new ArrayList<>();
    }

    public Account(String accountID, String accountName, String accountPassword, Person registered, List<Blueprint> blueprints) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.registered = registered;
        this.blueprints = blueprints;
    }

    public String getAccountID(){return accountID;}

    public String getAccountName(){return accountName;}

    public String getAccountPassword(){return accountPassword;}

    public Person getRegistered(){return registered;}

    public Account(List<Blueprint> blueprints) {
        this.blueprints = blueprints;
    }

    public void setAccountID(String accountID){this.accountID = accountID;}

    public void setAccountName(String accountName){this.accountName = accountName;}

    public void setAccountPassword(String accountPassword){this.accountPassword = accountPassword;}

    public void setRegistered(Person registered){this.registered = registered;}

    public void setBlueprints(List<Blueprint> blueprints) {
        this.blueprints = blueprints;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID='" + accountID + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", registered=" + registered +
                ", blueprints=" + blueprints +
                '}';
    }

    @Override
    public boolean addBlueprint(Blueprint blueprint) {
        return this.blueprints.add(blueprint)
    }

    @Override
    public boolean deleteBlueprint(Blueprint blueprint) {
        return this.blueprints.remove(blueprint);
    }

    @Override
    public boolean deleteBlueprintUsingIndex(int pos) {
        try{
            this.blueprints.remove(pos);
        } catch(IndexOutOfBoundsException|UnsupportedOperationException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean editBlueprint(Blueprint source, Blueprint destination) {
        try{
            this.blueprints.set(this.blueprints.indexOf(source), destination);
        } catch(IndexOutOfBoundsException|UnsupportedOperationException|ClassCastException|NullPointerException|IllegalArgumentException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean editBlueprintUsingIndex(int pos, Blueprint destination) {
        return false;
    }
}
