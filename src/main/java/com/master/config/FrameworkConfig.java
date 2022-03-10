package com.master.config;

import com.master.config.Converters.StringToBrowserTypeConverter;
import com.master.enums.BrowserType;
import org.aeonbits.owner.Config;

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
}
