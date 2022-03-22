package com.master.driver;

import com.master.driver.entity.DriverData;
import com.master.driver.mobile.local.MobileLocalDriverFactory;
import com.master.driver.mobile.remote.MobileRemoteDriverFactory;
import com.master.driver.web.local.LocalDriverFactory;
import com.master.driver.web.remote.RemoteDriverFactory;
import com.master.enums.RunMode;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {
    private DriverFactory(){}

    public static WebDriver getDriverforWeb(DriverData driverData){
        if(driverData.getRunMode() == RunMode.LOCAL){
            return LocalDriverFactory.getDriver(driverData.getBrowserType());
        }else{
            return RemoteDriverFactory.getDriver(driverData.getWebRemoteRunMode(),driverData.getBrowserType());
        }
    }

    public static WebDriver getDriverforMobile(DriverData driverData){
        if(driverData.getRunMode() == RunMode.LOCAL){
            return MobileLocalDriverFactory.getDriver(driverData.getMobilePlatformType());
        }else{
            return MobileRemoteDriverFactory.getDriver(driverData.getMobileRemotePlatform(),driverData.getMobilePlatformType());
        }
    }
}
