package com.master.driver;

import com.master.driver.entity.MobileDriverData;
import com.master.driver.entity.WebDriverData;
import com.master.driver.mobile.remote.MobileRemoteDriverFactory;
import com.master.driver.web.remote.RemoteDriverFactory;
import org.openqa.selenium.WebDriver;

public class RemoteMobileDriverImpl implements IMobileDriver {

    @Override
    public WebDriver getDriver(MobileDriverData mobileDriverData) {
        return MobileRemoteDriverFactory.getDriver(mobileDriverData.getMobileRemotePlatform(),mobileDriverData.getMobilePlatformType());
    }
}
