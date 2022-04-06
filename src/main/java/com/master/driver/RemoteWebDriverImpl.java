package com.master.driver;

import com.master.driver.entity.WebDriverData;
import com.master.driver.web.remote.RemoteDriverFactory;
import org.openqa.selenium.WebDriver;

public class RemoteWebDriverImpl implements IWebDriver {
    @Override
    public WebDriver getDriver(WebDriverData webDriverData) {
        return RemoteDriverFactory.getDriver(webDriverData.getWebRemoteRunMode(),webDriverData.getBrowserType());
    }
}
