package com.master.driver;

import com.master.driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public interface IWebDriver {

    WebDriver getDriver(WebDriverData webDriverData);
}
