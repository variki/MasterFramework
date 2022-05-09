package com.master.pages.pagecomponent.usersPage;

import org.openqa.selenium.By;

import static com.master.utils.PageActionsHelper.waitAndClick;

public class UserListComponent {
    private static final By addButton = By.id("btnAdd");

    public void clickAddButton(){
        waitAndClick(addButton);
            }
}
