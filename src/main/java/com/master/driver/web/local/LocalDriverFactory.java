package com.master.driver.web.local;

import com.master.driver.manager.web.local.ChromeDriverManager;
import com.master.driver.manager.web.local.FireFoxDriverManager;
import com.master.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class LocalDriverFactory {
    private LocalDriverFactory() {
    }

    public static WebDriver getDriver(BrowserType browserType){


        return browserType == BrowserType.CHROME ? ChromeDriverManager.getDriver() : FireFoxDriverManager.getDriver();
    }


}
