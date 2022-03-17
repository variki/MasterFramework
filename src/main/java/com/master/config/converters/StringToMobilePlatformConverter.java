package com.master.config.converters;

import com.master.enums.MobilePlatformType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToMobilePlatformConverter implements Converter<MobilePlatformType> {
    @Override
    public MobilePlatformType convert(Method method, String mobilePlatform) {
        return MobilePlatformType.valueOf(mobilePlatform.toUpperCase());
    }
}
