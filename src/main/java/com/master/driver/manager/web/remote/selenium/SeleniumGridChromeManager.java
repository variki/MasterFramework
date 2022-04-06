package com.master.driver.manager.web.remote.selenium;

import com.master.config.factory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class SeleniumGridChromeManager {
    private SeleniumGridChromeManager(){

    }

    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);

        System.out.println("Grid URL : "+ConfigFactory.getConfig().seleniumGridURL());
        return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridURL(),capabilities);
    }
}
