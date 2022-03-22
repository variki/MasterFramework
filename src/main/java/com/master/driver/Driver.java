package com.master.driver;

import com.master.config.factory.ConfigFactory;
import com.master.driver.entity.DriverData;
import com.master.driver.mobile.remote.MobileRemoteDriverFactory;
import com.master.driver.web.local.LocalDriverFactory;
import com.master.driver.web.remote.RemoteDriverFactory;
import org.openqa.selenium.WebDriver;

public final class Driver {

    static WebDriver driver = null;

    private Driver(){}

    public static WebDriver initDriverforWeb()
    {
       /* driver = MobileRemoteDriverFactory.getDriver(ConfigFactory.getConfig().mobileRemotePlatform(),ConfigFactory.getConfig().mobilePlatform());
                //RemoteDriverFactory.getDriver(ConfigFactory.getConfig().remoteRunMode(),ConfigFactory.getConfig().browser());
                //LocalDriverFactory.getDriver(ConfigFactory.getConfig().browser());*/
       DriverData driverData = DriverData.builder()
                .runMode(ConfigFactory.getConfig().runMode())
                .browserType(ConfigFactory.getConfig().browser())
                .webRemoteRunMode(ConfigFactory.getConfig().webRemoteRunMode())
                .build();
        return DriverFactory.getDriverforWeb(driverData);
    }

    public static WebDriver initDriverforMobile()
    {

        DriverData driverData = DriverData.builder()
                .runMode(ConfigFactory.getConfig().runMode())
                .mobilePlatformType(ConfigFactory.getConfig().mobilePlatform())
                .mobileRemotePlatform(ConfigFactory.getConfig().mobileRemotePlatform())
                .build();
        return DriverFactory.getDriverforMobile(driverData);
    }

    public static void quitDriver(){

    }

}
