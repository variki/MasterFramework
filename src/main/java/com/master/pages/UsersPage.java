package com.master.pages;

import com.master.pages.pagecomponent.usersPage.SearchComponent;
import com.master.pages.pagecomponent.usersPage.UserListComponent;

public class UsersPage {

    private final SearchComponent searchComponent;
    private final UserListComponent userListComponent;

    public UsersPage(){
        this.searchComponent = new SearchComponent();
        this.userListComponent = new UserListComponent();
    }
    public UserListComponent getUserListComponent() {
        return userListComponent;
    }
    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public AddUserPage clickAdd(){
        userListComponent.clickAddButton();
        return new AddUserPage();
    }


}
