package com.master.driver;

import com.master.driver.entity.MobileDriverData;
import org.openqa.selenium.WebDriver;

public interface IMobileDriver {

    WebDriver getDriver(MobileDriverData mobileDriverData);
}
