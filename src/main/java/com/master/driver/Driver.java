package com.master.driver;

import com.master.driver.entity.MobileDriverData;
import com.master.driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;
import static com.master.config.factory.ConfigFactory.*;
import java.util.Objects;

public final class Driver {

    private static WebDriver driver;
    private Driver(){}

    public static void initDriverforWeb()
    {
        if(Objects.isNull(DriverManager.getDriver())) {
            WebDriverData driverData = new WebDriverData(getConfig().browser(), getConfig().webRemoteRunMode());
            driver = DriverFactory.getDriverforWeb(getConfig().runMode()).getDriver(driverData);
            DriverManager.setDriver(driver);
            loadURL();
        }
    }

    public static void loadURL(){
        DriverManager.getDriver().get(getConfig().webURL());
    }

    public static void initDriverforMobile()
    {
        if(Objects.isNull(DriverManager.getDriver())) {
            MobileDriverData driverData = new MobileDriverData(getConfig().mobilePlatform(), getConfig().mobileRemotePlatform());
            driver = DriverFactory.getDriverforMobile(getConfig().runMode()).getDriver(driverData);
            DriverManager.setDriver(driver);
        }
    }

    public static void quitDriver(){
     DriverManager.getDriver().quit();
    }

}
