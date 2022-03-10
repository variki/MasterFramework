package com.master.driver.web.remote;

import com.master.config.factory.ConfigFactory;
import com.master.driver.web.remote.BrowserStackFactory;
import com.master.driver.web.remote.SeleniumGridFactory;
import com.master.driver.web.remote.SelenoidFactory;
import com.master.enums.BrowserType;
import com.master.enums.RemoteRunMode;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactory {

    private RemoteDriverFactory(){

    }

    public static WebDriver getDriver(RemoteRunMode remoteRunMode, BrowserType browserType) {

        if (ConfigFactory.getConfig().remoteRunMode() == RemoteRunMode.SELENIUM) {
            return SeleniumGridFactory.getDriver(browserType);
        } else if (ConfigFactory.getConfig().remoteRunMode() == RemoteRunMode.SELENOID) {
            return SelenoidFactory.getDriver(browserType);
        } else {
                return BrowserStackFactory.getDriver(browserType);
        }
    }


}
