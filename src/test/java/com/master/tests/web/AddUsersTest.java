package com.master.tests.web;

import com.master.pages.LoginPage;
import com.master.tests.web.base.WebBase;
import org.testng.annotations.Test;

public class AddUsersTest extends WebBase {

    @Test
    public void testAddUser(){
        new LoginPage()
                .LoginToApplication("","")
                .navigateToAddUserPage()
                .clickAdd();


    }
}
