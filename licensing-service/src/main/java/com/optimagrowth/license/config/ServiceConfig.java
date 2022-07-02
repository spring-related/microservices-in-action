package com.optimagrowth.license.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "example")
public class ServiceConfig {
    private String property;

    public String getProperty() {
        return property;
    }
}
