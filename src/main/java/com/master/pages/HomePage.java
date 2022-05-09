package com.master.pages;

import com.master.pages.enums.topMenuComponent.MenuType;
import com.master.pages.enums.topMenuComponent.SubMenuType;
import com.master.pages.pagecomponent.homepage.TopMenuComponent;

public class HomePage {



    private TopMenuComponent topMenuComponent;

    public HomePage(){
        this.topMenuComponent = new TopMenuComponent();
    }

    public TopMenuComponent getTopMenuComponent() {
        return topMenuComponent;
    }

    public UsersPage navigateToAddUserPage(){
        topMenuComponent.clickItemMenu(MenuType.ADMIN)
                .clickSubMenu(SubMenuType.USER_MANAGEMENT)
                .clickSubMenu(SubMenuType.USERS);
        return new UsersPage();
    }
}
