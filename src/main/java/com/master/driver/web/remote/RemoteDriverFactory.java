package com.master.driver.web.remote;

import com.master.enums.BrowserType;
import com.master.enums.WebRemoteRunMode;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public final class RemoteDriverFactory {

    private RemoteDriverFactory(){

    }
    private static final Map<WebRemoteRunMode, Function<BrowserType,WebDriver>> MAP = new EnumMap<>(WebRemoteRunMode.class);
    static {
        MAP.put(WebRemoteRunMode.SELENIUM, SeleniumGridFactory::getDriver);
        MAP.put(WebRemoteRunMode.SELENOID,SelenoidFactory::getDriver);
        MAP.put(WebRemoteRunMode.BROWSER_STACK,BrowserStackFactory::getDriver);
    }

    public static WebDriver getDriver(WebRemoteRunMode remoteRunMode, BrowserType browserType) {
        System.out.println(remoteRunMode+ " and "+ browserType.toString());
        System.out.println(MAP);
        return MAP.get(remoteRunMode).apply(browserType);
    }


}
