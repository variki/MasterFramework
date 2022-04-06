package com.master.driver.entity;

import com.master.enums.*;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class MobileDriverData {

    private RunMode runMode;
    private MobilePlatformType mobilePlatformType;
    private MobileRemotePlatform mobileRemotePlatform;
}
