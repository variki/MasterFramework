package com.master.tests;

import com.master.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class webBase {
    static WebDriver driver = null;
    @BeforeMethod
    public void setUpDriver()
    {
       driver = Driver.initDriverforWeb();
       // driver.get("https://google.co.in");

    }

    @AfterMethod
    public void quitDriver(){

        //if(driver != null)
           driver.quit();
    }
}
