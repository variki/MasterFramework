package com.master.driver.web.remote;

import com.master.driver.manager.web.remote.browserstack.BrowserStackChromeManager;
import com.master.driver.manager.web.remote.browserstack.BrowserStackFirefoxManager;
import com.master.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class BrowserStackFactory {
    private BrowserStackFactory(){

    }

    public static WebDriver getDriver(BrowserType browserType){
        return BrowserType.CHROME == browserType ? BrowserStackChromeManager.getDriver() : BrowserStackFirefoxManager.getDriver();
    }
}
