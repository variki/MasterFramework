package com.master.tests;

import com.master.driver.Driver;
import com.master.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class webBase {
    static WebDriver driver = null;
    @BeforeTest
    public void setUpDriver()
    {

        Driver.initDriverforWeb();

    }

    @AfterTest
    public void quitDriver(){

//        if(driver != null)
//           driver.quit();
        Driver.quitDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
