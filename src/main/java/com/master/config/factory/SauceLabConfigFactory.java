package com.master.config.factory;

import com.master.config.BrowserStackConfig;
import com.master.config.SauceLabConfig;
import org.aeonbits.owner.ConfigCache;

public class SauceLabConfigFactory {

    private SauceLabConfigFactory(){

    }

    public static SauceLabConfig getConfig(){
        return ConfigCache.getOrCreate(SauceLabConfig.class);
    }
}
