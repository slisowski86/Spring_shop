package com.github.slisowski.Spring_shop;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("task")
public
class ProductConfigurationProperties {
    private boolean allowMultipleProductInList;

    public boolean isAllowMultipleProductInList() {
        return allowMultipleProductInList;
    }

    public void setAllowMultipleProductInList(final boolean allowMultipleProductInList) {
        this.allowMultipleProductInList = allowMultipleProductInList;
    }
}
