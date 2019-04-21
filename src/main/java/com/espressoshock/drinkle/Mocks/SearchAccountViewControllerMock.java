package com.espressoshock.drinkle.Mocks;

import com.espressoshock.drinkle.DBUtils.DBMock;

public final class SearchAccountViewControllerMock {



    //"Returns list of users";
    private void searchWith(String regex) {
        String users = DBMock.searchUserWith(regex);
        updateView(users);
    }

    private void updateView(String data) {}




    private void onUserSelect(String user){
        pushToVC();
    }
    private void pushToVC() {}

}
