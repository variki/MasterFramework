package com.master.driver;

import com.master.driver.entity.WebDriverData;
import com.master.driver.web.local.LocalDriverFactory;
import org.openqa.selenium.WebDriver;

public class LocalWebDriverImpl implements IWebDriver{
    @Override
    public WebDriver getDriver(WebDriverData webDriverData) {
        return LocalDriverFactory.getDriver(webDriverData.getBrowserType());
    }
}
