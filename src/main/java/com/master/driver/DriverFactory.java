package com.master.driver;

import com.master.driver.entity.MobileDriverData;
import com.master.driver.entity.WebDriverData;
import com.master.driver.mobile.local.MobileLocalDriverFactory;
import com.master.driver.mobile.remote.MobileRemoteDriverFactory;
import com.master.driver.web.local.LocalDriverFactory;
import com.master.driver.web.remote.RemoteDriverFactory;
import com.master.enums.RunMode;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {

    private DriverFactory(){}
    private static final Map<RunMode, Supplier<IWebDriver>> WEB = new EnumMap<>(RunMode.class);
    private static final Map<RunMode, Supplier<IMobileDriver>> MOBILE = new EnumMap<>(RunMode.class);

    static {
        WEB.put(RunMode.LOCAL,LocalWebDriverImpl::new);
        WEB.put(RunMode.REMOTE,RemoteWebDriverImpl::new);
        MOBILE.put(RunMode.LOCAL,LocalMobileDriverImpl::new);
        MOBILE.put(RunMode.REMOTE,RemoteMobileDriverImpl::new);

    }

    public static IWebDriver getDriverforWeb(RunMode runMode){
         return WEB.get(runMode).get();
    }

    public static IMobileDriver getDriverforMobile(RunMode runMode){
        return MOBILE.get(runMode).get();

    }
}
