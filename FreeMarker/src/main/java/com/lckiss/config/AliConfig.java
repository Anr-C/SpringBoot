package com.lckiss.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ali.zhima")
public class AliConfig {
//    @Value("${ali.zhima.key}")
    private String key;

//    @Value("${ali.zhima.appId}")
    private String appId;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
