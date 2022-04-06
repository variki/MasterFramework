package com.master.driver.manager.web.remote.selenium;

import com.master.config.factory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class SeleniumGridFireFoxManager {
    private SeleniumGridFireFoxManager(){

    }

    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.FIREFOX);
        System.out.println("Grid URL is : "+ConfigFactory.getConfig().seleniumGridURL());
        return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridURL(),capabilities);
    }
}
