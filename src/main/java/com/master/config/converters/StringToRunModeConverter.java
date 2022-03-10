package com.master.config.converters;

import com.master.enums.RunMode;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToRunModeConverter implements Converter<RunMode> {
    @Override
    public RunMode convert(Method method, String runmode) {
        return RunMode.valueOf(runmode);
    }
}
