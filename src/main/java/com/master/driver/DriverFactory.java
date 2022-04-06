package com.master.driver;

import com.master.driver.entity.MobileDriverData;
import com.master.driver.entity.WebDriverData;
import com.master.driver.mobile.local.MobileLocalDriverFactory;
import com.master.driver.mobile.remote.MobileRemoteDriverFactory;
import com.master.driver.web.local.LocalDriverFactory;
import com.master.driver.web.remote.RemoteDriverFactory;
import com.master.enums.RunMode;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriverforWeb(WebDriverData webDriverData){
         return webDriverData.getRunMode() == RunMode.LOCAL
                 ? new LocalWebDriverImpl().getDriver(webDriverData)
                 : new RemoteWebDriverImpl().getDriver(webDriverData);
    }

    public static WebDriver getDriverforMobile(MobileDriverData mobileDriverData){
        return mobileDriverData.getRunMode() == RunMode.LOCAL
        ? new LocalMobileDriverImpl().getDriver(mobileDriverData)
                : new RemoteMobileDriverImpl().getDriver(mobileDriverData);

    }
}
