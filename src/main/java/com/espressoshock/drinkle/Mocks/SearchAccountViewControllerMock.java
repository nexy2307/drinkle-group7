/*
 *  Copyright Andrian Sergheev
 */

package com.espressoshock.drinkle.Mocks;

import com.espressoshock.drinkle.DBUtils.DBMock;

import java.lang.reflect.Array;

public final class SearchAccountViewControllerMock {




    public void init() {}
    private void configure() {
        // switch user type, configure the view based on that.
    }

    //"Returns list of users";
    private void searchWith(String regex) {
        String users = DBMock.searchUserWith(regex);
        updateView();
    }

    private void updateView(){}



    private void buttonTapped() {
        onUserSelect("User");
    }

    private void onUserSelect(String user){
        pushToVC();
    }
    private void pushToVC() {
        AccountViewControllerMock account = new AccountViewControllerMock();
        account.init();
    }



    private void createGroup(Array user, String name) {
        DBMock.createGroup(name, user);
        updateView();
    }
    private void sendInvitation(String email) {
        DBMock.sendInvitation(email);
        updateView();
    }




}
