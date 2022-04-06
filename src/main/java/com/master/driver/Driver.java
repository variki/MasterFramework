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
       /* driver = MobileRemoteDriverFactory.getDriver(ConfigFactory.getConfig().mobileRemotePlatform(),ConfigFactory.getConfig().mobilePlatform());
                //RemoteDriverFactory.getDriver(ConfigFactory.getConfig().remoteRunMode(),ConfigFactory.getConfig().browser());
                //LocalDriverFactory.getDriver(ConfigFactory.getConfig().browser());*/
       WebDriverData driverData = WebDriverData.builder()
                .runMode(ConfigFactory.getConfig().runMode())
                .browserType(ConfigFactory.getConfig().browser())
                .webRemoteRunMode(ConfigFactory.getConfig().webRemoteRunMode())
                .build();
        return DriverFactory.getDriverforWeb(driverData);
    }

    public static WebDriver initDriverforMobile()
    {

        MobileDriverData driverData = MobileDriverData.builder()
                .runMode(ConfigFactory.getConfig().runMode())
                .mobilePlatformType(ConfigFactory.getConfig().mobilePlatform())
                .mobileRemotePlatform(ConfigFactory.getConfig().mobileRemotePlatform())
                .build();
        return DriverFactory.getDriverforMobile(driverData);
    }

    public static void quitDriver(){

    }

}
