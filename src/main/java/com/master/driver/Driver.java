package com.master.driver;

import com.master.config.factory.ConfigFactory;
import com.master.driver.entity.MobileDriverData;
import com.master.driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public final class Driver {

    static WebDriver driver = null;

    private Driver(){}

    public static WebDriver initDriverforWeb()
    {

       WebDriverData driverData = WebDriverData.builder()
                .browserType(ConfigFactory.getConfig().browser())
                .webRemoteRunMode(ConfigFactory.getConfig().webRemoteRunMode())
                .build();
        return DriverFactory.getDriverforWeb(ConfigFactory.getConfig().runMode()).getDriver(driverData);
    }

    public static WebDriver initDriverforMobile()
    {

        MobileDriverData driverData = MobileDriverData.builder()
                .mobilePlatformType(ConfigFactory.getConfig().mobilePlatform())
                .mobileRemotePlatform(ConfigFactory.getConfig().mobileRemotePlatform())
                .build();
        return DriverFactory.getDriverforMobile(ConfigFactory.getConfig().runMode()).getDriver(driverData);
    }

    public static void quitDriver(){

    }

}
