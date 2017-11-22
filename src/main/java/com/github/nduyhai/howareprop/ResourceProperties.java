package com.github.nduyhai.howareprop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "app")
public class ResourceProperties {

    private Map<String, String> resource;

    public Map<String, String> getResource() {
        return resource;
    }

    public void setResource(Map<String, String> resource) {
        this.resource = resource;
    }
}
