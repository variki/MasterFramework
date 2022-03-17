package com.master.driver.mobile.remote;

import com.master.driver.manager.mobile.remote.BrowserStackAndriodManager;
import com.master.driver.manager.mobile.remote.BrowserStackIOSManager;
import com.master.enums.MobilePlatformType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class MobileBrowserStackFactory {
    private MobileBrowserStackFactory(){}

    private final static Map<MobilePlatformType, Supplier<WebDriver>> MAP = new EnumMap<>(MobilePlatformType.class);
    static {
        MAP.put(MobilePlatformType.ANDROID, BrowserStackAndriodManager::getDriver);
        MAP.put(MobilePlatformType.IOS, BrowserStackIOSManager::getDriver);
    }
    public static WebDriver getDriver(MobilePlatformType mobilePlatformType) {
        return MAP.get(mobilePlatformType).get();
    }
}
