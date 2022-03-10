package com.master.driver.manager.web.remote.browserstack;

import com.master.config.factory.BrowserStackConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStackChromeManager {
    private BrowserStackChromeManager(){

    }
    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browser","chrome");
        capabilities.setCapability("browser_version","lastest");
        capabilities.setCapability("os","windows");
        capabilities.setCapability("os_version","10");
        return new RemoteWebDriver(BrowserStackConfigFactory.getConfig().browserStackURL(), capabilities);
    }
}
