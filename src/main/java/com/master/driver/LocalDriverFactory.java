package com.master.driver;

import com.master.driver.manager.ChromeDriverManager;
import com.master.driver.manager.FireFoxDriverManager;
import com.master.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class LocalDriverFactory {
    private LocalDriverFactory() {
    }

    public static WebDriver getDriver(BrowserType browserType){


        return browserType == BrowserType.CHROME ? ChromeDriverManager.getDriver() : FireFoxDriverManager.getDriver();
    }


}
