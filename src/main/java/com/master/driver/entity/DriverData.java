package com.master.driver.entity;

import com.master.enums.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public final class DriverData {

    private RunMode runMode;
    private BrowserType browserType;
    private WebRemoteRunMode webRemoteRunMode;
    private MobilePlatformType mobilePlatformType;
    private MobileRemotePlatform mobileRemotePlatform;

}
