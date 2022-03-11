package com.master.driver.web.remote;

import com.master.enums.BrowserType;
import com.master.enums.RemoteRunMode;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public final class RemoteDriverFactory {

    private RemoteDriverFactory(){

    }
    private static final Map<RemoteRunMode, Function<BrowserType,WebDriver>> MAP = new EnumMap<>(RemoteRunMode.class);
    static {
        MAP.put(RemoteRunMode.SELENIUM, SeleniumGridFactory::getDriver);
        MAP.put(RemoteRunMode.SELENOID,SelenoidFactory::getDriver);
        MAP.put(RemoteRunMode.BROWSER_STACK,BrowserStackFactory::getDriver);
    }

    public static WebDriver getDriver(RemoteRunMode remoteRunMode, BrowserType browserType) {

        return MAP.get(remoteRunMode).apply(browserType);
    }


}
