package com.master.config;

import com.master.config.converters.*;
import com.master.enums.*;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties",
        "classpath:${user.dir}/target/test-classes/config.properties",
        "file:${user.dir}/src/test/resources/staging-config.properties",
        "file:${user.dir}/src/test/resources/dev-config.properties",
})

public interface FrameworkConfig extends Config {

    @DefaultValue("staging")
    String environment();

    @Key("${environment}.webURL")
    String webURL();

    @DefaultValue("Chrome")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();

    @Key("runMode")
    @DefaultValue("remote")
    @ConverterClass(StringToRunModeConverter.class)
    RunMode runMode();

    @Key("webRemoteRunMode")
    @DefaultValue("SELENIUM")
    @ConverterClass(StringToRemoteRunModeConverter.class)
    WebRemoteRunMode webRemoteRunMode();

    @Key("seleniumGridURL")
    @ConverterClass(StringToGridURLConverter.class)
    URL seleniumGridURL();

    @Key("selenoidURL")
    @ConverterClass(StringToURLConverter.class)
    URL selenoidURL();

    @Key("mobilePlatform")
    @ConverterClass(StringToMobilePlatformConverter.class)
    MobilePlatformType mobilePlatform();

    @Key("mobileRemotePlatform")
    @ConverterClass(StringToRemotePlatformConverter.class)
    MobileRemotePlatform mobileRemotePlatform();

    @Key("localAppiumServerURL")
    @ConverterClass(StringToURLConverter.class)
    URL localAppiumServerURL();





}
