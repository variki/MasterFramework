package com.master.driver.mobile.remote;

import com.master.enums.MobilePlatformType;
import com.master.enums.MobileRemotePlatform;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public final class MobileRemoteDriverFactory {
    private MobileRemoteDriverFactory(){}

    private static Map<MobileRemotePlatform, Function<MobilePlatformType,WebDriver>> MAP = new EnumMap(MobileRemotePlatform.class);
    static{
        MAP.put(MobileRemotePlatform.BROWSER_STACK, MobileBrowserStackFactory::getDriver);
        MAP.put(MobileRemotePlatform.SAUCE_LAB, MobileSauceLabFactory::getDriver);
    }
    public static WebDriver getDriver(MobileRemotePlatform mobileRemotePlatform,MobilePlatformType mobilePlatformType){
        return MAP.get(mobileRemotePlatform).apply(mobilePlatformType);
    }
}
