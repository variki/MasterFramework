package com.master.driver;

import com.master.driver.entity.MobileDriverData;
import com.master.driver.entity.WebDriverData;
import com.master.driver.mobile.local.MobileLocalDriverFactory;
import com.master.driver.web.local.LocalDriverFactory;
import org.openqa.selenium.WebDriver;

public class LocalMobileDriverImpl implements IMobileDriver{
    @Override
    public WebDriver getDriver(MobileDriverData mobileDriverData) {
        return MobileLocalDriverFactory.getDriver(mobileDriverData.getMobilePlatformType());
    }


}
