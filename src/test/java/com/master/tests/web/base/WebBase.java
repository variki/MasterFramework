package com.master.tests.web.base;

import com.master.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebBase {


    @BeforeMethod
    public void setUpDriver() {
        Driver.initDriverforWeb();
    }

    @AfterMethod
    public void quitDriver() {
        Driver.quitDriver();
    }
}


