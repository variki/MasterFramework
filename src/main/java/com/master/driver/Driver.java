package com.master.driver;

import com.master.config.factory.ConfigFactory;
import com.master.driver.web.local.LocalDriverFactory;
import org.openqa.selenium.WebDriver;

public final class Driver {

    static WebDriver driver = null;
    public static WebDriver initDriver()
    {
        driver = LocalDriverFactory.getDriver(ConfigFactory.getConfig().browser());
        return driver;
    }

    public static void quitDriver(){

    }

}
