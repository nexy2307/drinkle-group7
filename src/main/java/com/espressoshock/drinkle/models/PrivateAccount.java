package com.espressoshock.drinkle.models;

import java.util.List;

public class PrivateAccount extends Account{

    private String email;
    private String username;


    public PrivateAccount(String accountID, String accountName, String accountPassword, Person registered, String email, String username) {
        super(accountID, accountName, accountPassword, registered);
        this.email = email;
        this.username = username;
    }

    public PrivateAccount(String accountID, String accountName, String accountPassword, Person registered, List<Blueprint> blueprints, String email, String username) {
        super(accountID, accountName, accountPassword, registered, blueprints);
        this.email = email;
        this.username = username;
    }

    public PrivateAccount(List<Blueprint> blueprints, String email, String username) {
        super(blueprints);
        this.email = email;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "PrivateAccount{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
