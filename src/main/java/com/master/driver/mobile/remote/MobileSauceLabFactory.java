package com.master.driver.mobile.remote;

import com.master.driver.manager.mobile.remote.SauceLabAndriodManager;
import com.master.driver.manager.mobile.remote.SauceLabIOSManager;
import com.master.enums.MobilePlatformType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class MobileSauceLabFactory {
    private MobileSauceLabFactory(){}

    private final static Map<MobilePlatformType, Supplier<WebDriver>> MAP = new EnumMap<>(MobilePlatformType.class);
    static {
        MAP.put(MobilePlatformType.ANDROID, SauceLabAndriodManager::getDriver);
        MAP.put(MobilePlatformType.IOS, SauceLabIOSManager::getDriver);
    }

    public static WebDriver getDriver(MobilePlatformType mobilePlatformType) {
        return MAP.get(mobilePlatformType).get();
    }
}
