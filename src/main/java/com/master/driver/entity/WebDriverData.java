package com.master.driver.entity;

import com.master.enums.BrowserType;
import com.master.enums.RunMode;
import com.master.enums.WebRemoteRunMode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WebDriverData {
    private BrowserType browserType;
    private WebRemoteRunMode webRemoteRunMode;
}
