package com.master.driver.mobile.local;

import com.master.driver.manager.mobile.local.AndriodDriverManager;
import com.master.driver.manager.mobile.local.IosDriverManager;
import com.master.enums.MobilePlatformType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class MobileLocalDriverFactory {
    private MobileLocalDriverFactory(){

    }
    private final static Map<MobilePlatformType, Supplier<WebDriver>> MAP = new EnumMap<>(MobilePlatformType.class);
    static{
        MAP.put(MobilePlatformType.IOS, IosDriverManager::getDriver);
        MAP.put(MobilePlatformType.ANDROID, AndriodDriverManager::getDriver);
    }
    public static WebDriver getDriver(MobilePlatformType mobilePlatformType){
        return MAP.get(mobilePlatformType).get();

    }
}
