package com.master.config.converters;

import com.master.enums.MobileRemotePlatform;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToRemotePlatformConverter implements Converter<MobileRemotePlatform> {
    @Override
    public MobileRemotePlatform convert(Method method, String remotePlatform) {
        return MobileRemotePlatform.valueOf(remotePlatform.toUpperCase());
    }
}
