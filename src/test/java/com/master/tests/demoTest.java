package com.master.tests;

import com.master.config.BrowserStackConfig;
import com.master.config.factory.BrowserStackConfigFactory;
import com.master.config.factory.ConfigFactory;
import com.master.driver.web.remote.BrowserStackFactory;
import org.testng.annotations.Test;

public class demoTest extends webBase {

    // Local, Remote(Selenium Grid, Seleoid and browserStack)  chrome and firefox

    @Test
    public void TestLogin() {
       System.out.println(BrowserStackConfigFactory.getConfig().browserStackURL());



    }
}
