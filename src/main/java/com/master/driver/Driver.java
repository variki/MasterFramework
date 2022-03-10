package com.master.driver;

import com.master.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

public class Driver {

    static WebDriver driver = null;
    public static WebDriver initDriver()
    {
        driver = LocalDriverFactory.getDriver(ConfigFactory.getConfig().browser());
        return driver;
    }

    public static void quitDriver(){

    }

}
