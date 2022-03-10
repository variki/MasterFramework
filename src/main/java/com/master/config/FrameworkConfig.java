package com.master.config;

import com.master.config.converters.StringToBrowserTypeConverter;
import com.master.config.converters.StringToRemoteRunModeConverter;
import com.master.config.converters.StringToRunModeConverter;
import com.master.config.converters.StringToURLConverter;
import com.master.enums.BrowserType;
import com.master.enums.RemoteRunMode;
import com.master.enums.RunMode;
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

    @Key("remoteRunMode")
    @ConverterClass(StringToRemoteRunModeConverter.class)
    RemoteRunMode remoteRunMode();

    @ConverterClass(StringToURLConverter.class)
    URL seleniumGridURL();

    @ConverterClass(StringToURLConverter.class)
    URL selenoidURL();

}
