package com.master.tests;

import com.master.driver.Driver;
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
       driver = Driver.initDriverforWeb();
       // driver.get("https://google.co.in");

    }

    @AfterTest
    public void quitDriver(){

        //if(driver != null)
           driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
