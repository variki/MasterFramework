package com.master.config.converters;

import com.master.enums.WebRemoteRunMode;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToRemoteRunModeConverter implements Converter<WebRemoteRunMode> {
    @Override
    public WebRemoteRunMode convert(Method method, String remoteRunMode) {
        return WebRemoteRunMode.valueOf(remoteRunMode.toUpperCase());
    }
}
