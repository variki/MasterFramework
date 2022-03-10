package com.master.driver.web.remote;

import com.master.driver.manager.web.remote.selenoid.SelenoidChromeManager;
import com.master.driver.manager.web.remote.selenoid.SelenoidFirefoxManager;
import com.master.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public class SelenoidFactory {
    private SelenoidFactory(){

    }

    public static WebDriver getDriver(BrowserType browserType){
        return BrowserType.CHROME == browserType ? SelenoidChromeManager.getDriver() : SelenoidFirefoxManager.getDriver();

    }
}
