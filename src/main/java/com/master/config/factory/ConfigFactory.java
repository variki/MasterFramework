package com.master.config.factory;

import com.master.config.FrameworkConfig;
import org.aeonbits.owner.ConfigCache;

public class ConfigFactory {

    private ConfigFactory(){

    }

    public static FrameworkConfig getConfig(){
        return ConfigCache.getOrCreate(FrameworkConfig.class);
    }
}
