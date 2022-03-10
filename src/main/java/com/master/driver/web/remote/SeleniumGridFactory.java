package com.master.driver.web.remote;

import com.master.driver.manager.web.remote.selenium.SeleniumGridChromeManager;
import com.master.driver.manager.web.remote.selenium.SeleniumGridFireFoxManager;
import com.master.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class SeleniumGridFactory {

    private SeleniumGridFactory(){}

    public static WebDriver getDriver(BrowserType browserType){
        return browserType == BrowserType.CHROME ? SeleniumGridChromeManager.getDriver() : SeleniumGridFireFoxManager.getDriver();
    }
}
