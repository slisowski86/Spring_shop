package com.github.slisowski.Spring_shop.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("product")
public class ProductConfigurationProperties {

    private boolean allowMultipleProductsFromTemplate;

    public boolean isAllowMultipleProductsFromTemplate() {
        return allowMultipleProductsFromTemplate;
    }

    public void setAllowMultipleProductsFromTemplate(boolean allowMultipleProductsFromTemplate) {
        this.allowMultipleProductsFromTemplate = allowMultipleProductsFromTemplate;
    }
}
