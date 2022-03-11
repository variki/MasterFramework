package com.master.driver.web.local;

import com.master.driver.manager.web.local.ChromeDriverManager;
import com.master.driver.manager.web.local.FireFoxDriverManager;
import com.master.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class LocalDriverFactory {
    private LocalDriverFactory() {
    }

    private static final Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);
    static{
        MAP.put(BrowserType.CHROME,ChromeDriverManager::getDriver);
        MAP.put(BrowserType.FIREFOX, FireFoxDriverManager::getDriver);
    }
    public static WebDriver getDriver(BrowserType browserType){
        return MAP.get(browserType).get();
    }


}
