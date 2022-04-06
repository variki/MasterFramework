package com.master.config.converters;

import lombok.SneakyThrows;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.net.URL;

public class StringToGridURLConverter implements Converter<URL> {
    @SneakyThrows
    @Override
    public URL convert(Method method, String stringURL) {
        if(!stringURL.contains("/wd/hub")){
            stringURL = "http://"+stringURL+":4444/wd/hub";
        }
        System.out.println("************************************");
        System.out.println("Grid url :"+stringURL);
        System.out.println("************************************");
        return new URL(stringURL);
    }
}
