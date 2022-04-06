package com.master.driver.entity;

import com.master.enums.BrowserType;
import com.master.enums.RunMode;
import com.master.enums.WebRemoteRunMode;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WebDriverData {
    private RunMode runMode;
    private BrowserType browserType;
    private WebRemoteRunMode webRemoteRunMode;
}
