package com.master.driver.entity;

import com.master.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class MobileDriverData {
    private MobilePlatformType mobilePlatformType;
    private MobileRemotePlatform mobileRemotePlatform;
}
