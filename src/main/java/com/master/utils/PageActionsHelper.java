package com.master.utils;

import com.master.driver.DriverManager;
import org.openqa.selenium.By;

public class PageActionsHelper {

    public PageActionsHelper(){}

    public static void waitAndSendKeys(By by, String value){
        DriverManager.getDriver().findElement(by).sendKeys(value);
    }

    public static void waitAndClick(By by){
        DriverManager.getDriver().findElement(by).click();
    }
}
