package com.master.config.converters;

import com.master.enums.BrowserType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class StringToBrowserTypeConverter implements Converter<BrowserType> {
    @Override
    public BrowserType convert(Method method, String browserName) {
        Map<String,BrowserType> stringBrowserTypeMap = Map.of("CHROME",BrowserType.CHROME,"FIREFOX",BrowserType.FIREFOX);
       /* Map<String,BrowserType> stringBrowserTypeMap = new HashMap<String,BrowserType>()
        {
            {
                put("CHROME",BrowserType.CHROME);
                put("FIREFOX",BrowserType.FIREFOX);
            }
        };*/
        return stringBrowserTypeMap.getOrDefault(browserName.toUpperCase(),BrowserType.CHROME);

    }
}
