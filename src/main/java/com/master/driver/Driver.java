package com.master.driver;

import com.master.config.factory.ConfigFactory;
import com.master.driver.entity.MobileDriverData;
import com.master.driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class Driver {

    private static WebDriver driver;
    private Driver(){}

    public static void initDriverforWeb()
    {
        if(Objects.isNull(DriverManager.getDriver())) {
            WebDriverData driverData = new WebDriverData(ConfigFactory.getConfig().browser(), ConfigFactory.getConfig().webRemoteRunMode());
            driver = DriverFactory.getDriverforWeb(ConfigFactory.getConfig().runMode()).getDriver(driverData);
            DriverManager.setDriver(driver);
        }
    }

    public static void initDriverforMobile()
    {
        if(Objects.isNull(DriverManager.getDriver())) {
            MobileDriverData driverData = new MobileDriverData(ConfigFactory.getConfig().mobilePlatform(), ConfigFactory.getConfig().mobileRemotePlatform());
            driver = DriverFactory.getDriverforMobile(ConfigFactory.getConfig().runMode()).getDriver(driverData);
            DriverManager.setDriver(driver);
        }
    }

    public static void quitDriver(){
     DriverManager.getDriver().quit();
    }

}
