package com.master.pages.pagecomponent.homepage;

import com.master.pages.enums.topMenuComponent.MenuType;
import com.master.pages.enums.topMenuComponent.SubMenuType;
import org.openqa.selenium.By;

import static com.master.utils.PageActionsHelper.waitAndClick;

public class TopMenuComponent {

    private static final String MENU = "//b[text()='%s']/parent::a";
    private static final String SUB_MENU="//a[text()='%s']";

    public TopMenuComponent clickItemMenu(MenuType menuType){
        String xpath = String.format(MENU,menuType.getName());
        waitAndClick(By.xpath(xpath));
        return this;
    }

    public TopMenuComponent clickSubMenu(SubMenuType submenuType){
        String xpath = String.format(SUB_MENU,submenuType.getName());
        waitAndClick(By.xpath(xpath));
        return this;
    }
}
