package com.master.pages;

import com.master.utils.PageActionsHelper;
import org.openqa.selenium.By;

import static com.master.utils.PageActionsHelper.waitAndClick;
import static com.master.utils.PageActionsHelper.waitAndSendKeys;

public class LoginPage {

    private static final By USERNAME_TEXT_BOX = By.id("txtUsername");
    private static final By PASSWORD_TEXT_BOX = By.id("txtPassword");
    private static final By LOGIN_BUTTON = By.id("btnLogin");

    public LoginPage setUsernameTextBox(String username){
        waitAndSendKeys(USERNAME_TEXT_BOX,username);
        return this;
    }

    public LoginPage setPasswordTextBox(String password) {
        waitAndSendKeys(PASSWORD_TEXT_BOX,password);
        return this;
    }

    public HomePage clickLogin(){
        waitAndClick(LOGIN_BUTTON);
        return new HomePage();
    }

    public HomePage LoginToApplication(String username,String password){
       return setUsernameTextBox(username).setPasswordTextBox(password).clickLogin();

    }
}
