package com.master.driver;

import com.master.driver.entity.MobileDriverData;
import com.master.enums.PlatformType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;

import static com.master.enums.PlatformType.*;
import static java.lang.ThreadLocal.*;

public final class DriverManager {

    public DriverManager(){}

    private final static ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    private final static ThreadLocal<WebDriver> MOBILE_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    private final static ThreadLocal<PlatformType> context = withInitial(()-> WEB);
    private final static Map<PlatformType,ThreadLocal<WebDriver>> DRIVER_MAP = new EnumMap<>(PlatformType.class);

    public static void setDriver(WebDriver driver){
        if(isMobileDriver(driver)){
            MOBILE_DRIVER_THREAD_LOCAL.set(driver);
            context.set(MOBILE);
            DRIVER_MAP.put(MOBILE, MOBILE_DRIVER_THREAD_LOCAL);
        }else{
            WEB_DRIVER_THREAD_LOCAL.set(driver);
            context.set(WEB);
            DRIVER_MAP.put(WEB,WEB_DRIVER_THREAD_LOCAL);
        }

    }

    public static WebDriver getDriver(){
        return context.get() == WEB
        ? WEB_DRIVER_THREAD_LOCAL.get()
                : MOBILE_DRIVER_THREAD_LOCAL.get();
    }

    public static void unload(){
        WEB_DRIVER_THREAD_LOCAL.remove();
        MOBILE_DRIVER_THREAD_LOCAL.remove();
        context.remove();
    }

    private static Boolean isMobileDriver(WebDriver driver){
        return driver instanceof AndroidDriver || driver instanceof IOSDriver;
    }
}
