package com.github.slisowski.Spring_shop.controller;

import com.github.slisowski.Spring_shop.ProductConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MyPropController {


    private DataSourceProperties datasource;
    private ProductConfigurationProperties myProp;

    MyPropController(final DataSourceProperties datasource, final ProductConfigurationProperties myProp) {
        this.datasource = datasource;
        this.myProp = myProp;

    }

    @Value("${product.allowMultipleProductInList}")
    private String prop;

    @GetMapping("info/url")
    String url() {
        return datasource.getUrl();
    }

    @GetMapping("info/prop")
    boolean myProp() {
        return myProp.isAllowMultipleProductInList();
    }
}
