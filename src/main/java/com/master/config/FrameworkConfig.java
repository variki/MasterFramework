package com.master.config;

import com.master.config.converters.*;
import com.master.enums.*;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties"
})

public interface FrameworkConfig extends Config {

    @DefaultValue("Chrome")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();

    @Key("runMode")
    @ConverterClass(StringToRunModeConverter.class)
    RunMode runMode();

    @Key("webRemoteRunMode")
    @ConverterClass(StringToRemoteRunModeConverter.class)
    WebRemoteRunMode webRemoteRunMode();

    @Key("seleniumGridURL")
    @ConverterClass(StringToURLConverter.class)
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
