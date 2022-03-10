package com.master.config.converters;

import com.master.enums.RemoteRunMode;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToRemoteRunModeConverter implements Converter<RemoteRunMode> {
    @Override
    public RemoteRunMode convert(Method method, String remoteRunMode) {
        return RemoteRunMode.valueOf(remoteRunMode);
    }
}
